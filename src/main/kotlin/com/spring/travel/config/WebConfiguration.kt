package com.spring.travel.config

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfiguration : WebMvcConfigurer {

    //lucy xss
    @Bean
    fun filterRegistrationBean(): FilterRegistrationBean<XssEscapeServletFilter> {
        var filterRegistration = FilterRegistrationBean<XssEscapeServletFilter>()
        filterRegistration.filter = XssEscapeServletFilter()
        filterRegistration.order = 1
        filterRegistration.addUrlPatterns("/*")
        return filterRegistration
    }

}
