package com.example.vegabalanceapp.models;

import java.io.Serializable;
import java.util.List;

public class Plate implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private List<SingleItemModel> ingredients;

    public Plate(Integer id, String name, String description, List<SingleItemModel> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SingleItemModel> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<SingleItemModel> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
