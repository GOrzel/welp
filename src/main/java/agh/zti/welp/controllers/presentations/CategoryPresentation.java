package agh.zti.welp.controllers.presentations;

import agh.zti.welp.persistence.Category;

public class CategoryPresentation {

    private long id;
    private String name;

    public CategoryPresentation(){

    }

    public CategoryPresentation(Category category){
        this.id = category.getId();
        this.name = category.getName();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
