package org.loose.fis.sre.exceptions;

public class DestinationIncompleteException extends Exception{

    public DestinationIncompleteException() {
        super(String.format("Not enough data of the destination!"));
    }

}
