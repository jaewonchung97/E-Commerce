package jaewon.ecommerce.service;

import jaewon.ecommerce.domain.Product;
import jaewon.ecommerce.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private void validateDuplicateMember(Product product) {
        productRepository.findByName(product.getName()).ifPresent(p -> {
            throw new IllegalStateException("Product already Exists, Name: " + p.getName());
        });
    }

    public Long join(Product product) {
        validateDuplicateMember(product);
        return productRepository.save(product);
    }

    public void purchase(Long id, Long quantity) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("the Product does not Exist"));
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }

    public Optional<List<Product>> findProducts(String category){
        if("all".equals(category)) return productRepository.findAll();
        return productRepository.findByCategory(category);
    }

}
