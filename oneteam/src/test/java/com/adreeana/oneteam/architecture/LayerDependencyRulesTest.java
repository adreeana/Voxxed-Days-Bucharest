package com.adreeana.oneteam.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class LayerDependencyRulesTest {
    private final JavaClasses classes =
        new ClassFileImporter().importPackages("com.adreeana.oneteam");

    @Test
    public void domain_should_not_access_any_layer() {
        noClasses().that().resideInAPackage("..domain..")
            .should().accessClassesThat().resideInAPackage("..delivery..").check(classes);

        noClasses().that().resideInAPackage("..domain..")
            .should().accessClassesThat().resideInAPackage("..application..").check(classes);

        noClasses().that().resideInAPackage("..domain..")
            .should().accessClassesThat().resideInAPackage("..infrastructure..").check(classes);
    }

    @Test
    public void delivery_should_access_only_application() {
        noClasses().that().resideInAPackage("..delivery..")
            .should().accessClassesThat().resideInAPackage("..infrastructure..").check(classes);

        noClasses().that().resideInAPackage("..delivery..")
            .should().accessClassesThat().resideInAPackage("..domain..").check(classes);
    }

    @Test
    public void application_should_access_only_domain() {
        noClasses().that().resideInAPackage("..application..")
            .should().accessClassesThat().resideInAPackage("..delivery..").check(classes);

        noClasses().that().resideInAPackage("..application..")
            .should().accessClassesThat().resideInAPackage("..infrastructure..").check(classes);
    }
}
