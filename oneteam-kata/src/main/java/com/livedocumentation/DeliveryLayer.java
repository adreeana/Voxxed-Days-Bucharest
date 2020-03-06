/**
 * 
 */
package com.livedocumentation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks this package as the root of the delivery layer.
 * 
 * This layer (usually very thin) delegates to the application layer
 * for each applicative use-case.
 * 
 * @author @adreeana
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.PACKAGE)
public @interface DeliveryLayer {
}
