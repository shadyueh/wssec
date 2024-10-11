package com.example.wssec.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.core.io.ClassPathResource;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "wssec")  // Bean name is 'wssec'
    public DefaultWsdl11Definition wssecWsdl11Definition(XsdSchema serviceSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("ServicePort");  // Updated to a more generic name
        definition.setLocationUri("/ws/wssec");  // Location URI for the service
        definition.setSchema(serviceSchema);
        return definition;
    }

    @Bean
    public XsdSchema serviceSchema() {  // Updated method name to 'serviceSchema'
        return new SimpleXsdSchema(new ClassPathResource("wsdl/service.xsd"));  // Use 'service.xsd'
    }
}
