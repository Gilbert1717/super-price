package superPrice.orders.model.DTO;

public class ErrorResponse {
    private final String message;

    public ErrorResponse(Exception e) {
        this.message = e.getMessage();
    }

    public String getMessage() {
        return message;
    }
}
