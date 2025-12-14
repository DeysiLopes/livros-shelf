package com.deysi_lps.livrosshelf.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.deysi_lps.livrosshelf")
public class ArchitectureTest {

    @ArchTest
    public static final ArchRule domain_should_not_depend_on_infrastructure_or_application =
            noClasses()
                    .that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..infra..", "..application..");

    @ArchTest
    public static final ArchRule ports_in_should_be_in_domain =
            classes()
                    .that().haveNameMatching(".*Port")
                    .and().resideInAPackage("..domain.ports.in..")
                    .should().beInterfaces()
                    .because("Portas de entrada devem ser interfaces no domínio");

    @ArchTest
    public static final ArchRule ports_out_should_be_in_domain =
            classes()
                    .that().haveNameMatching(".*Port")
                    .and().resideInAPackage("..domain.ports.out..")
                    .should().beInterfaces()
                    .because("Portas de saída devem ser interfaces no domínio");

    @ArchTest
    public static final ArchRule adapters_should_implement_ports =
            classes()
                    .that().haveSimpleNameEndingWith("Adapter")
                    .should().beAssignableTo(com.tngtech.archunit.base.DescribedPredicate.describe(
                            "implementar uma interface Port",
                            cls -> cls.getAllRawInterfaces().stream()
                                    .anyMatch(i -> i.getSimpleName().endsWith("Port"))
                    ))
                    .because("Adapters devem implementar portas do domínio");




    @ArchTest
    public static final ArchRule controllers_should_be_in_infra =
            classes()
                    .that().haveSimpleNameEndingWith("Controller")
                    .should().resideInAPackage("..infra.web.controller..")
                    .because("Controllers são adaptadores de entrada");

    @ArchTest
    public static final ArchRule repositories_should_be_in_infra =
            classes()
                    .that().haveSimpleNameEndingWith("Repository")
                    .or().haveSimpleNameEndingWith("RepositoryAdapter")
                    .should().resideInAPackage("..infra.persistence..")
                    .because("Repositories são adaptadores de saída");

    @ArchTest
    public static final ArchRule domain_should_be_free_of_framework_dependencies =
            noClasses()
                    .that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("org.springframework..", "jakarta.persistence..")
                    .because("O domínio deve ser independente de frameworks");

    @ArchTest
    public static final ArchRule commands_should_not_return_data =
            classes()
                    .that().haveSimpleNameEndingWith("Command")
                    .should().resideInAPackage("..application.command..")
                    .because("Commands são operações de escrita");

    @ArchTest
    public static final ArchRule queries_should_return_data =
            classes()
                    .that().haveSimpleNameEndingWith("Query")
                    .should().resideInAPackage("..application.query..")
                    .because("Queries são operações de leitura");

    @ArchTest
    public static final ArchRule application_should_not_depend_on_controllers =
            noClasses()
                    .that().resideInAPackage("..application..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("..infra.web..");

    @ArchTest
    public static final ArchRule domain_models_should_be_in_model_package =
            classes()
                    .that().areNotInterfaces()
                    .and().resideInAPackage("..domain.model..")
                    .should().haveSimpleNameNotEndingWith("Port")
                    .because("Modelos de domínio devem estar no pacote model");
}
