package com.livedocumentation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * An object that carries data between processes.
 *
 * Application services usually use this pattern as input/output for their methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataTransferObject {

    String[] link() default {
        "http://en.wikipedia.org/wiki/Data_transfer_object"
    };
}
