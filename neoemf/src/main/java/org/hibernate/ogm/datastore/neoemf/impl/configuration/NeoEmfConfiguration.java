package org.hibernate.ogm.datastore.neoemf.impl.configuration;

import org.hibernate.ogm.cfg.spi.DocumentStoreConfiguration;
import org.hibernate.ogm.options.spi.OptionsContext;
import org.hibernate.ogm.util.configurationreader.spi.ConfigurationPropertyReader;

public class NeoEmfConfiguration extends DocumentStoreConfiguration {
	
	private static final int DEFAULT_PORT = 9042;
	
	public NeoEmfConfiguration(ConfigurationPropertyReader propertyReader, OptionsContext globalOptions) {
		super(propertyReader, DEFAULT_PORT);

	}

}
