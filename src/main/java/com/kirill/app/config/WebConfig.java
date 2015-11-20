package com.kirill.app.config;

import com.kirill.app.controllers.IndexController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;

import java.util.List;

/**
 * Created by Kirill Malah
 *
 * @author Kirill Malah
 * @since 20-Nov-15
 */
@ComponentScan(basePackageClasses = { IndexController.class })
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(resolver());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
    }

    @Bean
    public ServletWebArgumentResolverAdapter resolver() {
        return new ServletWebArgumentResolverAdapter(pageable());
    }

    @Bean
    public PageableArgumentResolver pageable() {
        return new PageableArgumentResolver();
    }

    @Bean
    public MappingJackson2HttpMessageConverter converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(mapper());
        return converter;
    }
    /*
    * Provides the Jackson ObjectMapper with custom configuration for our JSON serialization.
    * @return The Jackson object mapper with non-null serialization configured

    */
    @Bean
    public JacksonObjectMapper mapper() {
        return new JacksonObjectMapper();
    }
}
