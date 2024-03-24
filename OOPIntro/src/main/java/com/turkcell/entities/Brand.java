package com.turkcell.entities;

import java.util.Date;
import java.util.List;

public class Brand extends BaseEntity<Integer>{


    private String name;
    private List<Model> models;

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



//brand.name = "BMW"; //write, set
//System.out.println(brand.name); //