# Configuring spring data jpa

````
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-jpa</artifactId>
    <version>version</version>
</dependency>
````

````
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>version</version>
</dependency>
````

````java
    @Configuration
    @EnableJpaRepositories
    public class SpringDataConfigurer {
        // . . . . . . . . . . . . . .
    }
````

````java
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getRequiredProperty("spring.datasource.jdbc.url"));
        dataSource.setSchema(env.getRequiredProperty("spring.datasource.jdbc.schema"));
        dataSource.setUsername(env.getRequiredProperty("spring.datasource.jdbc.user"));
        dataSource.setPassword(env.getRequiredProperty("spring.datasource.jdbc.password"));
        dataSource.setDriverClassName(env.getRequiredProperty("spring.datasource.jdbc.driver"));
        return dataSource;
    }
````

````java
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("base_backage");
        
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        
        entityManagerFactoryBean.setJpaProperties(properties());
        return entityManagerFactoryBean;
    }
````


````java
    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }
````


````java
    private Properties properties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", env.getRequiredProperty("spring.datasource.hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getRequiredProperty("spring.datasource.hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.datasource.hibernate.hbm2ddl.auto"));
        return properties;
    }
````