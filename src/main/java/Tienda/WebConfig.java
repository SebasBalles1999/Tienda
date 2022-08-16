package Tienda;

import java.util.Locale;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Bean
    public LocaleResolver localeResolver(){
        var srl = new SessionLocaleResolver();
        srl.setDefaultLocale(new Locale("es"));
        return srl;
    }
    
    @Bean
    public LocaleChangeInterceptor localChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    
    public void addInterceptor(InterceptorRegistry registro){
        registro.addInterceptor(localChangeInterceptor());
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
}
