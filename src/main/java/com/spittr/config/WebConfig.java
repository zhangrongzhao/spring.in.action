package com.spittr.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spittr.web","com.spittr.data"})
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Bean
//    public ViewResolver viewResolver(){//配置视图解析器
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

//    @Bean
//    public ViewResolver viewResolver(){
//        return new TilesViewResolver();
//    }
//
//    @Bean
//    public TilesConfigurer tilesConfigurer(){
//        TilesConfigurer tilesConfigurer=new TilesConfigurer();
//        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/layout/tiles.xml"});
//        tilesConfigurer.setCheckRefresh(true);
//        return tilesConfigurer;
//    }

    /*STEP1:创建模板解析器*/
    @Bean
    public ITemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
        //templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    /*STEP2:创建模板引擎，注入模板解析器*/
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }


    /*STEP3:注册Thymeleaf视图解析器，并为解析器注入模板引擎*/
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine(templateResolver()));
        viewResolver.setCharacterEncoding("UTF-8");
        registry.viewResolver(viewResolver);
    }


    @Bean
    public MessageSource messageResource(){
//        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");

        ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("file:///etc/spittr/messages");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}
