package edu.gatech.gtevents.gtevents.shared;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Used to convert between JSON and GTEvent objects.
 */
public class GTEventJsonUtils {
    public static final String NAME_TAG = "name";
    public static final String DESCRIPTION_TAG = "description";
    public static final String TIME_TAG = "time";
    public static final String LOCATION_TAG = "location";
    public static final String ORGANIZATION_TAG = "organization";
    public static final String IS_SAVED_TAG = "isSaved";

    /**
     * Converts the given JSON string into a GTEvent object.
     * @param data the string representation of the JSONObject.
     */
    public static GTEvent jsonToGTEvent(String data) {
        try {
            JSONObject object = new JSONObject(data);
            GTEvent event = new GTEvent();
            event.setName(object.getString(NAME_TAG));
            event.setDescription(object.getString(DESCRIPTION_TAG));
            event.setTime(object.getString(TIME_TAG));
            event.setLocation(object.getString(LOCATION_TAG));
            event.setOrganization(object.getString(ORGANIZATION_TAG));
            event.setSaved(object.getBoolean(IS_SAVED_TAG));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Converts the given GTEvent object into a JSON object.
     */
    public static JSONObject gtEventToJSON(GTEvent event) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(NAME_TAG, event.getName());
            jsonObject.put(DESCRIPTION_TAG, event.getDescription());
            jsonObject.put(TIME_TAG, event.getTime());
            jsonObject.put(LOCATION_TAG, event.getTime());
            jsonObject.put(ORGANIZATION_TAG, event.getDescription());
            jsonObject.put(IS_SAVED_TAG, event.isSaved());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
