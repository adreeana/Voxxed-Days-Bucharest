package com.livedocumentation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * An object responsible for routing and HTTP serialisation.
 * Part of the delivery system and not part of the domain.
 *
 * @author @adreeana
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface PageController {

    String[] link() default {
        "https://martinfowler.com/eaaCatalog/pageController.html"
    };
}
