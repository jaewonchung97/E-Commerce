package jaewon.ecommerce.service;

import jaewon.ecommerce.domain.Product;
import jaewon.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Service Bean
 */
@Transactional
public class ProductService {
    /**
     * Repository Bean 접근
     */
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Product 중복 확인
     */
    private void validateDuplicateMember(Product product) {
        productRepository.findByName(product.getName()).ifPresent(p -> {
            throw new IllegalStateException("Product already Exists");
        });
    }

    /**
     * Product 중복 확인 후 등록
     */
    public Long join(Product product) {
        validateDuplicateMember(product);
        return productRepository.save(product);
    }

    /**
     * Product 확인 후 DB Update
     */
    public void purchase(Long id, Long quantity) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("the Product does not Exist"));
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }

    /**
     * Param 확인 후 전체 조회 or 카테고리 별 조회
     */
    public Optional<List<Product>> findProducts(String category){
        if("all".equals(category)) return productRepository.findAll();
        return productRepository.findByCategory(category);
    }

}
