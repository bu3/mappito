package it.mappito.thing;

public class ThingNotFoundException extends RuntimeException {

    public ThingNotFoundException() {
    }

    public ThingNotFoundException(String message) {
        super(message);
    }
}
