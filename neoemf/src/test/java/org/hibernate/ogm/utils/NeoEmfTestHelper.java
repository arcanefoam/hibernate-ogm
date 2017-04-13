package org.hibernate.ogm.utils;

import java.util.List;
import java.util.Map;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.utils.TestHelper;

/**
 * A OGM Test helper that supports mapping files
 * @author hhoyos
 *
 */
public class NeoEmfTestHelper {
	
	private static Metadata getDefaultTestMetadata(Map<String, Object> settings,
			Class<?>[] entityTypes,
			String[] mappingFiles) {
		StandardServiceRegistry serviceRegistry = TestHelper.getDefaultTestStandardServiceRegistry( settings );
		MetadataSources sources = getMetadataSources( entityTypes );
		for (String file : mappingFiles) {
			sources.addResource(file);
		}
		return sources.getMetadataBuilder( serviceRegistry ).build();
	}
	
	private static MetadataSources getMetadataSources(Class<?>... entityTypes) {
		MetadataSources sources = new MetadataSources();

		for ( Class<?> entityType : entityTypes ) {
			sources.addAnnotatedClass( entityType );
		}

		return sources;
	}
	
	public static OgmSessionFactory getDefaultTestSessionFactory(Map<String, Object> settings,
			Class<?>[] entityTypes, String[] mappingFiles) {
		return getDefaultTestMetadata(
				settings,
				entityTypes,
				mappingFiles
			)
			.getSessionFactoryBuilder()
			.unwrap( OgmSessionFactoryBuilder.class )
			.build();
	}
	

}
