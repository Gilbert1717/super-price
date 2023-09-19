package superPrice.orders.model;

public class OrderProductStore {
    private String barcode;
    private int storeId;
    private long orderId;
    private int quantity;

    public OrderProductStore(String barcode, int storeId, long orderId, int quantity) {
        this.barcode = barcode;
        this.storeId = storeId;
        this.orderId = orderId;
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
