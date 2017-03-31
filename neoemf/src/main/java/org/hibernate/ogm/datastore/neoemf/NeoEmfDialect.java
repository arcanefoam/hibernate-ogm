/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.hibernate.LockMode;
import org.hibernate.dialect.lock.LockingStrategy;
import org.hibernate.ogm.datastore.neoemf.impl.NeoEmfDatastoreProvider;
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


// TODO: Auto-generated Javadoc
/**
 * The Class NeoEmfDialect.
 *
 * @author Horacio Hoyos
 */
public class NeoEmfDialect extends BaseGridDialect implements GridDialect {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2367772990622201090L;
	
	/** The Constant log. */
	private static final Log log = LoggerFactory.getLogger();
	
	private final NeoEmfDatastoreProvider provider;
	
	/**
	 * Sessions are resouces that exist in a specific resource set
	 */
	private final Resource session;
	
	
	public NeoEmfDialect(NeoEmfDatastoreProvider provider) {
		log.info("Init NeoEmfDatastoreProvider");
		this.provider = provider;
		this.session = provider.getConnection();
	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.BaseGridDialect#getLockingStrategy(org.hibernate.persister.entity.Lockable, org.hibernate.LockMode)
	 */
	@Override
	public LockingStrategy getLockingStrategy(Lockable lockable, LockMode lockMode) {
		//NeoEMF essentially has no workable lock strategy .
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#getTuple(org.hibernate.ogm.model.key.spi.EntityKey, org.hibernate.ogm.dialect.spi.OperationContext)
	 */
	@Override
	public Tuple getTuple(EntityKey key, OperationContext operationContext) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#createTuple(org.hibernate.ogm.model.key.spi.EntityKey, org.hibernate.ogm.dialect.spi.OperationContext)
	 */
	@Override
	public Tuple createTuple(EntityKey key, OperationContext operationContext) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#insertOrUpdateTuple(org.hibernate.ogm.model.key.spi.EntityKey, org.hibernate.ogm.entityentry.impl.TuplePointer, org.hibernate.ogm.dialect.spi.TupleContext)
	 */
	@Override
	public void insertOrUpdateTuple(EntityKey key, TuplePointer tuplePointer, TupleContext tupleContext)
			throws TupleAlreadyExistsException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#removeTuple(org.hibernate.ogm.model.key.spi.EntityKey, org.hibernate.ogm.dialect.spi.TupleContext)
	 */
	@Override
	public void removeTuple(EntityKey key, TupleContext tupleContext) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#getAssociation(org.hibernate.ogm.model.key.spi.AssociationKey, org.hibernate.ogm.dialect.spi.AssociationContext)
	 */
	@Override
	public Association getAssociation(AssociationKey key, AssociationContext associationContext) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#createAssociation(org.hibernate.ogm.model.key.spi.AssociationKey, org.hibernate.ogm.dialect.spi.AssociationContext)
	 */
	@Override
	public Association createAssociation(AssociationKey key, AssociationContext associationContext) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#insertOrUpdateAssociation(org.hibernate.ogm.model.key.spi.AssociationKey, org.hibernate.ogm.model.spi.Association, org.hibernate.ogm.dialect.spi.AssociationContext)
	 */
	@Override
	public void insertOrUpdateAssociation(AssociationKey key, Association association,
			AssociationContext associationContext) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#removeAssociation(org.hibernate.ogm.model.key.spi.AssociationKey, org.hibernate.ogm.dialect.spi.AssociationContext)
	 */
	@Override
	public void removeAssociation(AssociationKey key, AssociationContext associationContext) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#isStoredInEntityStructure(org.hibernate.ogm.model.key.spi.AssociationKeyMetadata, org.hibernate.ogm.dialect.spi.AssociationTypeContext)
	 */
	@Override
	public boolean isStoredInEntityStructure(AssociationKeyMetadata associationKeyMetadata,
			AssociationTypeContext associationTypeContext) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#nextValue(org.hibernate.ogm.dialect.spi.NextValueRequest)
	 */
	@Override
	public Number nextValue(NextValueRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.ogm.dialect.spi.GridDialect#forEachTuple(org.hibernate.ogm.dialect.spi.ModelConsumer, org.hibernate.ogm.dialect.spi.TupleTypeContext, org.hibernate.ogm.model.key.spi.EntityKeyMetadata)
	 */
	@Override
	public void forEachTuple(ModelConsumer consumer, TupleTypeContext tupleTypeContext,
			EntityKeyMetadata entityKeyMetadata) {
		// TODO Auto-generated method stub

	}

}
