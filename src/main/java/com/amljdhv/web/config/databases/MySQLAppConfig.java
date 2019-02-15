package com.amljdhv.web.config.databases;

/*@Configuration
@EntityScan("com.amljdhv.domain.model")
@EnableTransactionManagement
@PropertySource("classpath:database.properties")*/
public class MySQLAppConfig {/*
	
	@Value("${app.datasource.driverClassName}") String driverClassName;
    @Value("${app.datasource.url}") String url;
    @Value("${app.datasource.username}") String username;
    @Value("${app.datasource.password}") String password;
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DataSource dataSource = DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driverClassName)
                .build();
        return dataSource;
    }
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.scanPackages("com.amljdhv");
        return sessionBuilder.buildSessionFactory();
    }
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }   
    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        return initializer;
    }

*/}
