package exceptions;

public class BrowserNotSupportedException extends RuntimeException {
    public BrowserNotSupportedException(String str) {
        super(String.format("%s browser is not supported!", str));
    }
}
