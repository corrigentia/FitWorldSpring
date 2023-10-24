package org.corrigentia.fitrest.adal.exceptions;

public class EquipmentNamePriceException extends RuntimeException {
    public EquipmentNamePriceException() {
        super("Equipment name and price combination already exists");
    }

    public EquipmentNamePriceException(String message) {
        super(message);
    }
}
