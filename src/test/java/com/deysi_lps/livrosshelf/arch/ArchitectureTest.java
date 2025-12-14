package com.deysi_lps.livrosshelf.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

/**
 * Testes de arquitetura para o projeto 'livros-shelf'.
 * <p>
 * Este conjunto de testes utiliza a biblioteca <b>ArchUnit</b> para garantir que as
 * regras da Arquitetura Hexagonal e os princípios de design (como DDD e CQRS)
 * sejam mantidos ao longo do desenvolvimento.
 * <p>
 * Eles funcionam como "guardiões" automatizados da estrutura do código.
 */
@SuppressWarnings("ALL")
@AnalyzeClasses(packages = "com.deysi_lps.livrosshelf")
public class ArchitectureTest {

    /**
     * <b>Regra 1: O Domínio não deve depender da Infraestrutura ou da Aplicação.</b>
     * <p>
     * <b>Propósito:</b> Esta é a regra de ouro da Arquitetura Hexagonal/Limpa. Ela garante que o
     * <b>domínio</b> (o núcleo do negócio) não tenha nenhuma dependência das camadas externas,
     * como {@code application} (casos de uso) e {@code infra} (tecnologias, frameworks).
     * <p>
     * <b>Como funciona:</b> Proíbe qualquer classe no pacote '..domain..' de depender de classes
     * nos pacotes '..infra..' ou '..application..'.
     */
    @ArchTest
    public static final ArchRule domain_should_not_depend_on_infrastructure_or_application =
            noClasses()
                    .that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("..infra..", "..application..");

    /**
     * <b>Regra 2: Portas de Entrada devem ser interfaces no Domínio.</b>
     * <p>
     * <b>Propósito:</b> Assegura que as <b>Portas de Entrada</b> (Input Ports) da arquitetura
     * sejam definidas como interfaces dentro do domínio ({@code domain.ports.in}).
     * Essas portas definem os casos de uso que a aplicação expõe.
     * <p>
     * <b>Como funciona:</b> Verifica se todas as classes que terminam com 'Port' dentro do
     * pacote '..domain.ports.in..' são, de fato, interfaces.
     */
    @ArchTest
    public static final ArchRule ports_in_should_be_in_domain =
            classes()
                    .that().haveNameMatching(".*Port")
                    .and().resideInAPackage("..domain.ports.in..")
                    .should().beInterfaces()
                    .because("Portas de entrada devem ser interfaces no domínio");

    /**
     * <b>Regra 3: Portas de Saída devem ser interfaces no Domínio.</b>
     * <p>
     * <b>Propósito:</b> Garante que as abstrações para serviços externos (como persistência)
     * sejam definidas como interfaces (<b>Portas de Saída</b>) dentro do domínio ({@code domain.ports.out}).
     * <p>
     * <b>Como funciona:</b> Verifica se todas as classes que terminam com 'Port' dentro do
     * pacote '..domain.ports.out..' são interfaces.
     */
    @ArchTest
    public static final ArchRule ports_out_should_be_in_domain =
            classes()
                    .that().haveNameMatching(".*Port")
                    .and().resideInAPackage("..domain.ports.out..")
                    .should().beInterfaces()
                    .because("Portas de saída devem ser interfaces no domínio");

    /**
     * <b>Regra 4: Adaptadores devem implementar as Portas.</b>
     * <p>
     * <b>Propósito:</b> Garante que os <b>Adaptadores</b> da camada de infraestrutura, que implementam
     * as Portas de Saída, de fato implementem essas interfaces. Isso assegura que o contrato
     * estabelecido pelo domínio seja respeitado pelas implementações tecnológicas.
     * <p>
     * <b>Como funciona:</b> Procura por classes que terminam com "Adapter" e verifica se elas
     * implementam alguma interface cujo nome termina com "Port".
     */
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

    /**
     * <b>Regra 5: Controllers devem pertencer à Infraestrutura.</b>
     * <p>
     * <b>Propósito:</b> Garante que os {@code Controllers} residam exclusivamente na camada de
     * infraestrutura ({@code infra.web.controller}). Eles são <b>Adaptadores de Entrada</b>.
     * <p>
     * <b>Como funciona:</b> Exige que qualquer classe terminada em 'Controller' esteja
     * no pacote '..infra.web.controller..'.
     */
    @ArchTest
    public static final ArchRule controllers_should_be_in_infra =
            classes()
                    .that().haveSimpleNameEndingWith("Controller")
                    .should().resideInAPackage("..infra.web.controller..")
                    .because("Controllers são adaptadores de entrada");

    /**
     * <b>Regra 6: Repositórios devem pertencer à Infraestrutura.</b>
     * <p>
     * <b>Propósito:</b> Assegura que as implementações de repositórios estejam na camada de
     * infraestrutura ({@code infra.persistence}). Eles são os <b>Adaptadores de Saída</b>.
     * <p>
     * <b>Como funciona:</b> Exige que classes terminadas em 'Repository' ou 'RepositoryAdapter'
     * estejam no pacote '..infra.persistence..'.
     */
    @ArchTest
    public static final ArchRule repositories_should_be_in_infra =
            classes()
                    .that().haveSimpleNameEndingWith("Repository")
                    .or().haveSimpleNameEndingWith("RepositoryAdapter")
                    .should().resideInAPackage("..infra.persistence..")
                    .because("Repositories são adaptadores de saída");

    /**
     * <b>Regra 7: O Domínio deve ser livre de dependências de frameworks.</b>
     * <p>
     * <b>Propósito:</b> Reforça a independência do domínio, proibindo o uso de classes
     * de frameworks como Spring ou JPA.
     * <p>
     * <b>Como funciona:</b> Proíbe classes no pacote '..domain..' de dependerem de classes
     * nos pacotes 'org.springframework..' ou 'jakarta.persistence..'.
     */
    @ArchTest
    public static final ArchRule domain_should_be_free_of_framework_dependencies =
            noClasses()
                    .that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage("org.springframework..", "jakarta.persistence..")
                    .because("O domínio deve ser independente de frameworks");

    /**
     * <b>Regra 8: Classes Command devem estar no pacote de comandos.</b>
     * <p>
     * <b>Propósito (Intenção):</b> Alinhado ao princípio de <b>CQRS</b>, {@code Commands}
     * são operações de escrita que alteram o estado do sistema.
     * <p>
     * <b>Como funciona (Implementação Atual):</b> Garante que classes terminadas em 'Command'
     * estejam no pacote '..application.command..', servindo como uma regra de organização.
     */
    @ArchTest
    public static final ArchRule commands_should_not_return_data =
            classes()
                    .that().haveSimpleNameEndingWith("Command")
                    .should().resideInAPackage("..application.command..")
                    .because("Commands são operações de escrita");

    /**
     * <b>Regra 9: Classes Query devem estar no pacote de queries.</b>
     * <p>
     * <b>Propósito (Intenção):</b> A outra metade do <b>CQRS</b>. {@code Queries} são
     * operações de leitura e não devem alterar o estado.
     * <p>
     * <b>Como funciona (Implementação Atual):</b> Garante que classes terminadas em 'Query'
     * estejam no pacote '..application.query..', servindo como uma regra de organização.
     */
    @ArchTest
    public static final ArchRule queries_should_return_data =
            classes()
                    .that().haveSimpleNameEndingWith("Query")
                    .should().resideInAPackage("..application.query..")
                    .because("Queries são operações de leitura");

    /**
     * <b>Regra 10: A camada de Aplicação não deve depender dos Controllers.</b>
     * <p>
     * <b>Propósito:</b> Garante o fluxo correto de dependências (Dependency Inversion). A camada de
     * {@code application} não pode depender de implementações da camada {@code infra.web}.
     * O fluxo de controle é Controller -> Application, mas a dependência de código é invertida.
     * <p>
     * <b>Como funciona:</b> Proíbe classes do pacote '..application..' de dependerem de classes
     * do pacote '..infra.web..'.
     */
    @ArchTest
    public static final ArchRule application_should_not_depend_on_controllers =
            noClasses()
                    .that().resideInAPackage("..application..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("..infra.web..");

    /**
     * <b>Regra 11: Modelos de domínio devem estar no pacote 'model'.</b>
     * <p>
     * <b>Propósito:</b> Regra de organização para manter a estrutura do domínio limpa, garantindo
     * que entidades e objetos de valor fiquem em {@code domain.model}.
     * <p>
     * <b>Como funciona:</b> Verifica se as classes (que não são interfaces) no pacote '..domain.model..'
     * não terminam com o sufixo 'Port'.
     */
    @ArchTest
    public static final ArchRule domain_models_should_be_in_model_package =
            classes()
                    .that().areNotInterfaces()
                    .and().resideInAPackage("..domain.model..")
                    .should().haveSimpleNameNotEndingWith("Port")
                    .because("Modelos de domínio devem estar no pacote model");
}