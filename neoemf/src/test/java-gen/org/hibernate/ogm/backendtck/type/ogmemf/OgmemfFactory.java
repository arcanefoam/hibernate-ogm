/**
 */
package org.hibernate.ogm.backendtck.type.ogmemf;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage
 * @generated
 */
public interface OgmemfFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OgmemfFactory eINSTANCE = org.hibernate.ogm.backendtck.type.ogmemf.impl.OgmemfFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bookmark</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bookmark</em>'.
	 * @generated
	 */
	Bookmark createBookmark();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OgmemfPackage getOgmemfPackage();

} //OgmemfFactory
