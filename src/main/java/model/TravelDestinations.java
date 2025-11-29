package model;

public class TravelDestinations {
    private int id;
    private String name;
    private String country;
    private int popularity;
    private int isVisited;
    private String bestSeason;

    public TravelDestinations(int id, String name, String country, int popularity, int isVisited, String bestSeason) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.popularity = popularity;
        this.isVisited = isVisited;
        this.bestSeason = bestSeason;
    }

    public TravelDestinations() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(int isVisited) {
        this.isVisited = isVisited;
    }

    public String getBestSeason() {
        return bestSeason;
    }

    public void setBestSeason(String bestSeason) {
        this.bestSeason = bestSeason;
    }
}
