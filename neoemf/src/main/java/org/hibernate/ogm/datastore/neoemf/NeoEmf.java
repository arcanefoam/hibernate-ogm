/**
 * Copyright 2017 JKU
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Contributors:
 * 		Horacio Hoyos - Inital API and development
 */
package org.hibernate.ogm.datastore.neoemf;

import org.hibernate.ogm.datastore.spi.DatastoreConfiguration;
import org.hibernate.ogm.options.navigation.GlobalContext;
import org.hibernate.ogm.options.navigation.spi.ConfigurationContext;
import org.hibernate.ogm.options.navigation.spi.GenericOptionModel;

/**
 * Allows to configure options specific to the NeoEmf data store.
 */
public class NeoEmf implements  DatastoreConfiguration<GlobalContext<?, ?>> {

	/**
	 * Short name of this data store provider.
	 *
	 * @see OgmProperties#DATASTORE_PROVIDER
	 */
	public static final String DATASTORE_PROVIDER_NAME = "NEOEMF_EXPERIMENTAL";

	/**
	 * Gets the configuration builder.
	 *
	 * @param context the context
	 * @return the configuration builder
	 */
	@Override
	public GlobalContext<?, ?> getConfigurationBuilder(ConfigurationContext context) {
		return GenericOptionModel.createGlobalContext( context );
	}
}
