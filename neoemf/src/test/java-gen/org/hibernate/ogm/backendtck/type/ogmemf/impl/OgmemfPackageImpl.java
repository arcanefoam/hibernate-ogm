/**
 */
package org.hibernate.ogm.backendtck.type.ogmemf.impl;

import fr.inria.atlanmod.neoemf.core.Id;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.hibernate.ogm.backendtck.type.ogmemf.Bookmark;
import org.hibernate.ogm.backendtck.type.ogmemf.OgmemfFactory;
import org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OgmemfPackageImpl extends EPackageImpl implements OgmemfPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bookmarkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType idEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uuidEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.hibernate.ogm.backendtck.type.ogmemf.OgmemfPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OgmemfPackageImpl() {
		super(eNS_URI, OgmemfFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OgmemfPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OgmemfPackage init() {
		if (isInited) return (OgmemfPackage)EPackage.Registry.INSTANCE.getEPackage(OgmemfPackage.eNS_URI);

		// Obtain or create and register package
		OgmemfPackageImpl theOgmemfPackage = (OgmemfPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OgmemfPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OgmemfPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOgmemfPackage.createPackageContents();

		// Initialize created meta-data
		theOgmemfPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOgmemfPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OgmemfPackage.eNS_URI, theOgmemfPackage);
		return theOgmemfPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBookmark() {
		return bookmarkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_Description() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_Delimiter() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_StockCount() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_UrlPort() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_UserId() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_VisitRatio() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_TaxPercentage() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_Favourite() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_DisplayMask() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_IsPrivate() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_IsRead() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_IsShared() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBookmark_SerialNumber() {
		return (EAttribute)bookmarkEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getId() {
		return idEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUUID() {
		return uuidEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OgmemfFactory getOgmemfFactory() {
		return (OgmemfFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		bookmarkEClass = createEClass(BOOKMARK);
		createEAttribute(bookmarkEClass, BOOKMARK__DESCRIPTION);
		createEAttribute(bookmarkEClass, BOOKMARK__DELIMITER);
		createEAttribute(bookmarkEClass, BOOKMARK__STOCK_COUNT);
		createEAttribute(bookmarkEClass, BOOKMARK__URL_PORT);
		createEAttribute(bookmarkEClass, BOOKMARK__USER_ID);
		createEAttribute(bookmarkEClass, BOOKMARK__VISIT_RATIO);
		createEAttribute(bookmarkEClass, BOOKMARK__TAX_PERCENTAGE);
		createEAttribute(bookmarkEClass, BOOKMARK__FAVOURITE);
		createEAttribute(bookmarkEClass, BOOKMARK__DISPLAY_MASK);
		createEAttribute(bookmarkEClass, BOOKMARK__IS_PRIVATE);
		createEAttribute(bookmarkEClass, BOOKMARK__IS_READ);
		createEAttribute(bookmarkEClass, BOOKMARK__IS_SHARED);
		createEAttribute(bookmarkEClass, BOOKMARK__SERIAL_NUMBER);

		// Create data types
		idEDataType = createEDataType(ID);
		uuidEDataType = createEDataType(UUID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(bookmarkEClass, Bookmark.class, "Bookmark", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBookmark_Description(), theEcorePackage.getEString(), "description", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_Delimiter(), theEcorePackage.getECharacterObject(), "delimiter", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_StockCount(), theEcorePackage.getEIntegerObject(), "stockCount", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_UrlPort(), theEcorePackage.getEShortObject(), "urlPort", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_UserId(), theEcorePackage.getELongObject(), "userId", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_VisitRatio(), theEcorePackage.getEFloatObject(), "visitRatio", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_TaxPercentage(), theEcorePackage.getEDoubleObject(), "taxPercentage", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_Favourite(), theEcorePackage.getEBooleanObject(), "favourite", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_DisplayMask(), theEcorePackage.getEByteObject(), "displayMask", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_IsPrivate(), theEcorePackage.getEBoolean(), "isPrivate", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_IsRead(), theEcorePackage.getEBoolean(), "isRead", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_IsShared(), theEcorePackage.getEBoolean(), "isShared", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBookmark_SerialNumber(), this.getUUID(), "serialNumber", null, 0, 1, Bookmark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(idEDataType, Id.class, "Id", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uuidEDataType, java.util.UUID.class, "UUID", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2011/Xcore
		createXcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createXcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2011/Xcore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "Ecore", "http://www.eclipse.org/emf/2002/Ecore",
			 "GenModel", "http://www.eclipse.org/emf/2002/GenModel"
		   });
	}

} //OgmemfPackageImpl
