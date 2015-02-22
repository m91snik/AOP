/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.business.exception;

public class ImportantException extends BusinessException {
    public ImportantException() {
    }

    public ImportantException(String message) {
        super(message);
    }

    public ImportantException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImportantException(Throwable cause) {
        super(cause);
    }
}
