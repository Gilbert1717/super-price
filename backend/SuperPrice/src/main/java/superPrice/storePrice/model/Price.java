package superPrice.storePrice.model;

public class Price {
    private String barcode;
    private int storeid;
    // private String storeName;
    // private String storePostcode;
    // private String productName;
    private double price;
    private String status;

    public Price() {
    }

    public Price(String barcode, int storeid,  double price, String status) {
        this.barcode = barcode;
        this.storeid = storeid;
        this.price = price;
        this.status = status;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getStoreid() {
        return storeid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    // public String getStoreName() {
    //     return storeName;
    // }

    // public void setStoreName(String storeName) {
    //     this.storeName = storeName;
    // }

    // public String getStorePostcode() {
    //     return storePostcode;
    // }

    // public void setStorePostcode(String storePostcode) {
    //     this.storePostcode = storePostcode;
    // }

    // public String getProductName() {
    //     return productName;
    // }

    // public void setProductName(String productName) {
    //     this.productName = productName;
    // }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
