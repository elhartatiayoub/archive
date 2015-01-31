package com.archive.spring.shiro;

import java.util.HashMap;
import java.util.Map;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class SecurityConfig {
    
    @Autowired
    private DefaultWebSecurityManager securityManager;

    @Bean
    public ShiroRealm customSecurityRealm() {
        return new ShiroRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManag = new DefaultWebSecurityManager();
        securityManag.setRealm(customSecurityRealm());
        return securityManag;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean() {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(new Object[]{securityManager()});
        return methodInvokingFactoryBean;
    }

    @Bean
    @DependsOn(value = "lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
    
    @Bean
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        Map<String, String> definitionsMap = new HashMap<String,String>();
        definitionsMap.put("/auth/**", "authc");
        shiroFilter.setFilterChainDefinitionMap(definitionsMap);
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setUnauthorizedUrl("/home");
        shiroFilter.setSecurityManager(securityManager);
        return shiroFilter;
    }

}
