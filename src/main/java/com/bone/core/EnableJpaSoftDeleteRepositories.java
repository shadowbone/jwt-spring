package com.bone.core;

import com.bone.core.support.JpaSoftDeleteRepositoryFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.DefaultRepositoryBaseClass;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableJpaRepositories
public @interface EnableJpaSoftDeleteRepositories {
    /**
     * Alias for the {@link #basePackages()} attribute. Allows for more concise annotation declarations e.g.:
     * {@code @EnableJpaSoftDeleteRepositories("org.my.pkg")} instead of {@code @EnableJpaSoftDeleteRepositories(basePackages="org.my.pkg")}.
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    String[] value() default {};

    /**
     * Base packages to scan for annotated components. {@link #value()} is an alias for (and mutually exclusive with) this
     * attribute. Use {@link #basePackageClasses()} for a type-safe alternative to String-based package names.
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    String[] basePackages() default {};

    /**
     * Type-safe alternative to {@link #basePackages()} for specifying the packages to scan for annotated components. The
     * package of each class specified will be scanned. Consider creating a special no-op marker class or interface in
     * each package that serves no purpose other than being referenced by this attribute.
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    Class<?>[] basePackageClasses() default {};

    /**
     * Specifies which types are eligible for component scanning. Further narrows the set of candidate components from
     * everything in {@link #basePackages()} to everything in the base packages that matches the given filter or filters.
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    ComponentScan.Filter[] includeFilters() default {};

    /**
     * Specifies which types are not eligible for component scanning.
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    ComponentScan.Filter[] excludeFilters() default {};

    /**
     * Returns the postfix to be used when looking up custom repository implementations. Defaults to {@literal Impl}. So
     * for a repository named {@code PersonRepository} the corresponding implementation class will be looked up scanning
     * for {@code PersonRepositoryImpl}.
     *
     * @return
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    String repositoryImplementationPostfix() default "Impl";

    /**
     * Configures the location of where to find the Spring Data named queries properties file. Will default to
     * {@code META-INF/jpa-named-queries.properties}.
     *
     * @return
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    String namedQueriesLocation() default "";

    /**
     * Returns the key of the {@link QueryLookupStrategy} to be used for lookup queries for query methods. Defaults to
     * {@link QueryLookupStrategy.Key#CREATE_IF_NOT_FOUND}.
     *
     * @return
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    QueryLookupStrategy.Key queryLookupStrategy() default QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND;

    /**
     * Returns the {@link FactoryBean} class to be used for each repository instance. Defaults to
     * {@link JpaRepositoryFactoryBean}.
     *
     * @return
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    Class<?> repositoryFactoryBeanClass() default JpaSoftDeleteRepositoryFactoryBean.class;

    /**
     * Configure the repository base class to be used to create repository proxies for this particular configuration.
     *
     * @return
     * @since 1.9
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    Class<?> repositoryBaseClass() default DefaultRepositoryBaseClass.class;

    // JPA specific configuration

    /**
     * Configures the name of the {@link EntityManagerFactory} bean definition to be used to create repositories
     * discovered through this annotation. Defaults to {@code entityManagerFactory}.
     *
     * @return
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    String entityManagerFactoryRef() default "entityManagerFactory";

    /**
     * Configures the name of the {@link PlatformTransactionManager} bean definition to be used to create repositories
     * discovered through this annotation. Defaults to {@code transactionManager}.
     *
     * @return
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    String transactionManagerRef() default "transactionManager";

    /**
     * Configures whether nested repository-interfaces (e.g. defined as inner classes) should be discovered by the
     * repositories infrastructure.
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    boolean considerNestedRepositories() default false;

    /**
     * Configures whether to enable default transactions for Spring Data JPA repositories. Defaults to {@literal true}. If
     * disabled, repositories must be used behind a facade that's configuring transactions (e.g. using Spring's annotation
     * driven transaction facilities) or repository methods have to be used to demarcate transactions.
     *
     * @return whether to enable default transactions, defaults to {@literal true}.
     */
    @AliasFor(annotation = EnableJpaRepositories.class)
    boolean enableDefaultTransactions() default true;
}
