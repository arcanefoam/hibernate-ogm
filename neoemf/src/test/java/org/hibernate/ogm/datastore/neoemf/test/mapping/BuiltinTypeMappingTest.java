package org.hibernate.ogm.datastore.neoemf.test.mapping;

import java.math.BigDecimal;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.backendtck.type.Bookmark;
import org.hibernate.ogm.utils.OgmTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuiltinTypeMappingTest extends OgmTestCase {
	
	private static final BigDecimal PI = new BigDecimal( "3.14159265359" );
	
	private String bookmarkId;
	
	@Before
	public void setUpTestData() {
		System.out.println("setUpTestData");
//		final EntityManager em = getFactory().createEntityManager();
//		em.getTransaction().begin();
		OgmSession session = openSession();
		Transaction transaction = session.beginTransaction();

//		Bookmark bookmark = new Bookmark();
//		bookmark.setFavourite( Boolean.TRUE );
//		bookmark.setPrivate( true );
//		bookmark.setRead( true );
//		bookmark.setShared( true );
//		bookmark.setSerialNumber( UUID.fromString( "59339fd6-b3d5-4876-a031-9ab43f09e642" ) );
//		bookmark.setSiteWeight( PI );
//
//		em.persist( bookmark );
//		
//		em.getTransaction().commit();
//		em.close();
//		this.bookmarkId = bookmark.getId();
		transaction.commit();
		session.close();
		
	}
	
	@After
	public void removeTestData() {
//		OgmSession session = openSession();
//		Transaction transaction = session.beginTransaction();
//
//		session.delete( session.get( Bookmark.class, bookmarkId ) );
//
//		transaction.commit();
//		session.close();
	}
	
	@Test
	public void trueFalseTypeMapping() {
//		final EntityManager em = getFactory().createEntityManager();
//		em.getTransaction().begin();

		System.out.println("Empty test");

//		em.getTransaction().commit();
//		em.close();
}

	@Override
	protected Class<?>[] getAnnotatedClasses() {
		return new Class<?>[]{ Bookmark.class };
	}

}
