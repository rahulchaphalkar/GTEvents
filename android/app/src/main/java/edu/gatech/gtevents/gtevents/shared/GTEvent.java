package edu.gatech.gtevents.gtevents.shared;

/**
 * A container for the basic GT Event holding information that can be passed between server and
 * native frontend.
 */
public class GTEvent {
    // TODO (acalabrese): I don't think these need to be private, however, we are going to need to
    // come up with some utils to convert to and from JSON.
    public String name;
    public String description;
    public String time;
    public String location;
    public String organization;

    public GTEvent() {}
}
