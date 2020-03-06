/**
 * 
 */
package com.livedocumentation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * An object fundamentally defined not by its attributes,
 * but by a thread of continuity and identity.
 * 
 * @author Cyrille.Martraire
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Entity {

    String brief() default "An Entity that acts as the root for a cluster of associated objects, all treated as a unit";

    String link() default "http://domaindrivendesign.org/node/88";
}
