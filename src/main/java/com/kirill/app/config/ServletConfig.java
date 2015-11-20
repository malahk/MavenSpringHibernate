package com.kirill.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Kirill Malah
 *
 * @author Kirill Malah
 * @since 20-Nov-15
 */
@Configuration
@Import(WebConfig.class)
@ImportResource({
        "classpath:META-INF/spring/persistence-context.xml",
        "classpath:META-INF/spring/bizniz-context.xml",
        "classpath:META-INF/spring/web-context.xml"
})
public class ServletConfig {
}
