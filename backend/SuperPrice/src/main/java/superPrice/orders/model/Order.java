package superPrice.orders.model;

import java.time.LocalTime;

public class Order {

    private long id;
    private LocalTime creatingTime;
    private LocalTime deliverTime;
    private String deliveryAddress;
    public Order(int id, LocalTime creatingTime, LocalTime deliverTime, String deliveryAddress) {
        this.id = id;
        this.creatingTime = creatingTime;
        this.deliverTime = deliverTime;
        this.deliveryAddress = deliveryAddress;
    }

    public long getId() {
        return id;
    }

    public LocalTime getCreatingTime() {
        return creatingTime;
    }

    public LocalTime getDeliverTime() {
        return deliverTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliverTime(LocalTime deliverTime) {
        this.deliverTime = deliverTime;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
