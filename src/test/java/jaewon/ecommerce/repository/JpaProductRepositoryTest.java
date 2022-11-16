package jaewon.ecommerce.repository;

import jaewon.ecommerce.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void save() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByCategory() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByName() {
        Product product = productRepository.findByName("Brown Brim").orElseThrow(NoSuchElementException::new);
        assertEquals(1L, product.getId());
    }
}