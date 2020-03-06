/**
 *
 */
package com.livedocumentation;

import com.adreeana.oneteam.Codex;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks this package as the root of the domain layer.
 *
 * Domain Layer (or Model Layer): Responsible for representing concepts of
 * the business, information about the business situation, and business rules.
 * State that reflects the business situation is controlled and used here,
 * even though the technical details of storing it are delegated to the infrastructure.
 * This layer is the heart of business software.
 *
 * The domain layer must not depend on any infrastructure, application or
 * presentation/UI code, and in particular not on persistence (Persistence
 * Ignorance). To this end, the domain layer typically declares Service and
 * Repository interfaces that are implemented technically in the infrastructure
 * layer.
 *
 * @author Cyrille.Martraire
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.PACKAGE)
public @interface DomainLayer {

    Codex rationale() default Codex.DIP_DOMAIN;

    String[] link() default {
        "https://martinfowler.com/bliki/AnemicDomainModel.html"
    };
}
