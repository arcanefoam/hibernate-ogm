/**
 */
package org.hibernate.ogm.backendtck.type.ogmemf;

import fr.inria.atlanmod.neoemf.core.PersistentEObject;

import java.util.UUID;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bookmark</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDescription <em>Description</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDelimiter <em>Delimiter</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getStockCount <em>Stock Count</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getUrlPort <em>Url Port</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getUserId <em>User Id</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getVisitRatio <em>Visit Ratio</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getTaxPercentage <em>Tax Percentage</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getFavourite <em>Favourite</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDisplayMask <em>Display Mask</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsPrivate <em>Is Private</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsRead <em>Is Read</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsShared <em>Is Shared</em>}</li>
 *   <li>{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getSerialNumber <em>Serial Number</em>}</li>
 * </ul>
 *
 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark()
 * @model
 * @extends PersistentEObject
 * @generated
 */
public interface Bookmark extends PersistentEObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_Description()
	 * @model unique="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delimiter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delimiter</em>' attribute.
	 * @see #setDelimiter(Character)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_Delimiter()
	 * @model unique="false"
	 * @generated
	 */
	Character getDelimiter();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDelimiter <em>Delimiter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delimiter</em>' attribute.
	 * @see #getDelimiter()
	 * @generated
	 */
	void setDelimiter(Character value);

	/**
	 * Returns the value of the '<em><b>Stock Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stock Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stock Count</em>' attribute.
	 * @see #setStockCount(Integer)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_StockCount()
	 * @model unique="false"
	 * @generated
	 */
	Integer getStockCount();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getStockCount <em>Stock Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stock Count</em>' attribute.
	 * @see #getStockCount()
	 * @generated
	 */
	void setStockCount(Integer value);

	/**
	 * Returns the value of the '<em><b>Url Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Port</em>' attribute.
	 * @see #setUrlPort(Short)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_UrlPort()
	 * @model unique="false"
	 * @generated
	 */
	Short getUrlPort();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getUrlPort <em>Url Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url Port</em>' attribute.
	 * @see #getUrlPort()
	 * @generated
	 */
	void setUrlPort(Short value);

	/**
	 * Returns the value of the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Id</em>' attribute.
	 * @see #setUserId(Long)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_UserId()
	 * @model unique="false"
	 * @generated
	 */
	Long getUserId();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getUserId <em>User Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Id</em>' attribute.
	 * @see #getUserId()
	 * @generated
	 */
	void setUserId(Long value);

	/**
	 * Returns the value of the '<em><b>Visit Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visit Ratio</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visit Ratio</em>' attribute.
	 * @see #setVisitRatio(Float)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_VisitRatio()
	 * @model unique="false"
	 * @generated
	 */
	Float getVisitRatio();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getVisitRatio <em>Visit Ratio</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visit Ratio</em>' attribute.
	 * @see #getVisitRatio()
	 * @generated
	 */
	void setVisitRatio(Float value);

	/**
	 * Returns the value of the '<em><b>Tax Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tax Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tax Percentage</em>' attribute.
	 * @see #setTaxPercentage(Double)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_TaxPercentage()
	 * @model unique="false"
	 * @generated
	 */
	Double getTaxPercentage();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getTaxPercentage <em>Tax Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tax Percentage</em>' attribute.
	 * @see #getTaxPercentage()
	 * @generated
	 */
	void setTaxPercentage(Double value);

	/**
	 * Returns the value of the '<em><b>Favourite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Favourite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favourite</em>' attribute.
	 * @see #setFavourite(Boolean)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_Favourite()
	 * @model unique="false"
	 * @generated
	 */
	Boolean getFavourite();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getFavourite <em>Favourite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favourite</em>' attribute.
	 * @see #getFavourite()
	 * @generated
	 */
	void setFavourite(Boolean value);

	/**
	 * Returns the value of the '<em><b>Display Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Mask</em>' attribute.
	 * @see #setDisplayMask(Byte)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_DisplayMask()
	 * @model unique="false"
	 * @generated
	 */
	Byte getDisplayMask();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDisplayMask <em>Display Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Mask</em>' attribute.
	 * @see #getDisplayMask()
	 * @generated
	 */
	void setDisplayMask(Byte value);

	/**
	 * Returns the value of the '<em><b>Is Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Private</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Private</em>' attribute.
	 * @see #setIsPrivate(boolean)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_IsPrivate()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsPrivate();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsPrivate <em>Is Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Private</em>' attribute.
	 * @see #isIsPrivate()
	 * @generated
	 */
	void setIsPrivate(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Read</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Read</em>' attribute.
	 * @see #setIsRead(boolean)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_IsRead()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsRead();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsRead <em>Is Read</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Read</em>' attribute.
	 * @see #isIsRead()
	 * @generated
	 */
	void setIsRead(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Shared</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Shared</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Shared</em>' attribute.
	 * @see #setIsShared(boolean)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_IsShared()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsShared();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsShared <em>Is Shared</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Shared</em>' attribute.
	 * @see #isIsShared()
	 * @generated
	 */
	void setIsShared(boolean value);

	/**
	 * Returns the value of the '<em><b>Serial Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serial Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serial Number</em>' attribute.
	 * @see #setSerialNumber(UUID)
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#getBookmark_SerialNumber()
	 * @model unique="false" dataType="org.hibernate.ogm.backendtck.type.ogmemf.UUID"
	 * @generated
	 */
	UUID getSerialNumber();

	/**
	 * Sets the value of the '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getSerialNumber <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serial Number</em>' attribute.
	 * @see #getSerialNumber()
	 * @generated
	 */
	void setSerialNumber(UUID value);

} // Bookmark
