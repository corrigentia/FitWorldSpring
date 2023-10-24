package org.corrigentia.fitrest.adal.exceptions;

public class EquipmentNullException extends RuntimeException {
    public EquipmentNullException() {
        super("Equipment should not be null");
    }

    public EquipmentNullException(String message) {
        super(message);
    }
}
