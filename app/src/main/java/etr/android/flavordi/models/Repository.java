package etr.android.flavordi.models;

public class Repository {

    private final String description;

    private final String name;

    private final String htmlUrl;

    public Repository(String description, String name, String htmlUrl) {
        this.description = description;
        this.name = name;
        this.htmlUrl = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Repository that = (Repository) o;

        if (!description.equals(that.description)) return false;
        if (!name.equals(that.name)) return false;
        return htmlUrl.equals(that.htmlUrl);

    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + htmlUrl.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                '}';
    }
}
