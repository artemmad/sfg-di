package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Profile({"ES", "default"})
    @Bean("i18nService") // we should declare this bean name because we can't define two methods with same name ib Java
    I18NSpanishService i18nSpanishService(){
        return new I18NSpanishService();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(){ //this gona be the service na,e
        return new I18nEnglishGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

}
