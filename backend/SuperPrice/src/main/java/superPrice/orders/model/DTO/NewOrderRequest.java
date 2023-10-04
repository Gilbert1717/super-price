package superPrice.orders.model.DTO;

import superPrice.orders.model.OrderItem;

import java.util.Collection;

public class NewOrderRequest {
    private final String deliveryType;
    private Collection<OrderItem> orderItems;
    private String deliverTime;
    private String deliveryAddress;




    public NewOrderRequest(String deliverTime, String deliveryAddress, String deliveryType, Collection<OrderItem> orderItems) {
        this.deliverTime = deliverTime;
        this.deliveryAddress = deliveryAddress;
        this.deliveryType = deliveryType;
        this.orderItems = orderItems;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public String getDeliveryType() {
        return deliveryType;
    }
}
