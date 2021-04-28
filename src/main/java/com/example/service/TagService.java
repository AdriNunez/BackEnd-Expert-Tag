package com.example.service;

import com.example.model.Expert;
import com.example.model.Tag;

import java.util.List;

public interface TagService {

    public List<Tag> retrieveAllTags();

    public Tag retrieveTagById(Long id);

    public Tag createTag(Tag tag);

    public Tag updateTag (Tag tag);

    public void deleteTag(Long id);

    public List<Tag> retrieveAllByNombre(String nombre, Integer limite, Integer pagina);
}
