package TestData;

public class Search {
    private String searchQuery;
    private String searchFirstResult;

    public Search(String searchQuery, String searchFirstResult) {

        this.searchQuery = searchQuery;
        this.searchFirstResult = searchFirstResult;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public String getSearchFirstResult() {
        return searchFirstResult;
    }
}

