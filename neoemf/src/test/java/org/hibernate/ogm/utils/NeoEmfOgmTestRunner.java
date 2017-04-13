package org.hibernate.ogm.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.exception.impl.Exceptions;
import org.hibernate.ogm.utils.OgmTestRunner;
import org.hibernate.ogm.utils.TestEntities;
import org.hibernate.ogm.utils.TestSessionFactoryConfiguration;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * A JUnit 4 runner for NeoEmf OGM tests, which adds support for mapping files.
 * <p>
 * The mapping files of the test are to be returned by a parameterless method annotated with {@link TestMappingFiles}
 * in form of a {@code List<Sting>}.
 * <p>
 * Usage example:
 *
 * <pre>
 * {@code
 * @RunWith(NeoEmfOgmTestRunner.class)
 * public class AnimalFarmTest {
 *
 *    ...
 *    
 *    @TestMappingFiles
 *    public String[] getTestMappingFiles() {
 *        return new String[]{ PolarBear.hbm.xml, Giraffe.hbm.xml };
 *    }
 * }
 * }
 * </pre>
 *
 * @see OgmTestCase Base class for tests which is configured with this runner for ease of use
 * @author Gunnar Morling
 */
public class NeoEmfOgmTestRunner extends OgmTestRunner {
	
	private String[] getMappingFiles() {
		for ( FrameworkMethod frameworkMethod : getTestClass().getAnnotatedMethods( TestMappingFiles.class ) ) {
			String[] mappingFiles = invokeTestMappingFilesMethod( frameworkMethod );
			if ( mappingFiles == null || mappingFiles.length == 0 ) {
				throw new IllegalArgumentException( "Define at least a single entity (at least one mapping file)");
			}
			return mappingFiles;
		}

		throw new IllegalStateException( "The mapping files of the test must be retrievable via a parameterless method"
				+ " which is annotated with " + TestMappingFiles.class.getSimpleName() + " and returns List<String>." );
	}
	
	private String[] invokeTestMappingFilesMethod(FrameworkMethod frameworkMethod) {
		Method method = frameworkMethod.getMethod();
		method.setAccessible( true );

		if ( method.getReturnType() != String[].class || method.getParameterTypes().length > 0 ) {
			throw new IllegalStateException( "Method annotated with " + TestMappingFiles.class.getSimpleName()
					+ " must have no parameters and must return List<String>." );
		}

		String[] entityTypes = null;

		try {
			entityTypes = (String[]) method.invoke( super.createTest() );
		}
		catch (Exception e) {
			Exceptions.<RuntimeException>sneakyThrow( e );
		}

		return entityTypes;
	}
	
	private Map<String, Object> getTestSpecificSettings() {
		Map<String, Object> testSpecificSettings = new HashMap<>();

		try {
			for ( FrameworkMethod frameworkMethod : getTestClass().getAnnotatedMethods( TestSessionFactoryConfiguration.class ) ) {
				Method method = frameworkMethod.getMethod();
				method.setAccessible( true );
				method.invoke( super.createTest(), testSpecificSettings );
			}
		}
		catch (Exception e) {
			Exceptions.<RuntimeException>sneakyThrow( e );
		}

		return testSpecificSettings;
	}
	
	private Class<?>[] getConfiguredEntityTypes() {
		for ( FrameworkMethod frameworkMethod : getTestClass().getAnnotatedMethods( TestEntities.class ) ) {
			Class<?>[] entityTypes = invokeTestEntitiesMethod( frameworkMethod );

			if ( entityTypes == null || entityTypes.length == 0 ) {
				throw new IllegalArgumentException( "Define at least a single annotated entity" );
			}

			return entityTypes;
		}

		throw new IllegalStateException( "The entities of the test must be retrievable via a parameterless method which is annotated with "
				+ TestEntities.class.getSimpleName() + " and returns Class<?>[]." );
	}
	
	private Class<?>[] invokeTestEntitiesMethod(FrameworkMethod frameworkMethod) {
		Method method = frameworkMethod.getMethod();
		method.setAccessible( true );

		if ( method.getReturnType() != Class[].class || method.getParameterTypes().length > 0 ) {
			throw new IllegalStateException( "Method annotated with " + TestEntities.class.getSimpleName()
					+ " must have no parameters and must return Class<?>[]." );
		}

		Class<?>[] entityTypes = null;

		try {
			entityTypes = (Class<?>[]) method.invoke( super.createTest() );
		}
		catch (Exception e) {
			Exceptions.<RuntimeException>sneakyThrow( e );
		}

		return entityTypes;
	}
	
	
	public NeoEmfOgmTestRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}
	
	protected OgmSessionFactory buildSessionFactory() {
		return NeoEmfTestHelper.getDefaultTestSessionFactory( getTestSpecificSettings(),
				getConfiguredEntityTypes(),
				getMappingFiles() );
	}
	
	

}
