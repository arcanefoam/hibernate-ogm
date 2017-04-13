/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.type.impl;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

import fr.inria.atlanmod.neoemf.core.StringId;

/**
 * Descriptor for persisting {@code String}s as {@link StringId}s in the datastore.
 *
 * @author Horacio Hoyos
 */
public class StringAsNeoEmfIdTypeDescriptor extends AbstractTypeDescriptor<String> {
	
	/** The Constant INSTANCE. */
	public static final StringAsNeoEmfIdTypeDescriptor INSTANCE = new StringAsNeoEmfIdTypeDescriptor();

	/**
	 * Instantiates a new neo emf core id type descriptor.
	 */
	protected StringAsNeoEmfIdTypeDescriptor() {
		super( String.class );
	}

	/* (non-Javadoc)
	 * @see org.hibernate.type.descriptor.java.JavaTypeDescriptor#toString(java.lang.Object)
	 */
	@Override
	public String toString(String value) {
		return value == null ? null : value;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.type.descriptor.java.JavaTypeDescriptor#fromString(java.lang.String)
	 */
	@Override
	public String fromString(String string) {
		return string;
	}

	/* (non-Javadoc)
	 * @see org.hibernate.type.descriptor.java.JavaTypeDescriptor#unwrap(java.lang.Object, java.lang.Class, org.hibernate.type.descriptor.WrapperOptions)
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public <X> X unwrap(String value, Class<X> type, WrapperOptions options) {
		if ( value == null ) {
			return null;
		}

		return (X) new StringId( value );
	}

	/* (non-Javadoc)
	 * @see org.hibernate.type.descriptor.java.JavaTypeDescriptor#wrap(java.lang.Object, org.hibernate.type.descriptor.WrapperOptions)
	 */
	@Override
	public <X> String wrap(X value, WrapperOptions options) {
		if ( value == null ) {
			return null;
		}

		if ( StringId.class.isInstance( value ) ) {
			return  ( (StringId) value ).toString();
		}

		throw unknownWrap( value.getClass() );
	}

}
