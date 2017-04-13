package org.hibernate.ogm.datastore.neoemf.dialect.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.hibernate.ogm.model.key.spi.EntityKeyMetadata;
import org.hibernate.ogm.model.spi.TupleSnapshot;

public class NeoEmfTupleSnapshot implements TupleSnapshot {
	
	private final EObject dbObject;
	private final EntityKeyMetadata keyMetadata;
	//private final EList<EStructuralFeature> eAllStructuralFeatures;


	public NeoEmfTupleSnapshot(EObject dbObject, EntityKeyMetadata keyMetadata) {
		this.dbObject = dbObject;
		this.keyMetadata = keyMetadata;
		//EClass ec = dbObject.eClass();
		//eAllStructuralFeatures = ec.getEAllStructuralFeatures();
	}

	@Override
	public Object get(String column) {
		EClass ec = dbObject.eClass();
		EStructuralFeature sf = ec.getEStructuralFeature(column);
		if (dbObject.eIsSet(sf)) {
			return dbObject.eGet(sf);
		}
		return null;
	}


	@Override
	public boolean isEmpty() {
//		for (EStructuralFeature sf : eAllStructuralFeatures) {
//			if (dbObject.eIsSet(sf)) {
//				return true;
//			}
//		}
		return false;
	}

	@Override
	public Set<String> getColumnNames() {
		
		Set<String> names = new HashSet<String>();
//		for (EStructuralFeature sf : eAllStructuralFeatures) {
//			names.add(sf.getName());
//		}
		return names;
	}

}
