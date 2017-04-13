/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.type.impl;

import org.hibernate.type.StringType;

/**
 * A Hibernate ORM type (i.e. no grid type) used for storing {@code String}s as {@link ObjectId} in MongoDB. It is
 * required for users to be able to specify that specific mapping via {@link Type}. Internally the mapping is
 * implemented by {@link StringAsObjectIdGridType}.
 *
 * @author Horacio Hoyos
 */
public class StringAsNeoEmfIdType extends StringType {

	/* (non-Javadoc)
	 * @see org.hibernate.type.StringType#getName()
	 */
	@Override
	public String getName() {
		return "string_neoemfid";
	}

	/* (non-Javadoc)
	 * @see org.hibernate.type.AbstractStandardBasicType#getRegistrationKeys()
	 */
	@Override
	public String[] getRegistrationKeys() {
		return new String[]{ "neoemfid" };
	}
	
}
