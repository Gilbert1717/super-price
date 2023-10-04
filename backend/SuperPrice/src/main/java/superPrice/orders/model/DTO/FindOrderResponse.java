package superPrice.orders.model.DTO;

import java.sql.Timestamp;

public class FindOrderResponse {
    private Timestamp creatingTime;
    private Timestamp deliverTime;
    private String deliveryType;

    public FindOrderResponse(Timestamp creatingTime, Timestamp deliverTime, String deliveryType) {
        this.creatingTime = creatingTime;
        this.deliverTime = deliverTime;
        this.deliveryType = deliveryType;
    }

    public Timestamp getCreatingTime() {
        return creatingTime;
    }

    public Timestamp getDeliverTime() {
        return deliverTime;
    }

    public String getDeliveryType() {
        return deliveryType;
    }
}
