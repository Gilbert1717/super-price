package superPrice.storePrice.product;


//import au.edu.rmit.sept.cinemas.movies.price.StorePrice;

public class Product {
    private String barcode;
    private String name;
    private String category;

    public Product() {

    }

    public Product(String barcode, String name, String category) {
        this.barcode = barcode;
        this.name = name;
        this.category = category;
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