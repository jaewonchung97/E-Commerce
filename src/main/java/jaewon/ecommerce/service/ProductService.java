package jaewon.ecommerce.service;

import jaewon.ecommerce.domain.Product;
import jaewon.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void purchase(Long id, Long quantity){
        Optional<Product> product = productRepository.findById(id);
        product.get().setQuantity(product.get().getQuantity()-quantity);
        productRepository.save(product.get());
    }

    public List<Product> findByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
