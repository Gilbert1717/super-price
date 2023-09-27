package superPrice.storePrice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import superPrice.storePrice.service.StorePriceService;
import superPrice.storePrice.model.Product;
import superPrice.storePrice.model.StorePrice;
import superPrice.storePrice.model.Store;

import java.util.Collection;

@CrossOrigin
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

    @GetMapping(value = "ten")
    public Collection<StorePrice> findTen() {
        return this.service.findTenSpecials();
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
