/**
 * 
 */
package com.oes.configuration;

import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * @author akum25
 *
 */

@EnableWebMvc
@Configuration
@ComponentScan("com.oes.*")
@PropertySource({"classpath:/common.properties"})
public class ApplicationContext extends WebMvcConfigurerAdapter {

	private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/view/";
	private static final String VIEW_RESOLVER_SUFFIX = ".jsp";
	
	@Resource
	private Environment environment;
	@Autowired
    private ResourceLoader resourceLoader;
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(VIEW_RESOLVER_PREFIX);
        resolver.setSuffix(VIEW_RESOLVER_SUFFIX);
        return resolver;
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**")
				.addResourceLocations("/static/").setCachePeriod(31556926);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(new String[] {"classpath:messages", "classpath:general", "classpath:appConfig"});
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }
	/*
	@Bean(name = "searchDataSource")
	public DataSource dataSource() throws IllegalStateException, PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty(DATABASE_DRIVER));
		dataSource.setJdbcUrl(environment.getRequiredProperty(DATABASE_URL));
		dataSource.setUser(environment.getRequiredProperty(DATABASE_USERNAME));
		dataSource.setPassword(environment.getRequiredProperty(DATABASE_PASSWORD));
		dataSource.setMinPoolSize(Integer.parseInt(environment.getRequiredProperty(MIN_POOL_SIZE)));
		dataSource.setMaxPoolSize(Integer.parseInt(environment.getRequiredProperty(MAX_POOL_SIZE)));
		dataSource.setAcquireIncrement(Integer.parseInt(environment.getRequiredProperty(ACQUIRE_INCREMENT)));
		dataSource.setIdleConnectionTestPeriod(Integer.parseInt(environment.getRequiredProperty(IDLE_CONNECTION_TEST_PERIOD)));
		dataSource.setPreferredTestQuery(environment.getRequiredProperty(PREFERRED_TEST_QUERY));
		dataSource.setMaxIdleTimeExcessConnections(Integer.parseInt(environment.getRequiredProperty(MAX_IDLE_TIME_EXCESS_CONNECTIONS)));
		dataSource.setNumHelperThreads(Integer.parseInt(environment.getRequiredProperty(NUM_HELPER_THREADS)));
		dataSource.setUnreturnedConnectionTimeout(Integer.parseInt(environment.getRequiredProperty(UNRETURNED_CONNECTION_TIMEOUT)));
		dataSource.setDebugUnreturnedConnectionStackTraces(Boolean.getBoolean(environment.getRequiredProperty(DEBUG_UNRETURNED_CONNECTION_STACKTRACES)));
		return dataSource;
	}
	*/
	/*@Bean(name = "cacheManager")
    public CacheManager cacheManager() {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        try {
            ehCacheCacheManager.setCacheManager(ehcacheCacheManager().getObject());
        } catch (Exception e) {
            throw new IllegalStateException("Failed to create an EhCacheManagerFactoryBean", e);
        }
        return ehCacheCacheManager;
    }*/

    /*@Bean(name = "ehcache")
    public FactoryBean<net.sf.ehcache.CacheManager> ehcacheCacheManager() {
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(resourceLoader.getResource("classpath:ehcache.xml"));
        bean.setShared(Boolean.TRUE);
        
        if(System.getProperty("customCacheLocation") != null){
        	bean.setConfigLocation(resourceLoader.getResource(System.getProperty("customCacheLocation")));
        }
        
        return bean;
    }*/
    
    @Bean
    Integer numberOfDivisions() {
        return 2;
    }
    
    @Bean
    public CountDownLatch countDownLatch(Integer numberOfDivisions) {
        return new CountDownLatch(numberOfDivisions);
    }
  /* @Bean
    GitRepositoryState gitRepositoryState() {
        return new GitRepositoryState();
    }*/

    @Bean
    HttpHeaders httpHeaders() {
        return new HttpHeaders();
    }
   /* @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.parameterName("mediaType").
                ignoreAcceptHeader(false).
                useJaf(false).
                defaultContentType(MediaType.APPLICATION_JSON).
                mediaType("xml", MediaType.APPLICATION_XML).
                mediaType("json", MediaType.APPLICATION_JSON);
    }*/
}
