/**
 */
package org.hibernate.ogm.backendtck.type.ogmemf.impl;

import com.google.common.base.Objects;

import fr.inria.atlanmod.neoemf.core.Id;

import java.util.UUID;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xbase.lib.Exceptions;

import org.hibernate.ogm.backendtck.type.ogmemf.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OgmemfFactoryImpl extends EFactoryImpl implements OgmemfFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OgmemfFactory init() {
		try {
			OgmemfFactory theOgmemfFactory = (OgmemfFactory)EPackage.Registry.INSTANCE.getEFactory(OgmemfPackage.eNS_URI);
			if (theOgmemfFactory != null) {
				return theOgmemfFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OgmemfFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OgmemfFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OgmemfPackage.BOOKMARK: return (EObject)createBookmark();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OgmemfPackage.ID:
				return createIdFromString(eDataType, initialValue);
			case OgmemfPackage.UUID:
				return createUUIDFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OgmemfPackage.ID:
				return convertIdToString(eDataType, instanceValue);
			case OgmemfPackage.UUID:
				return convertUUIDToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Bookmark createBookmark() {
		BookmarkImpl bookmark = new BookmarkImpl();
		return bookmark;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Id createIdFromString(EDataType eDataType, String initialValue) {
		return (Id)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIdToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UUID createUUID(final String it) {
		UUID _xtrycatchfinallyexpression = null;
		try {
			UUID _xifexpression = null;
			boolean _notEquals = (!Objects.equal(it, null));
			if (_notEquals) {
				_xifexpression = UUID.fromString(it);
			}
			_xtrycatchfinallyexpression = _xifexpression;
		}
		catch (final Throwable _t) {
			if (_t instanceof IllegalArgumentException) {
				final IllegalArgumentException ex = (IllegalArgumentException)_t;
				throw new RuntimeException(ex);
			}
			else {
				throw Exceptions.sneakyThrow(_t);
			}
		}
		return _xtrycatchfinallyexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UUID createUUIDFromString(EDataType eDataType, String initialValue) {
		return createUUID(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUUID(final UUID it) {
		String _xifexpression = null;
		boolean _notEquals = (!Objects.equal(it, null));
		if (_notEquals) {
			_xifexpression = it.toString();
		}
		return _xifexpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUUIDToString(EDataType eDataType, Object instanceValue) {
		return convertUUID((UUID)instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OgmemfPackage getOgmemfPackage() {
		return (OgmemfPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OgmemfPackage getPackage() {
		return OgmemfPackage.eINSTANCE;
	}

} //OgmemfFactoryImpl
