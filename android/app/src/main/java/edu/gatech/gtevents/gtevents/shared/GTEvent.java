package edu.gatech.gtevents.gtevents.shared;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A container for the basic GT Event holding information that can be passed between server and
 * native frontend.
 */
public class GTEvent implements Parcelable {
    // TODO (acalabrese): I don't think these need to be private, however, we are going to need to
    // come up with some utils to convert to and from JSON.
    public String name;
    public String description;
    public String time;
    public String location;
    public String organization;

    public GTEvent() {}

    protected GTEvent(Parcel in) {
        name = in.readString();
        description = in.readString();
        time = in.readString();
        location = in.readString();
        organization = in.readString();
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
}
