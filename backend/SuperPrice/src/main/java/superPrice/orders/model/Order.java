package superPrice.orders.model;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;

public class Order {

    private long id;
    private Timestamp creatingTime;
    private Timestamp deliverTime;
    private String deliveryAddress;
    private String deliveryType;


    public Order(long id, Timestamp creatingTime, Timestamp deliverTime, String deliveryAddress, String deliveryType) {
        this.id = id;
        this.creatingTime = creatingTime;
        this.deliverTime = deliverTime;
        this.deliveryAddress = deliveryAddress;
        this.deliveryType = deliveryType;
    }

    public Order(Timestamp deliverTime, String deliveryAddress,String deliveryType) {
        this.deliverTime = deliverTime;
        this.deliveryAddress = deliveryAddress;
        this.deliveryType = deliveryType;
    }

    public long getId() {
        return id;
    }

    public Timestamp getCreatingTime() {
        return creatingTime;
    }

    public Timestamp getDeliverTime() {
        return deliverTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliverTime(Timestamp deliverTime) {
        this.deliverTime = deliverTime;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
