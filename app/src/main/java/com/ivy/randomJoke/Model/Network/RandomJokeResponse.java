package com.ivy.randomJoke.Model.Network;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class for the api response.
 */
public class RandomJokeResponse implements Parcelable {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("setup")
    @Expose
    private String setup;
    @SerializedName("punchline")
    @Expose
    private String punchline;
    public final static Parcelable.Creator<RandomJokeResponse> CREATOR = new Creator<RandomJokeResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public RandomJokeResponse createFromParcel(Parcel in) {
            return new RandomJokeResponse(in);
        }

        public RandomJokeResponse[] newArray(int size) {
            return (new RandomJokeResponse[size]);
        }

    };

    protected RandomJokeResponse(Parcel in) {
        this.id = ((long) in.readValue((long.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.setup = ((String) in.readValue((String.class.getClassLoader())));
        this.punchline = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     */
    public RandomJokeResponse() {
    }

    /**
     * @param punchline
     * @param setup
     * @param id
     * @param type
     */
    public RandomJokeResponse(long id, String type, String setup, String punchline) {
        super();
        this.id = id;
        this.type = type;
        this.setup = setup;
        this.punchline = punchline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(type);
        dest.writeValue(setup);
        dest.writeValue(punchline);
    }

    public int describeContents() {
        return 0;
    }

}
