package superPrice.orders.model;

import javax.naming.directory.InvalidAttributesException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Order {

    private long id;
    private Timestamp creatingTime;
    private String deliverTime;
    private String deliveryAddress;
    private String deliveryType;


    public Order(long id, Timestamp creatingTime, String deliverTime, String deliveryAddress, String deliveryType) {
        this.id = id;
        this.creatingTime = creatingTime;
        this.deliverTime = deliverTime;
        this.deliveryAddress = deliveryAddress;
        this.deliveryType = deliveryType;
    }

    public Order(String deliverTime, String deliveryAddress,String deliveryType) throws InvalidAttributesException {
        try {
            // orderInfoValidation(deliveryAddress, deliveryType);
            // deliveryTimeValidation(deliverTime.toInstant());
            this.deliverTime = deliverTime;
            this.deliveryAddress = deliveryAddress;
            this.deliveryType = deliveryType;
        }
         catch (Exception e) {
            throw e;
        }
    }
    private void orderInfoValidation(String deliveryAddress,String deliveryType) throws InvalidAttributesException {
        if (deliveryAddress.length() > 4 &&
                (deliveryType.toLowerCase().equals("express") || deliveryType.toLowerCase() .equals("regular"))){}
        else {
            throw new InvalidAttributesException("invalid delivery information");
        }
    }
    private void deliveryTimeValidation(Instant t1) throws InvalidAttributesException {
        Instant utcNow = Instant.now();
        long diff = utcNow.until(t1, ChronoUnit.DAYS);
        if (diff < 1) {
            throw new InvalidAttributesException("invalid delivery date");
        }
    }


    public long getId() {
        return id;
    }

    public Timestamp getCreatingTime() {
        return creatingTime;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDeliveryType() {
        return deliveryType;
    }


}
