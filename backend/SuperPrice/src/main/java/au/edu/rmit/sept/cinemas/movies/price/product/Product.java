package au.edu.rmit.sept.cinemas.movies.price.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Product {
    @Id
    private String barcode;
    private String name;
    private String category;

    public Product() {

    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}