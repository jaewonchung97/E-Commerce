package jaewon.ecommerce.controller;

import jaewon.ecommerce.service.ProductService;
import jaewon.ecommerce.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ProductController {

    /**
     * Service Bean 접근
     */
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Product List 조회
     */
    @GetMapping("/shop/{category}.do")
    @ResponseBody
    public Optional<List<Product>> shopList(@PathVariable String category) {
        return productService.findProducts(category);
    }


    /**
     * 구매
     */
    @PostMapping("/checkout.do")
    public void Checkout(
            @RequestBody ArrayList<Product> checkoutList
    ) {
        checkoutList.forEach(
                (product) -> {
                    Long quantity = product.getQuantity();
                    Long id = product.getId();
                    productService.purchase(id, quantity);
                }
        );
    }

    /**
     * Product 추가
     */
    @PostMapping("/add.do")
    public String Add(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "imageUrl") String imageUrl,
            @RequestParam(name = "price") Long price,
            @RequestParam(name = "quantity") Long quantity,
            @RequestParam(name = "category") String category
    ) {
        Product productToAdd = new Product();
        productToAdd.setName(name);
        productToAdd.setImageUrl(imageUrl);
        productToAdd.setPrice(price);
        productToAdd.setQuantity(quantity);
        productToAdd.setCategory(category);

        productService.join(productToAdd);
        return "redirect:/";
    }
}