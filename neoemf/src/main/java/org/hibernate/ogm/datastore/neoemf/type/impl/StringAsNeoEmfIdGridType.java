/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.type.impl;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.ogm.type.descriptor.impl.WrappedGridTypeDescriptor;
import org.hibernate.ogm.type.impl.AbstractGenericBasicType;

/**
 * Persists Strings as {@link Id}s in NeoEmf:
 *
 * @author Horacio Hoyos
 */
public class StringAsNeoEmfIdGridType extends AbstractGenericBasicType<String> {
	
	/** The Constant INSTANCE. */
	public static final StringAsNeoEmfIdGridType INSTANCE = new StringAsNeoEmfIdGridType();

	public StringAsNeoEmfIdGridType() {
		super(WrappedGridTypeDescriptor.INSTANCE, StringAsNeoEmfIdTypeDescriptor.INSTANCE);

	}

	@Override
	public String getName() {
		return "string_neoemfid";
	}

	@Override
	public int getColumnSpan(Mapping mapping) throws MappingException {
		return 1;
	}

}
