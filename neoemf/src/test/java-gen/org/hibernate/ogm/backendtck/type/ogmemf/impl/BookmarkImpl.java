/**
 */
package org.hibernate.ogm.backendtck.type.ogmemf.impl;

import fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject;

import java.util.UUID;

import org.eclipse.emf.ecore.EClass;

import org.hibernate.ogm.backendtck.type.ogmemf.Bookmark;
import org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bookmark</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getDelimiter <em>Delimiter</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getStockCount <em>Stock Count</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getUrlPort <em>Url Port</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getVisitRatio <em>Visit Ratio</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getTaxPercentage <em>Tax Percentage</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getFavourite <em>Favourite</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getDisplayMask <em>Display Mask</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#isIsPrivate <em>Is Private</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#isIsRead <em>Is Read</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#isIsShared <em>Is Shared</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl#getSerialNumber <em>Serial Number</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BookmarkImpl extends DefaultPersistentEObject implements Bookmark {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BookmarkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OgmemfPackage.Literals.BOOKMARK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(OgmemfPackage.Literals.BOOKMARK__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(OgmemfPackage.Literals.BOOKMARK__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Character getDelimiter() {
		return (Character)eGet(OgmemfPackage.Literals.BOOKMARK__DELIMITER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelimiter(Character newDelimiter) {
		eSet(OgmemfPackage.Literals.BOOKMARK__DELIMITER, newDelimiter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getStockCount() {
		return (Integer)eGet(OgmemfPackage.Literals.BOOKMARK__STOCK_COUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStockCount(Integer newStockCount) {
		eSet(OgmemfPackage.Literals.BOOKMARK__STOCK_COUNT, newStockCount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Short getUrlPort() {
		return (Short)eGet(OgmemfPackage.Literals.BOOKMARK__URL_PORT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrlPort(Short newUrlPort) {
		eSet(OgmemfPackage.Literals.BOOKMARK__URL_PORT, newUrlPort);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getUserId() {
		return (Long)eGet(OgmemfPackage.Literals.BOOKMARK__USER_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserId(Long newUserId) {
		eSet(OgmemfPackage.Literals.BOOKMARK__USER_ID, newUserId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getVisitRatio() {
		return (Float)eGet(OgmemfPackage.Literals.BOOKMARK__VISIT_RATIO, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisitRatio(Float newVisitRatio) {
		eSet(OgmemfPackage.Literals.BOOKMARK__VISIT_RATIO, newVisitRatio);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getTaxPercentage() {
		return (Double)eGet(OgmemfPackage.Literals.BOOKMARK__TAX_PERCENTAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaxPercentage(Double newTaxPercentage) {
		eSet(OgmemfPackage.Literals.BOOKMARK__TAX_PERCENTAGE, newTaxPercentage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getFavourite() {
		return (Boolean)eGet(OgmemfPackage.Literals.BOOKMARK__FAVOURITE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFavourite(Boolean newFavourite) {
		eSet(OgmemfPackage.Literals.BOOKMARK__FAVOURITE, newFavourite);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Byte getDisplayMask() {
		return (Byte)eGet(OgmemfPackage.Literals.BOOKMARK__DISPLAY_MASK, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayMask(Byte newDisplayMask) {
		eSet(OgmemfPackage.Literals.BOOKMARK__DISPLAY_MASK, newDisplayMask);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsPrivate() {
		return (Boolean)eGet(OgmemfPackage.Literals.BOOKMARK__IS_PRIVATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPrivate(boolean newIsPrivate) {
		eSet(OgmemfPackage.Literals.BOOKMARK__IS_PRIVATE, newIsPrivate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsRead() {
		return (Boolean)eGet(OgmemfPackage.Literals.BOOKMARK__IS_READ, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsRead(boolean newIsRead) {
		eSet(OgmemfPackage.Literals.BOOKMARK__IS_READ, newIsRead);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsShared() {
		return (Boolean)eGet(OgmemfPackage.Literals.BOOKMARK__IS_SHARED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsShared(boolean newIsShared) {
		eSet(OgmemfPackage.Literals.BOOKMARK__IS_SHARED, newIsShared);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UUID getSerialNumber() {
		return (UUID)eGet(OgmemfPackage.Literals.BOOKMARK__SERIAL_NUMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerialNumber(UUID newSerialNumber) {
		eSet(OgmemfPackage.Literals.BOOKMARK__SERIAL_NUMBER, newSerialNumber);
	}

} //BookmarkImpl
