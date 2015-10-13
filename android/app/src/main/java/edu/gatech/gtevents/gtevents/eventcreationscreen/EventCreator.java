package edu.gatech.gtevents.gtevents.eventcreationscreen;

/**
 * Creates the event by talking with the server passing the information from the activity.
 */
public class EventCreator {

    /**
     * Communicates with the server and creates the event using the provided information.
     * @param name the name of the event to be created.
     * @param description a description of the event.
     * @param time the time for the event.
     * @param organization the organization associated with the event.
     * @param location the location the event is taking place.
     * @param twitter true if the user wants to share on twitter.
     * @param facebook true if the user wants to share on facebook.
     * @return true if successful, false otherwise.
     */
    public static boolean createEvent(String name, String description, String time,
                                      String organization, String location, boolean twitter,
                                      boolean facebook) {
        // TODO (acalabrese): We need to communicate with the server here.
        return true;
    }
}
