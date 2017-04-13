package org.hibernate.ogm.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a method of a test executed with {@link NeoEmfOgmTestRunner} which is used to retrieve the test's mapping
 * files.
 * <p>
 * The method must have no parameter and needs to return a {@code List<String>} containing the relative paths to the
 * mapping files.
 *
 * @author Horacio Hoyos
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.METHOD)
public @interface TestMappingFiles {

}
