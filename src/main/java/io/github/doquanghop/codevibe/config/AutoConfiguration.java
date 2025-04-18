package io.github.doquanghop.codevibe.config;

import io.github.doquanghop.codevibe.aop.ActionLogAspect;
import io.github.doquanghop.codevibe.helper.SensitiveDataMasker;
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
    public SensitiveDataMasker sensitiveDataMasker() {
        return new SensitiveDataMasker();
    }

    @Bean
    @ConditionalOnMissingBean
    public ActionLogAspect actionLogAspect(SensitiveDataMasker sensitiveDataMasker) {
        return new ActionLogAspect(sensitiveDataMasker);
    }
}