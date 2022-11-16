package jaewon.ecommerce.service;

import jaewon.ecommerce.domain.Product;
import jaewon.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @Test
    void purchase() {
        //given
        Product product;
        product = productRepository.findById(1L).orElseThrow(NoSuchElementException::new);
        Long orgQuantity = product.getQuantity();

        //when
        productService.purchase(1L, 10L);

        //then
        assertEquals(orgQuantity - 10L, productRepository.findById(1L).orElseThrow(NoSuchElementException::new).getQuantity());
    }

    @Test
    void join() {
        Product productToAdd = new Product();
        productToAdd.setName("New Product");
        productToAdd.setImageUrl("image.png");
        productToAdd.setPrice(1000L);
        productToAdd.setQuantity(50L);
        productToAdd.setCategory("Hats");
        Long id =  productService.join(productToAdd);

        assertEquals("New Product", productRepository.findById(id).orElseThrow(NoSuchElementException::new).getName());
    }

    @Test
    void validateDuplicateMember() {
        //Given
        Product productToAdd = new Product();
        productToAdd.setName("New Product");
        productToAdd.setImageUrl("image.png");
        productToAdd.setPrice(1000L);
        productToAdd.setQuantity(50L);
        productToAdd.setCategory("Hats");
        productService.join(productToAdd);

        Product productDuplicate = new Product();
        productDuplicate.setName("New Product");
        productDuplicate.setImageUrl("image.png");
        productDuplicate.setPrice(1000L);
        productDuplicate.setQuantity(50L);
        productDuplicate.setCategory("Hats");


        //When
        assertThrows(IllegalStateException.class, () -> productService.join(productDuplicate));
    }
}