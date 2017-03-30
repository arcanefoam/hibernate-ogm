package org.hibernate.ogm.datastore.neoemf.test;
import org.eclipse.emf.ecore.resource.Resource;
import org.hibernate.ogm.datastore.neoemf.impl.NeoEmfDatastoreProvider;
import org.hibernate.ogm.datastore.spi.DatastoreProvider;
import org.hibernate.ogm.utils.OgmTestCase;

public abstract class NeoEmfTestCase extends OgmTestCase {

	protected Resource getConnection() {
		return getProvider().getConnection();
	}

	protected NeoEmfDatastoreProvider getProvider() {
		return (NeoEmfDatastoreProvider) getSessionFactory()
				.getServiceRegistry()
				.getService( DatastoreProvider.class );
	}

}
