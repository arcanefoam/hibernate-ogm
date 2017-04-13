/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.utils;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.datastore.document.options.AssociationStorageType;
import org.hibernate.ogm.datastore.neoemf.NeoEmf;
import org.hibernate.ogm.datastore.neoemf.NeoEmfDialect;
import org.hibernate.ogm.datastore.neoemf.NeoEmfProperties;
import org.hibernate.ogm.datastore.neoemf.impl.NeoEmfDatastoreProvider;
import org.hibernate.ogm.datastore.spi.DatastoreConfiguration;
import org.hibernate.ogm.datastore.spi.DatastoreProvider;
import org.hibernate.ogm.dialect.spi.GridDialect;
import org.hibernate.ogm.model.key.spi.EntityKey;
import org.hibernate.ogm.utils.GridDialectTestHelper;

/**
 * Utility methods for test suite support.
 *
 * @author Horacio Hoyos
 */
public class NeoEmfGridDialectTestHelper implements GridDialectTestHelper {
	
	/**
	 * An environment variable that can be used to defined the preferred back end to use with NeoEmf 
	 */
	private static final String ENV_NEOEMF_BACKEND = "NEOEMF_BACKEND";

	static {
		// Read Persistence Backend Factory from environment variable
		String neoemfBackend = System.getenv( ENV_NEOEMF_BACKEND );
		// 
		if ( isNotNull( neoemfBackend ) ) {
			System.getProperties().setProperty( NeoEmfProperties.BACKEND, neoemfBackend );
		}
	}
	
	/**
	 * Maven's surefire plugin sets undefned environment variables to the string 'null'.
	 *
	 * @param neoemfBackend the neoemf backend
	 * @return True if the neoemfBackend value is not null or if it is not the string 'null'
	 */
	private static boolean isNotNull(String neoemfBackend) {
		return neoemfBackend != null && neoemfBackend.length() > 0 && !"null".equals( neoemfBackend );
	}

	@Override
	public boolean backendSupportsTransactions() {
		return false;
	}

	@Override
	public void dropSchemaAndDatabase(SessionFactory sessionFactory) {
		NeoEmfDatastoreProvider neoEmfDatastoreProvider = getProvider(sessionFactory);
		neoEmfDatastoreProvider.removeResource();

	}

	private static NeoEmfDatastoreProvider getProvider(SessionFactory sessionFactory) {
		DatastoreProvider provider = ((SessionFactoryImplementor) sessionFactory).getServiceRegistry().getService(
				DatastoreProvider.class );
		if (!(provider instanceof NeoEmfDatastoreProvider)) {
			throw new RuntimeException( "Not testing with NeoEmf, cannot extract underlying cache" );
		}
		return (NeoEmfDatastoreProvider) provider;
	}

	@Override
	public Map<String, Object> extractEntityTuple(Session arg0, EntityKey arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getAdditionalConfigurationProperties() {
		return Collections.emptyMap();
	}

	@Override
	public Class<? extends DatastoreConfiguration<?>> getDatastoreConfigurationType() {
		return NeoEmf.class;
	}

	@Override
	public GridDialect getGridDialect(DatastoreProvider provider) {
		return new NeoEmfDialect((NeoEmfDatastoreProvider) provider);
	}

	@Override
	public long getNumberOfAssociations(Session session) {
		return getNumberOfAssociations(session.getSessionFactory());
	}

	@Override
	public long getNumberOfAssociations(SessionFactory sessionFactory) {
		NeoEmfDatastoreProvider provider = getProvider(sessionFactory);
		long count = 0;
		TreeIterator<EObject> it = provider.getConnection().getAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof EReference) {
				count++;
			}
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.utils.GridDialectTestHelper#getNumberOfAssociations(org.hibernate.SessionFactory, org.hibernate.ogm.datastore.document.options.AssociationStorageType)
	 */
	@Override
	public long getNumberOfAssociations(SessionFactory arg0, AssociationStorageType arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getNumberOfEntities(Session session) {
		return getNumberOfEntities(session.getSessionFactory());
	}

	@Override
	public long getNumberOfEntities(SessionFactory sessionFactory) {
		NeoEmfDatastoreProvider provider = getProvider(sessionFactory);
		long count = 0;
		TreeIterator<EObject> it = provider.getConnection().getAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (!(eObject instanceof EStructuralFeature)) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Returns a {@code RowAssertionBuilder} to check a particular row.
	 *
	 * @param sessionFactory the sessionFactory
	 * @param table the table on which the row is located
	 * @return a {@code RowAssertionBuilder} to construct the assertion
	 */
	public static RowAssertionBuilder rowAssertion(OgmSessionFactory sessionFactory, String table) {
		return new RowAssertionBuilder( sessionFactory, table );
	}
	
	public static class RowAssertionBuilder {
		
		private String table;
		private OgmSessionFactory sessionFactory;

		public RowAssertionBuilder(OgmSessionFactory sessionFactory, String table) {
			this.sessionFactory = sessionFactory;
			this.table = table;
		}

	}

}
