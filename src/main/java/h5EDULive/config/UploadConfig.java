package h5EDULive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//url映射
@Configuration
public class UploadConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/meta/**").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/res/**").addResourceLocations("classpath:/resources/");
        registry.addResourceHandler("/stat/**").addResourceLocations("classpath:/static/")
                .addResourceLocations("file:C:/Users/MI/H5-EDU-Live/src/main/resources/static");
        registry.addResourceHandler("/oth/**").addResourceLocations("classpath:/others/");
//        registry.addResourceHandler("/temp/**").addResourceLocations("classpath:/templates/")
//                .addResourceLocations("file:E:/IdeaProjects/H5_SDU_Live/src/main/resources/templates/");
        super.addResourceHandlers(registry);
    }
}
