package superPrice.orders.model;

import java.sql.Timestamp;

public class OrderDTO {
    private String deliverTime;
    private String deliveryAddress;

    public OrderDTO(String deliverTime, String deliveryAddress) {
        this.deliverTime = deliverTime;
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
