package au.edu.rmit.sept.cinemas.movies.price;

import au.edu.rmit.sept.cinemas.movies.price.product.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "price")
public class PriceController {
    private PriceService PriceService;

    public PriceController(PriceService productService) {
        this.PriceService = productService;
    }
    @GetMapping
    public Collection<Product> findProductByCategory(String category) {
        return this.PriceService.SearchByCategory(category);
    }
//    @GetMapping(value = "hw")
//    public String all() {
//        return "Hello world!";
//    }
}
