package etr.android.flavordi.data.services;

import etr.android.flavordi.models.Repository;

import java.util.ArrayList;
import java.util.List;

public class AppServiceImpl implements AppService {
    @Override
    public List<Repository> searchRepositories(String query) {
        if (query.equals("error")) {
            throw new ApiException("Manual exception");
        }
        List<Repository> results = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            results.add(new Repository("Mock description " + i, "Mock Repository " + i, "http://mock-repo-url"));
        }
        return results;
    }
}
