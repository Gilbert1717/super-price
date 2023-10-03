package superPrice.orders.model;

public class OrderItem {
    private long orderId;
    private String barcode;
    private int storeId;

    private int quantity;

    public OrderItem(long orderId, String barcode, int storeId, int quantity) {
        this.orderId = orderId;
        this.barcode = barcode;
        this.storeId = storeId;
        this.quantity = quantity;
    }

    public OrderItem(String barcode, int storeId, int quantity) {
        this.barcode = barcode;
        this.storeId = storeId;
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getStoreId() {
        return storeId;
    }

    public long getOrderId() {
        return orderId;
    }

    public int getQuantity() {
        return quantity;
    }
}
