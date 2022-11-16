package jaewon.ecommerce.configuration;

import jaewon.ecommerce.repository.JpaProductRepository;
import jaewon.ecommerce.repository.ProductRepository;
import jaewon.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class ProductConfig {
    private final ProductRepository productRepository;
    private final EntityManager em;
    @Autowired
    public ProductConfig(ProductRepository productRepository, EntityManager em) {
        this.productRepository = productRepository;
        this.em = em;
    }
    @Bean
    public ProductService productService(){
        return new ProductService(productRepository);
    }
}