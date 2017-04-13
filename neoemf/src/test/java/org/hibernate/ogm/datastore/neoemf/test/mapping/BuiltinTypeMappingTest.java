package org.hibernate.ogm.datastore.neoemf.test.mapping;

import static org.hibernate.ogm.datastore.neoemf.utils.NeoEmfGridDialectTestHelper.rowAssertion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.backendtck.type.ogmemf.Bookmark;
import org.hibernate.ogm.backendtck.type.ogmemf.OgmemfFactory;
import org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl;
import org.hibernate.ogm.datastore.neoemf.impl.NeoEmfDatastoreProvider;
import org.hibernate.ogm.utils.OgmTestCase;
import org.hibernate.ogm.utils.PackagingRule;
import org.hibernate.ogm.utils.TestHelper;
import org.hibernate.ogm.utils.jpa.GetterPersistenceUnitInfo;
import org.hibernate.ogm.utils.jpa.OgmJpaTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.inria.atlanmod.neoemf.core.Id;
 
public class BuiltinTypeMappingTest extends OgmJpaTestCase {
	
	@Rule
	public PackagingRule packaging = new PackagingRule( "persistence.xml", BookmarkImpl.class );
	
	private static final BigDecimal PI = new BigDecimal( "3.14159265359" );
	
	private Id bookmarkId;
	
//	@Before
//	public void setUpTestData() {
//		System.out.println("setUpTestData");
//		OgmSession session = openSession();
//		Transaction transaction = session.beginTransaction();
//
//		Bookmark bookmark = OgmemfFactory.eINSTANCE.createBookmark();
//		bookmark.setFavourite( Boolean.TRUE );
//		bookmark.setIsPrivate( true );
//		bookmark.setIsRead( true );
//		bookmark.setIsShared( true );
//		bookmark.setSerialNumber( UUID.fromString( "59339fd6-b3d5-4876-a031-9ab43f09e642" ) );
////		bookmark.setSiteWeight( PI );
//		session.persist( bookmark );
//		transaction.commit();
//		session.close();
//		
//		this.bookmarkId = bookmark.id();
//	}
//	
//	@After
//	public void removeTestData() {
////		OgmSession session = openSession();
////		Transaction transaction = session.beginTransaction();
////
////		session.delete( session.get( Bookmark.class, bookmarkId ) );
////
////		transaction.commit();
////		session.close();
//	}
	
	
	
	@Test
	public void trueFalseTypeMapping() throws Exception {
		
//		final EntityManagerFactory emf = Persistence.createEntityManagerFactory(
//				"ogm_test_database", TestHelper.getDefaultTestSettings()
//		);
		
		TransactionManager transactionManager = getTransactionManager( getFactory() );
		transactionManager.begin();
		final EntityManager em = getFactory().createEntityManager();
		Bookmark bookmark = OgmemfFactory.eINSTANCE.createBookmark();
		bookmark.setFavourite( Boolean.TRUE );
		em.persist(bookmark);
		transactionManager.commit();
		
		em.close();
	}

	@Override
	protected void configure(GetterPersistenceUnitInfo info) {
		info.setPersistenceUnitName("ogm_test_database");
		info.setMappingFileNames(getMappingFileNames());
	}

	private List<String> getMappingFileNames() {
		
		List<String> names = new ArrayList<String>();
		names.add("orm/OgmEmf-orm.xml");
		return names ;
	}

	@Override
	protected Class<?>[] getAnnotatedClasses() {
		return new Class<?>[]{ BookmarkImpl.class };
	}

}
