package cn.zyx.intecepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//spring boot 2.x 之前需要这样编写
//@Configuration
public class CustomOldWebMvcConfigure extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginIntecepter()).addPathPatterns("/api/");

        super.addInterceptors(registry);
    }
}
