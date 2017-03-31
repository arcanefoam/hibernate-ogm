/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
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

import fr.inria.atlanmod.neoemf.option.CommonOptionsBuilder;


/**
 * Provides access to NeoEmf
 *
 * @author Horacio Hoyos
 */
public class NeoEmfDatastoreProvider extends BaseDatastoreProvider implements Startable, Stoppable,
		ServiceRegistryAwareService, Configurable {
	
	
	private static final Log log = LoggerFactory.getLogger();
	
	private ServiceRegistryImplementor serviceRegistry;
	
	private Resource resource;

	private NeoEmfConfiguration config;
	
	/* (non-Javadoc)
	 * @see org.hibernate.ogm.datastore.spi.DatastoreProvider#getDefaultDialect()
	 */
	@Override
	public Class<? extends GridDialect> getDefaultDialect() {
		log.info("getDefaultDialect() ");
		return NeoEmfDialect.class;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.service.spi.Configurable#configure(java.util.Map)
	 */
	@Override
	public void configure(Map configurationValues) {
		log.info("configure() ");
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
		String resource_name = config.getDatabaseName();
		resource_name = resource_name.replaceAll("\\\\", "/");
		URI resource_uri = URI.createURI(resource_name);
		ResourceSet resourceSet = new ResourceSetImpl(); 
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		if (config.isCreateDatabase()) {
			resource = resourceSet.createResource(resource_uri);
		}
		else {
			try {
				resource = resourceSet.getResource(resource_uri, true);
			}
			catch (RuntimeException e) {
				throw log.unableToLoadResource( e );
			}		
		}
	}

	public Resource getConnection() {
		return resource;
	}

	public void removeResource() {
		ResourceSet rs = resource.getResourceSet();
		rs.getResources().remove(resource);
		resource.getContents().clear();
	}

}
