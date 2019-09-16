package by.falizyers.myhome.core;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Configuration
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@EnableJpaRepositories(basePackages = {"by.falizyers.myhome.core.dao.repository"})
@EntityScan(basePackages = {"by.falizyers.myhome.core.entity"})
@ComponentScan(basePackages = {"by.falizyers.myhome.core"})
public @interface EnableCoreConfig {
}
