package com.urban.vehicleservice.exceptions;

public class VehicleIdentifyExistException extends Exception{

    public VehicleIdentifyExistException(String message) {
        super("This Identify: "+message+" is Already Exist !");
    }

}
