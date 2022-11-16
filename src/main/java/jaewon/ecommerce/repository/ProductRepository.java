package jaewon.ecommerce.repository;

import jaewon.ecommerce.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(Long id);

    Optional<List<Product>> findByCategory(String title);

    List<Product> findAll();

    Optional<Product> findByName(String name);
}
