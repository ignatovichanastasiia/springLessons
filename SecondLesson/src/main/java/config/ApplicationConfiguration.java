package config;

import domain.Cart;
import domain.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.beans.BeanProperty;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Configuration
@ComponentScan({})
public class ApplicationConfiguration {
//    @Bean
//    @Scope(SCOPE_PROTOTYPE)
//    public Product simpleProduct(){
//        return new Product(10001,"title",20000);
//    }

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public Cart clientCart(){
        return new Cart();
    }
}
