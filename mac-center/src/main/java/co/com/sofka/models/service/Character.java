package co.com.sofka.models.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    private String id;
    private String name;

    public Character() {
    }

    public Character(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id) && Objects.equals(name, character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
