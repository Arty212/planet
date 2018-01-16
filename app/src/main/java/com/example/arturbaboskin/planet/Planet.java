package com.example.arturbaboskin.planet;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Table;

@Table
public class Planet {
    long id;
    String name;
    @SerializedName("img")
    String bitmapUrl;
}
