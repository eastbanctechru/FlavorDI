package etr.android.flavordi.data.services.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiRepositorySearchEntity {

    @SerializedName("items")
    public List<RepositoryEntity> items;
}
