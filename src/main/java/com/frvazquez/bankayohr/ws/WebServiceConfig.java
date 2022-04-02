package com.frvazquez.bankayohr.ws;

import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.frvazquez.bankayohr.constants.Constants;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	private Interceptor interceptor;
	
	public WebServiceConfig(Interceptor interceptor) {
		this.interceptor = interceptor;
	}

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/ws/*");
	}

	@Bean(name = "pokemon")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pokemon) {
		DefaultWsdl11Definition wsdlDefinition = new DefaultWsdl11Definition();
		wsdlDefinition.setPortTypeName("PokemonPort");
		wsdlDefinition.setLocationUri("/ws");
		wsdlDefinition.setTargetNamespace(Constants.NAMESPACE_URI);
		wsdlDefinition.setSchema(pokemon);
		return wsdlDefinition;
	}

	@Bean
	public XsdSchema pokemonSchema() {
		return new SimpleXsdSchema(new ClassPathResource("pokemon.xsd"));
	}

	 @Override
	    public void addInterceptors(List<EndpointInterceptor> intercepcionesEndPoint)  {
	        try {
	        	intercepcionesEndPoint.add(interceptor);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
