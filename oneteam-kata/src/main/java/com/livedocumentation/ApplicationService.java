/**
 *
 */
package com.livedocumentation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Represents an application service.
 *
 * It is stateless, orchestrates but does not contain any business logic.
 *
 * Each method has the granularity of an use case and delegates to the domain
 * layer to realize each applicative use-case.
 *
 * It typically decides when to start/stop transactions around a full use-case.
 *
 * @author @adreeana
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ApplicationService {

    String brief() default "An Application Service, i.e. a domain frontier service that belongs to the domain language";

    String[] link() default {
    };
}
