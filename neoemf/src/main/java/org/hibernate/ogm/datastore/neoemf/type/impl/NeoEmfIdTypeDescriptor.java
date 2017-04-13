/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.type.impl;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

import fr.inria.atlanmod.neoemf.core.Id;
import fr.inria.atlanmod.neoemf.core.StringId;

/**
 * Descriptor for persisting {@link Id}s as is in NeoEmf.
 *
 * @author Horacio Hoyos
 */
public class NeoEmfIdTypeDescriptor extends AbstractTypeDescriptor<Id> {
	
	public static final NeoEmfIdTypeDescriptor INSTANCE = new NeoEmfIdTypeDescriptor();
	
	public NeoEmfIdTypeDescriptor() {
		super( Id.class );
	}

	@Override
	public String toString(Id value) {
		return value == null ? null : value.toString();
	}

	@Override
	public Id fromString(String string) {
		return new StringId(string);
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public <X> X unwrap(Id value, Class<X> type, WrapperOptions options) {
		if ( value == null ) {
			return null;
		}
		if ( Id.class.isAssignableFrom( type ) ) {
			return (X) value;
		}
		throw unknownUnwrap( type );
	}

	@Override
	public <X> Id wrap(X value, WrapperOptions options) {
		if ( value == null ) {
			return null;
		}
		if ( Id.class.isInstance( value ) ) {
			return (Id) value;
		}
		throw unknownWrap( value.getClass() );
	}

}
