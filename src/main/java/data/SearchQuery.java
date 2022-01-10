package data;

public class SearchQuery {
    private String searchQuery;

    public SearchQuery(String search) {
        this.searchQuery = search;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}