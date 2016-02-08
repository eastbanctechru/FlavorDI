package etr.android.flavordi.data.services;

public class ApiException extends RuntimeException {
    public ApiException(Exception e) {
        super(e);
    }

    public ApiException(String message) {
        super(message);
    }
}
