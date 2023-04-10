package com.urban.deliveryservice.exceptions;

public class DeliveryNotFoundException extends Exception{

    public DeliveryNotFoundException(){
        super("Delivery not found!");
    }
}
