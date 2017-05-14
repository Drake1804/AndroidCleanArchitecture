package com.androidcleanarchitecture.business.exceptions;

/**
 * Created by drake1804 on 5/14/17.
 */

public class EmptyException extends RuntimeException {

    public EmptyException() {
    }

    public EmptyException(String message) {
        super(message);
    }


}
