package jaewon.ecommerce.repository;

import jaewon.ecommerce.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Repository
 */
public interface ProductRepository {
    Long save(Product product);

    Optional<Product> findById(Long id);

    Optional<List<Product>> findByCategory(String title);

    Optional<List<Product>> findAll();

    Optional<Product> findByName(String name);
}
