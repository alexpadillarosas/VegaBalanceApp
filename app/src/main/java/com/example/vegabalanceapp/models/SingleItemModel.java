package com.example.vegabalanceapp.models;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class SingleItemModel implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private Double portion;
    private Integer imageResId;
    private Integer sectionId;

    public SingleItemModel() {

    }

    public SingleItemModel(Integer id, String name, String description, Double portion,  Integer imageResId, Integer sectionId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.portion = portion;
        this.imageResId = imageResId;
        this.sectionId = sectionId;
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPortion() {
        return portion;
    }

    public void setPortion(Double portion) {
        this.portion = portion;
    }

    public Integer getImageResId() {
        return imageResId;
    }

    public void setImageResId(Integer imageResId) {
        this.imageResId = imageResId;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    @Override
    public String toString() {
        return "SingleItemModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageResId=" + imageResId +
                ", description='" + description + '\'' +
                ", portion=" + portion +
                ", sectionId=" + sectionId +
                '}';
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj==null) return false;
        if (!(obj instanceof SingleItemModel))
            return false;
        return  this.id.equals( ((SingleItemModel)obj).id );
//        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.id;
    }

}

