package config;

import domain.Product;

import java.beans.BeanProperty;

@Configuration
@ComponentScan("repo\ProductRepository","service\ProductService")
public class ApplicationConfiguration {
    @Bean
    @Scope(ConfigurationBeanFactory.SCOPE_PROTOTYPE)
    public Product simpleProduct(){
        return new Product(title,disc,20,5);
    }
}
