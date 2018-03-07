package com.parawan.model;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class ActualBeach implements Serializable {

    private Integer id;
    private String name;
    private Integer maxWidth;
    private Integer maxHeight;

    public ActualBeach() {
    }

    public ActualBeach(Integer id, String name, Integer maxWidth, Integer maxHeight) {
        this.id = id;
        this.name = name;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
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

    public Integer getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(Integer maxWidth) {
        this.maxWidth = maxWidth;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }
}
