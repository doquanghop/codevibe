package com.github.doquanghop.shared.config;

import com.github.doquanghop.shared.aop.ActionLogAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@org.springframework.boot.autoconfigure.AutoConfiguration
@ConditionalOnClass(ActionLogAspect.class)
@EnableAspectJAutoProxy
public class AutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public ActionLogAspect actionLogAspect() {
        return new ActionLogAspect();
    }
}