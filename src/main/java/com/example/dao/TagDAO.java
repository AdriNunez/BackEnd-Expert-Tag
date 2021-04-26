package com.example.dao;

import com.example.model.Tag;

import java.util.List;

public interface TagDAO {

    public List<Tag> retrieveAllTags();

    public Tag retrieveTagById(Long id);

    public Tag createTag(Tag tag);

    public Tag updateTag (Tag tag);

    public void deleteTag(Long id);

}
