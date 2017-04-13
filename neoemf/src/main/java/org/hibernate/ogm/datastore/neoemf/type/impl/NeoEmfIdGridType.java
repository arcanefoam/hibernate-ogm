/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.type.impl;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.ogm.type.descriptor.impl.PassThroughGridTypeDescriptor;
import org.hibernate.ogm.type.impl.AbstractGenericBasicType;

import fr.inria.atlanmod.neoemf.core.Id;

/**
 * Persists {@link Id}s as is in NeoEmf.
 *
 * @author Horacio Hoyos
 */
public class NeoEmfIdGridType extends AbstractGenericBasicType<Id> {
	
	/** The Constant INSTANCE. */
	public final static NeoEmfIdGridType INSTANCE = new NeoEmfIdGridType();

	/**
	 * Instantiates a new neo emf id grid type.
	 */
	public NeoEmfIdGridType() {
		super( PassThroughGridTypeDescriptor.INSTANCE, NeoEmfIdTypeDescriptor.INSTANCE );
	}

	@Override
	public String getName() {
		return "neoemfid";
	}


	@Override
	public int getColumnSpan(Mapping mapping) throws MappingException {
		return 1;
	}

}
