package co.com.sofka.models.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private List<Hero> results;

    public Data() {
    }

    public Data(List<Hero> results) {
        this.results = results;
    }

    public List<Hero> getResults() {
        return results;
    }

    public void setResults(List<Hero> results) {
        this.results = results;
    }
}
