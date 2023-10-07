package superPrice.orders.model.DTO;

import java.sql.Timestamp;

public class FindOrderResponse {
    private Timestamp creatingTime;
    private String deliverTime;
    private String deliveryType;

    public FindOrderResponse(Timestamp creatingTime, String deliverTime, String deliveryType) {
        this.creatingTime = creatingTime;
        this.deliverTime = deliverTime;
        this.deliveryType = deliveryType;
    }

    public Timestamp getCreatingTime() {
        return creatingTime;
    }

    public String getDeliverTime() {
        return deliverTime;
    }

    public String getDeliveryType() {
        return deliveryType;
    }
}
