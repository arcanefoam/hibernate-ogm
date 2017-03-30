package org.hibernate.ogm.datastore.neoemf;

import org.hibernate.LockMode;
import org.hibernate.dialect.lock.LockingStrategy;
import org.hibernate.ogm.datastore.neoemf.logging.impl.Log;
import org.hibernate.ogm.datastore.neoemf.logging.impl.LoggerFactory;
import org.hibernate.ogm.dialect.spi.AssociationContext;
import org.hibernate.ogm.dialect.spi.AssociationTypeContext;
import org.hibernate.ogm.dialect.spi.BaseGridDialect;
import org.hibernate.ogm.dialect.spi.GridDialect;
import org.hibernate.ogm.dialect.spi.ModelConsumer;
import org.hibernate.ogm.dialect.spi.NextValueRequest;
import org.hibernate.ogm.dialect.spi.OperationContext;
import org.hibernate.ogm.dialect.spi.TupleAlreadyExistsException;
import org.hibernate.ogm.dialect.spi.TupleContext;
import org.hibernate.ogm.dialect.spi.TupleTypeContext;
import org.hibernate.ogm.entityentry.impl.TuplePointer;
import org.hibernate.ogm.model.key.spi.AssociationKey;
import org.hibernate.ogm.model.key.spi.AssociationKeyMetadata;
import org.hibernate.ogm.model.key.spi.EntityKey;
import org.hibernate.ogm.model.key.spi.EntityKeyMetadata;
import org.hibernate.ogm.model.spi.Association;
import org.hibernate.ogm.model.spi.Tuple;
import org.hibernate.persister.entity.Lockable;

public class NeoEmfDialect extends BaseGridDialect implements GridDialect {
	
	
	private static final Log log = LoggerFactory.getLogger();
	
	@Override
	public LockingStrategy getLockingStrategy(Lockable lockable, LockMode lockMode) {
		//NeoEMF essentially has no workable lock strategy .
		return null;
	}

	@Override
	public Tuple getTuple(EntityKey key, OperationContext operationContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tuple createTuple(EntityKey key, OperationContext operationContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdateTuple(EntityKey key, TuplePointer tuplePointer, TupleContext tupleContext)
			throws TupleAlreadyExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTuple(EntityKey key, TupleContext tupleContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public Association getAssociation(AssociationKey key, AssociationContext associationContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Association createAssociation(AssociationKey key, AssociationContext associationContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdateAssociation(AssociationKey key, Association association,
			AssociationContext associationContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAssociation(AssociationKey key, AssociationContext associationContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isStoredInEntityStructure(AssociationKeyMetadata associationKeyMetadata,
			AssociationTypeContext associationTypeContext) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Number nextValue(NextValueRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forEachTuple(ModelConsumer consumer, TupleTypeContext tupleTypeContext,
			EntityKeyMetadata entityKeyMetadata) {
		// TODO Auto-generated method stub

	}

}
