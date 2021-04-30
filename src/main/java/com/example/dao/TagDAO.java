package com.example.dao;

import com.example.model.Expert;
import com.example.model.Tag;

import java.util.List;

public interface TagDAO {

    public List<Tag> retrieveAllTags(Integer limite,Integer pagina,String nombre,String creador);

    public Tag retrieveTagById(Long id);

    public Tag createTag(Tag tag);

    public Tag updateTag (Tag tag);

    public void deleteTag(Long id);

    public List<Tag> retrieveAllByNombre(String nombre, Integer limite, Integer pagina);

    public List<Tag> retrieveTagsByExpert(String nombre, Integer limite, Integer pagina);
}
