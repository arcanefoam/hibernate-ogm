/**
 */
package org.hibernate.ogm.backendtck.type.ogmemf;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel modelDirectory='/hibernate-ogm-neoemf/src/test/java-gen' modelPluginID='' modelName='OgmTest' modelPluginClass='' rootExtendsInterface='fr.inria.atlanmod.neoemf.core.PersistentEObject' rootExtendsClass='fr.inria.atlanmod.neoemf.core.DefaultPersistentEObject' reflectiveDelegation='true' importerID='org.eclipse.emf.importer.ecore' bundleManifest='false' featureDelegation='Reflective' complianceLevel='8.0' basePackage='org.hibernate.ogm.backendtck.type'"
 *        annotation="http://www.eclipse.org/emf/2011/Xcore Ecore='http://www.eclipse.org/emf/2002/Ecore' GenModel='http://www.eclipse.org/emf/2002/GenModel'"
 * @generated
 */
public interface OgmemfPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ogmemf";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.hibernate.ogm.backendtck.type/OgmEmf.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ogmemf";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OgmemfPackage eINSTANCE = org.hibernate.ogm.backendtck.type.ogmemf.impl.OgmemfPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl <em>Bookmark</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.impl.OgmemfPackageImpl#getBookmark()
	 * @generated
	 */
	int BOOKMARK = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__DELIMITER = 1;

	/**
	 * The feature id for the '<em><b>Stock Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__STOCK_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Url Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__URL_PORT = 3;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__USER_ID = 4;

	/**
	 * The feature id for the '<em><b>Visit Ratio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__VISIT_RATIO = 5;

	/**
	 * The feature id for the '<em><b>Tax Percentage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__TAX_PERCENTAGE = 6;

	/**
	 * The feature id for the '<em><b>Favourite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__FAVOURITE = 7;

	/**
	 * The feature id for the '<em><b>Display Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__DISPLAY_MASK = 8;

	/**
	 * The feature id for the '<em><b>Is Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__IS_PRIVATE = 9;

	/**
	 * The feature id for the '<em><b>Is Read</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__IS_READ = 10;

	/**
	 * The feature id for the '<em><b>Is Shared</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__IS_SHARED = 11;

	/**
	 * The feature id for the '<em><b>Serial Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK__SERIAL_NUMBER = 12;

	/**
	 * The number of structural features of the '<em>Bookmark</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK_FEATURE_COUNT = 13;

	/**
	 * The number of operations of the '<em>Bookmark</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOKMARK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>Id</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.atlanmod.neoemf.core.Id
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.impl.OgmemfPackageImpl#getId()
	 * @generated
	 */
	int ID = 1;

	/**
	 * The meta object id for the '<em>UUID</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.UUID
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.impl.OgmemfPackageImpl#getUUID()
	 * @generated
	 */
	int UUID = 2;


	/**
	 * Returns the meta object for class '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark <em>Bookmark</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bookmark</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark
	 * @generated
	 */
	EClass getBookmark();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDescription()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDelimiter <em>Delimiter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delimiter</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDelimiter()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_Delimiter();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getStockCount <em>Stock Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stock Count</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getStockCount()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_StockCount();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getUrlPort <em>Url Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url Port</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getUrlPort()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_UrlPort();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getUserId()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_UserId();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getVisitRatio <em>Visit Ratio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visit Ratio</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getVisitRatio()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_VisitRatio();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getTaxPercentage <em>Tax Percentage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tax Percentage</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getTaxPercentage()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_TaxPercentage();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getFavourite <em>Favourite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Favourite</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getFavourite()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_Favourite();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDisplayMask <em>Display Mask</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Display Mask</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getDisplayMask()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_DisplayMask();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsPrivate <em>Is Private</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Private</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsPrivate()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_IsPrivate();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsRead <em>Is Read</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Read</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsRead()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_IsRead();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsShared <em>Is Shared</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Shared</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#isIsShared()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_IsShared();

	/**
	 * Returns the meta object for the attribute '{@link org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getSerialNumber <em>Serial Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Serial Number</em>'.
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.Bookmark#getSerialNumber()
	 * @see #getBookmark()
	 * @generated
	 */
	EAttribute getBookmark_SerialNumber();

	/**
	 * Returns the meta object for data type '{@link fr.inria.atlanmod.neoemf.core.Id <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Id</em>'.
	 * @see fr.inria.atlanmod.neoemf.core.Id
	 * @model instanceClass="fr.inria.atlanmod.neoemf.core.Id"
	 * @generated
	 */
	EDataType getId();

	/**
	 * Returns the meta object for data type '{@link java.util.UUID <em>UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UUID</em>'.
	 * @see java.util.UUID
	 * @model instanceClass="java.util.UUID"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel create='<%java.util.UUID%> _xtrycatchfinallyexpression = null;\ntry\n{\n\t<%java.util.UUID%> _xifexpression = null;\n\tboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(it, null));\n\tif (_notEquals)\n\t{\n\t\t_xifexpression = <%java.util.UUID%>.fromString(it);\n\t}\n\t_xtrycatchfinallyexpression = _xifexpression;\n}\ncatch (final Throwable _t) {\n\tif (_t instanceof <%java.lang.IllegalArgumentException%>) {\n\t\tfinal <%java.lang.IllegalArgumentException%> ex = (<%java.lang.IllegalArgumentException%>)_t;\n\t\tthrow new <%java.lang.RuntimeException%>(ex);\n\t}\n\telse\n\t{\n\t\tthrow <%org.eclipse.xtext.xbase.lib.Exceptions%>.sneakyThrow(_t);\n\t}\n}\nreturn _xtrycatchfinallyexpression;' convert='<%java.lang.String%> _xifexpression = null;\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(it, null));\nif (_notEquals)\n{\n\t_xifexpression = it.toString();\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	EDataType getUUID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OgmemfFactory getOgmemfFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl <em>Bookmark</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.hibernate.ogm.backendtck.type.ogmemf.impl.BookmarkImpl
		 * @see org.hibernate.ogm.backendtck.type.ogmemf.impl.OgmemfPackageImpl#getBookmark()
		 * @generated
		 */
		EClass BOOKMARK = eINSTANCE.getBookmark();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__DESCRIPTION = eINSTANCE.getBookmark_Description();

		/**
		 * The meta object literal for the '<em><b>Delimiter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__DELIMITER = eINSTANCE.getBookmark_Delimiter();

		/**
		 * The meta object literal for the '<em><b>Stock Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__STOCK_COUNT = eINSTANCE.getBookmark_StockCount();

		/**
		 * The meta object literal for the '<em><b>Url Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__URL_PORT = eINSTANCE.getBookmark_UrlPort();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__USER_ID = eINSTANCE.getBookmark_UserId();

		/**
		 * The meta object literal for the '<em><b>Visit Ratio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__VISIT_RATIO = eINSTANCE.getBookmark_VisitRatio();

		/**
		 * The meta object literal for the '<em><b>Tax Percentage</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__TAX_PERCENTAGE = eINSTANCE.getBookmark_TaxPercentage();

		/**
		 * The meta object literal for the '<em><b>Favourite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__FAVOURITE = eINSTANCE.getBookmark_Favourite();

		/**
		 * The meta object literal for the '<em><b>Display Mask</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__DISPLAY_MASK = eINSTANCE.getBookmark_DisplayMask();

		/**
		 * The meta object literal for the '<em><b>Is Private</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__IS_PRIVATE = eINSTANCE.getBookmark_IsPrivate();

		/**
		 * The meta object literal for the '<em><b>Is Read</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__IS_READ = eINSTANCE.getBookmark_IsRead();

		/**
		 * The meta object literal for the '<em><b>Is Shared</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__IS_SHARED = eINSTANCE.getBookmark_IsShared();

		/**
		 * The meta object literal for the '<em><b>Serial Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOKMARK__SERIAL_NUMBER = eINSTANCE.getBookmark_SerialNumber();

		/**
		 * The meta object literal for the '<em>Id</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.atlanmod.neoemf.core.Id
		 * @see org.hibernate.ogm.backendtck.type.ogmemf.impl.OgmemfPackageImpl#getId()
		 * @generated
		 */
		EDataType ID = eINSTANCE.getId();

		/**
		 * The meta object literal for the '<em>UUID</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.UUID
		 * @see org.hibernate.ogm.backendtck.type.ogmemf.impl.OgmemfPackageImpl#getUUID()
		 * @generated
		 */
		EDataType UUID = eINSTANCE.getUUID();

	}

} //OgmemfPackage
