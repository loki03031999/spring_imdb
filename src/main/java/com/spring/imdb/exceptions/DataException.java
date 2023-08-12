package com.spring.imdb.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

@Data
public class DataException extends RuntimeException {
    public enum DataExceptionErrorCode {
        NO_SUCH_ELEMENT_EXCEPTION("object does not exist", HttpStatus.NOT_FOUND),
        MISC_ERROR("unknown error occurred while fetching data from database", HttpStatus.INTERNAL_SERVER_ERROR);

        private final String errorMessage;
        private final HttpStatus httpStatus;

        DataExceptionErrorCode(String message, HttpStatus httpStatus) {
            this.errorMessage = message;
            this.httpStatus = httpStatus;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public HttpStatus getHttpStatus() {
            return httpStatus;
        }
    }

    private final DataExceptionErrorCode dataExceptionErrorCode;

    private DataException(DataExceptionErrorCode dataExceptionErrorCode, String errorMessage) {
        super(errorMessage);
        this.dataExceptionErrorCode = dataExceptionErrorCode;
    }

    private DataException(DataExceptionErrorCode dataExceptionErrorCode) {
        super(dataExceptionErrorCode.getErrorMessage());
        this.dataExceptionErrorCode = dataExceptionErrorCode;
    }

    public HttpStatus getStatus() {
        return dataExceptionErrorCode.getHttpStatus();
    }

    public static void throwError() throws DataException {
        throw new DataException(DataExceptionErrorCode.MISC_ERROR);
    }

    public static void throwError(DataExceptionErrorCode dataExceptionErrorCode) {
        throw new DataException(dataExceptionErrorCode);
    }

}
