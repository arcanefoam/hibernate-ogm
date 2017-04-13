/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.ogm.datastore.neoemf.NeoEmfDialect;
import org.hibernate.ogm.datastore.neoemf.impl.configuration.NeoEmfConfiguration;
import org.hibernate.ogm.datastore.neoemf.logging.impl.Log;
import org.hibernate.ogm.datastore.neoemf.logging.impl.LoggerFactory;
import org.hibernate.ogm.datastore.spi.BaseDatastoreProvider;
import org.hibernate.ogm.dialect.spi.GridDialect;
import org.hibernate.ogm.options.spi.OptionsService;
import org.hibernate.ogm.util.configurationreader.spi.ConfigurationPropertyReader;
import org.hibernate.service.spi.Configurable;
import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.hibernate.service.spi.Startable;
import org.hibernate.service.spi.Stoppable;

import fr.inria.atlanmod.neoemf.data.PersistenceBackendFactoryRegistry;
import fr.inria.atlanmod.neoemf.data.blueprints.BlueprintsPersistenceBackendFactory;
import fr.inria.atlanmod.neoemf.data.blueprints.option.BlueprintsOptionsBuilder;
import fr.inria.atlanmod.neoemf.data.blueprints.util.BlueprintsURI;
import fr.inria.atlanmod.neoemf.option.CommonOptionsBuilder;
import fr.inria.atlanmod.neoemf.resource.PersistentResource;
import fr.inria.atlanmod.neoemf.resource.PersistentResourceFactory;


// TODO: Auto-generated Javadoc
/**
 * Provides access to NeoEmf.
 *
 * @author Horacio Hoyos
 */
public class NeoEmfDatastoreProvider extends BaseDatastoreProvider implements Startable, Stoppable,
		ServiceRegistryAwareService, Configurable {
	
	
	/** The logger. */
	private static final Log log = LoggerFactory.getLogger();
	
	/** The service registry. */
	private ServiceRegistryImplementor serviceRegistry;
	
	/** The resource that acts as the db connection. */
	private PersistentResource  resource;

	/** The configuration. */
	private NeoEmfConfiguration config;
	
	/* (non-Javadoc)
	 * @see org.hibernate.ogm.datastore.spi.DatastoreProvider#getDefaultDialect()
	 */
	@Override
	public Class<? extends GridDialect> getDefaultDialect() {
		return NeoEmfDialect.class;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.service.spi.Configurable#configure(java.util.Map)
	 */
	@Override
	public void configure(Map configurationValues) {
		
		OptionsService optionsService = serviceRegistry.getService( OptionsService.class );
		ClassLoaderService classLoaderService = serviceRegistry.getService( ClassLoaderService.class );
		ConfigurationPropertyReader propertyReader = new ConfigurationPropertyReader(
				configurationValues,
				classLoaderService
		);
		config = new NeoEmfConfiguration( propertyReader, optionsService.context().getGlobalOptions() );
	}

	/* (non-Javadoc)
	 * @see org.hibernate.service.spi.ServiceRegistryAwareService#injectServices(org.hibernate.service.spi.ServiceRegistryImplementor)
	 */
	@Override
	public void injectServices(ServiceRegistryImplementor serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
		
	}

	/* (non-Javadoc)
	 * @see org.hibernate.service.spi.Stoppable#stop()
	 */
	@Override
	public void stop() {
		try {
			resource.save(CommonOptionsBuilder.noOption());
		} catch (IOException e) {
			throw log.unableToSaveResource( e );
		}
		
	}

	/* (non-Javadoc)
	 * @see org.hibernate.service.spi.Startable#start()
	 */
	@Override
	public void start() {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		// Register the selected backend.
		// FIXME Figure out why this is not working. This property should be set during configuration, but it 
		// depends on NeoEmfTestHelper to be loadad and its static block executed. This is not happening at the
		// moment. Thus the environment variable is not being copied to the properties map and hence is not
		// available in the configuration
		//String backend = config.getBackend();
		String backend = System.getenv( "NEOEMF_BACKEND" );
		String resource_name = config.getDatabaseName();
		Path resource_path = Paths.get(config.getHosts().getFirst().getHost(), resource_name);
		try {
			switch (backend) {
			case "neo4j":
				log.info("NeoEmf will use Neo4J backend");
				PersistenceBackendFactoryRegistry
					.register(BlueprintsURI.SCHEME, BlueprintsPersistenceBackendFactory.getInstance());
				resourceSet.getResourceFactoryRegistry()
					.getProtocolToFactoryMap().put(BlueprintsURI.SCHEME, PersistentResourceFactory.getInstance());
				Path resoure_uri = resource_path.resolveSibling(resource_path.getFileName() + ".graphdb");
				resource = (PersistentResource) resourceSet.createResource(BlueprintsURI.createFileURI(resoure_uri.toFile()));
				break;
				//FIXME Add other backends
			}
			if (!config.isCreateDatabase()) {
				// Load the resource
				resource.load(BlueprintsOptionsBuilder.noOption());
			}
		}
		catch (RuntimeException e) {
			throw log.unableToLoadResource( e );
		} catch (IOException e) {
			throw log.unableToLoadResource( e );
		}		
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Resource getConnection() {
		return resource;
	}

	/**
	 * Removes the resource.
	 */
	public void removeResource() {
		ResourceSet rs = resource.getResourceSet();
		rs.getResources().remove(resource);
		resource.getContents().clear();
	}

}
