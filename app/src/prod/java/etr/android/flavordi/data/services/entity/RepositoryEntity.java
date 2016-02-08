package etr.android.flavordi.data.services.entity;

import com.google.gson.annotations.SerializedName;

public class RepositoryEntity {

    @SerializedName("description")
    public String description;

    @SerializedName("name")
    public String name;

    @SerializedName("html_url")
    public String htmlUrl;
}
