/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.impl;

import java.io.IOException;
import java.util.Map;


import org.eclipse.emf.ecore.resource.Resource;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.ogm.datastore.neoemf.NeoEmfDialect;
import org.hibernate.ogm.datastore.neoemf.logging.impl.Log;
import org.hibernate.ogm.datastore.neoemf.logging.impl.LoggerFactory;
import org.hibernate.ogm.datastore.spi.BaseDatastoreProvider;
import org.hibernate.ogm.dialect.spi.GridDialect;
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
		ClassLoaderService classLoaderService = serviceRegistry.getService( ClassLoaderService.class );
		ConfigurationPropertyReader propertyReader = new ConfigurationPropertyReader(
				configurationValues,
				classLoaderService
		);

		// FIXME Read config!	
//		try {
//			this.config = new RedisConfiguration( propertyReader );
//		}
//		catch (Exception e) {
//			// Wrap Exception in a ServiceException to make the stack trace more friendly
//			// Otherwise a generic unable to request service is thrown
//			throw log.unableToConfigureDatastoreProvider( e );
//		}
		
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
		try {
			resource.load(CommonOptionsBuilder.noOption());
		} catch (IOException e) {
			throw log.unableToLoadResource( e );
		}
		
	}

	public Resource getConnection() {
		return resource;
	}

}
