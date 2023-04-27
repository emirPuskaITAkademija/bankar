package ba.bank.bank.transfer;

public class ResponseModel {
    private boolean success;
    private String message;

    public ResponseModel(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
