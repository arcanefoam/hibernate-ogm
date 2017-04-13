package org.hibernate.ogm.datastore.neoemf.impl.configuration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.ogm.cfg.OgmProperties;
import org.hibernate.ogm.cfg.spi.Hosts;
import org.hibernate.ogm.datastore.neoemf.NeoEmfProperties;
import org.hibernate.ogm.options.spi.OptionsContext;
import org.hibernate.ogm.util.configurationreader.spi.ConfigurationPropertyReader;

public class NeoEmfConfiguration  {
	
	private final String backend;
	private final Hosts hosts;
	private final String databaseName;
	private final boolean createDatabase;
	
	public NeoEmfConfiguration(ConfigurationPropertyReader propertyReader, OptionsContext globalOptions) {
		this.backend = propertyReader.property( NeoEmfProperties.BACKEND, String.class ).getValue();
		/* Currently NeoEmf only supports local (file) databases, thus we use the localhost to refer
		 * to the local path in which the db exists/is created.
		 */
		String local_path = propertyReader.property( OgmProperties.HOST, String.class )
				.withDefault( propertyReader.property( "user.home", String.class ).getValue() )
				.getValue();
		List<String> hosts = new ArrayList<>();
		List<Integer> ports = new ArrayList<>();
		hosts.add(local_path);
		ports.add(0);
		this.hosts = new Hosts(hosts, ports);
		this.databaseName = propertyReader.property( OgmProperties.DATABASE, String.class )
				.required()
				.getValue();

		this.createDatabase = propertyReader.property( OgmProperties.CREATE_DATABASE, boolean.class )
				.withDefault( false )
				.getValue();
		
	}

	public String getBackend() {
		return backend;
	}

	public Hosts getHosts() {
		return hosts;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public boolean isCreateDatabase() {
		return createDatabase;
	}
	
}
