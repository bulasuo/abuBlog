package com.abu.learn.HelloSpringBoot.beanConfig;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeanConfiguration {

	@Bean
    @Profile("dev")
    public Runnable test1() {
        System.out.println("开发环境使用的 Bean");
        return () -> {};
    }
    
    @Bean
    @Profile("test")
    public Runnable test2() {
        System.out.println("测试环境使用的 Bean");
        return () -> {};
    }
    
    @Bean
    @Profile("prod")
    public Runnable test3() {
        System.out.println("生成环境使用的 Bean");
        return () -> {};
    }
    
    
    @Bean
    @Profile("prod")
    public EmbeddedServletContainerFactory servletContainer() {
    	System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxbulasuo_abu");
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {

                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
        return tomcat;
    }

    private Connector initiateHttpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(80);
        connector.setRedirectPort(443);
        connector.setSecure(false);
        return connector;
    }
    
}
