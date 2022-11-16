package jaewon.ecommerce.service;

import jaewon.ecommerce.domain.Product;
import jaewon.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired ProductService productService;
    @Autowired ProductRepository productRepository;

    @Test
    void purchase() {
        //given
        Product product = productRepository.findById(1L).get();
        Long orgQuantity = product.getQuantity();

        //when
        productService.purchase(1L, 10L);

        //then
        assertEquals(orgQuantity - 10L, productRepository.findById(1L).get().getQuantity());
    }
}