package au.edu.rmit.sept.cinemas.movies.storePrice.price;

public class Price {
    private String barcode;
    private int storeid;
    private double price;
    private String status;

    public Price() {
    }

    public Price(String barcode, int storeid, double price, String status) {
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
