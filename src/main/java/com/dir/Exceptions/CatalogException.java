package com.dir.Exceptions;

public class CatalogException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CatalogException() {
    }
    
    public CatalogException(String message) {
	super(message);
    }
}
