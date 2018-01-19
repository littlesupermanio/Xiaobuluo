package com.xiaobuluo.entity;

import java.util.List;

public class Section {
    private Integer id;
    private String name;
    private Integer manager_id;
    private Integer parent_id;
    private Section parent_section;

    private List<Section> subSections;
    private Integer posts_count;

    public Integer getPosts_count() {
        return posts_count;
    }


    public Section getParent_section() {
        return parent_section;
    }

    public void setParent_section(Section parent_section) {
        this.parent_section = parent_section;
    }

    public void setPosts_count(Integer posts_count) {
        this.posts_count = posts_count;
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

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public List<Section> getSubSections() {
        return subSections;
    }

    public void setSubSections(List<Section> subSections) {
        this.subSections = subSections;
    }
}
