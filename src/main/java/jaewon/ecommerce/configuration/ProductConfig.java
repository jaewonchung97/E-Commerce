package jaewon.ecommerce.configuration;

import jaewon.ecommerce.repository.ProductRepository;
import jaewon.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    /**
     * Repository Bean 접근
     */
    private final ProductRepository productRepository;
    @Autowired
    public ProductConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Service Bean 등록
     */
    @Bean
    public ProductService productService(){
        return new ProductService(productRepository);
    }
}