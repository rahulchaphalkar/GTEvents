package edu.gatech.gtevents.gtevents.shared;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A container for the basic GT Event holding information that can be passed between server and
 * native frontend.
 */
public class GTEvent implements Parcelable {
    protected String name;
    protected String description;
    protected String time;
    protected String location;
    protected String organization;
    protected boolean isSaved;

    public GTEvent() {}

    protected GTEvent(Parcel in) {
        name = in.readString();
        description = in.readString();
        time = in.readString();
        location = in.readString();
        organization = in.readString();
        // TODO(acalabrese): Need a way to set this.
        isSaved = false;
    }

    public static final Creator<GTEvent> CREATOR = new Creator<GTEvent>() {
        @Override
        public GTEvent createFromParcel(Parcel in) {
            return new GTEvent(in);
        }

        @Override
        public GTEvent[] newArray(int size) {
            return new GTEvent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(time);
        dest.writeString(location);
        dest.writeString(organization);
    }

    /**
     * @returns the name of the event.
     */
    public String getName() {
        return name;
    }

    /**
     * @returns the description of the event.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @returns the time string of the event.
     */
    public String getTime() {
        return time;
    }

    /**
     * @returns the location of the event.
     */
    public String getLocation() {
        return location;
    }

    /**
     * @returns the name of the event.
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * @returns if the event was saved or not.
     */
    public boolean isSaved() {
        return isSaved;
    }

    /**
     * Sets the name of the event.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the event.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the time string of the event.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Sets the location of the event.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the organization of the event.
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * Sets whether or not the event is saved.
     */
    public void setSaved(boolean saved) {
        isSaved = saved;
    }
}
