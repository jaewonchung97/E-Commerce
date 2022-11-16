package jaewon.ecommerce.repository;

import jaewon.ecommerce.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void save() {
        //given
        Product productToAdd = new Product();
        productToAdd.setName("Adidas NMD");
        productToAdd.setImageUrl("https://i.ibb.co/0s3pdnc/adidas-nmd.png");
        productToAdd.setPrice(220L);
        productToAdd.setQuantity(50L);
        productToAdd.setCategory("Sneakers");

        //when
        productRepository.save(productToAdd);
        System.out.println("productToAdd = " + productToAdd.getName());


        //then
        List<Product> all = productRepository.findAll();
        System.out.println("all = " + all.get(0).getId());
        assertEquals(1, all.size());
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
}