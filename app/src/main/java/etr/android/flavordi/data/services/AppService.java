package etr.android.flavordi.data.services;

import etr.android.flavordi.models.Repository;

import java.util.List;

public interface AppService {
    List<Repository> searchRepositories(String query);
}
