package superPrice.storePrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import superPrice.storePrice.product.Product;
import superPrice.storePrice.store.Store;

import java.util.Collection;

@RestController
@RequestMapping(value = "price")
public class StorePriceController {
    private final StorePriceService service;

    @Autowired
    public StorePriceController(StorePriceService storePriceService) {
        this.service = storePriceService;
    }

    @GetMapping(value = "product/category:{category}")
    public Collection<Product> findProductByCategory(@PathVariable String category) {
        return this.service.findProductByCategory(category);
    }

    @GetMapping(value = "product")
    public Collection<Product> findAllProducts() {
        return this.service.findAllProducts();
    }

    @GetMapping(value = "product/barcode:{barcode}")
    public Product findProductByBarcode(@PathVariable String barcode) {
        return this.service.findProductByBarcode(barcode);
    }

    @GetMapping(value = "storePrice/{barcode}")
    public Collection<StorePrice> findPriceByProductBarcode(@PathVariable String barcode) {
        return this.service.findStorePriceByBarcode(barcode);
    }

    @GetMapping(value = "store/{storeid}")
    public Store findStoreByStoreId(@PathVariable String storeid) {
        return this.service.findStoreById(storeid);
    }

    @GetMapping(value = "product/name:{name}")
    public Collection<Product> findProductByName(@PathVariable String name) {
        return this.service.findProductByName(name);
    }

    @GetMapping(value = "product/{condition}")
    public Collection<Product> findProductByAnyCondition(@PathVariable String condition) {
        return this.service.findProductsByAnyCondition(condition);
    }
}
