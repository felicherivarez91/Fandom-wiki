package com.example.wiki_fandom.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Wiki implements Serializable {

    @SerializedName("items")
    private List<Wiki> mitems;

    @SerializedName("name")
    private String mname;

    @SerializedName("hub")
    private String mhub;

    @SerializedName("topic")
    private String mtopic;

    @SerializedName("stats")
    private Stats mstats;

    @SerializedName("image")
    private String mimage;

    public String getMname() {
        return mname;
    }

    public String getMhub() {
        return mhub;
    }

    public List<Wiki> getMitems() {
        return mitems;
    }

    public String getmtopic() {
        return mtopic;
    }

    public Stats getmstats(){
        return mstats;
    }

    public String getMimage(){
        return mimage;
    }

    public class Stats implements Serializable{

        @SerializedName("articles")
        private String marticles;

        public String getMarticles(){
            return marticles;
        }
    }

}