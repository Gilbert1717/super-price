package superPrice.orders.model.DTO;

public class FindItemResponse {
    private String product_name;

    private String storeName;
    private int quantity;
    private double price;
    public FindItemResponse(String product_name, String storeName, int quantity, double price) {
        this.product_name = product_name;
        this.storeName = storeName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
