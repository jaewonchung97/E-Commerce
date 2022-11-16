package jaewon.ecommerce.controller;

import jaewon.ecommerce.service.ProductService;
import jaewon.ecommerce.domain.Product;
import jaewon.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class HelloController {
    private final ProductService productService;

    private final ProductRepository productRepository;

    @Autowired
    public HelloController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/shop/{category}")
    @ResponseBody
    public Optional<List<Product>> shopList(@PathVariable String category) {
        return productRepository.findByCategory(category);
    }


    @PostMapping("/checkout.do")
    public String Purchase(
            @RequestBody ArrayList<HashMap<String, String>> request
            ) {
        System.out.println("request = " + request);
        request.forEach(
                (product) ->{
                    Long quantity = Long.valueOf(product.get("quantity"));
                    Long id = Long.valueOf(product.get("id"));
                    productService.purchase(id, quantity);
                }
        );
        return "redirect:/";
    }

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
        return ":redirect:/";
    }
}