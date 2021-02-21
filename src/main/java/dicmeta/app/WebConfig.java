package dicmeta.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dicmeta.app.common.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
     * 로그인 인증 Interceptor 설정
     */
    @Autowired
    LoginCheckInterceptor loginCheckInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor)
		        .addPathPatterns("/api/**")
		        .addPathPatterns("/*/page")
        		.excludePathPatterns("/api/login/**") //로그인 쪽은 제외
        		.excludePathPatterns("/login/**") //로그인 쪽은 제외
                ;
    }
}
