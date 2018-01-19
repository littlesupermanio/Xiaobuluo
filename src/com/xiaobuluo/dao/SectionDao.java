package com.xiaobuluo.dao;

import com.xiaobuluo.entity.Section;

import java.util.List;

public interface SectionDao {
    public List<Section> getAllSections();

    public List<Section> getSubSectionsBySectionId(int id);

    public List<Section> getMainSections();

    public Section getSectionById(int id);

}
