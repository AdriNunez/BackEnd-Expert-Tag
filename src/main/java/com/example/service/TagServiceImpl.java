package com.example.service;

import com.example.dao.TagDAO;
import com.example.model.Expert;
import com.example.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{

    private TagDAO tagDAO;

    public TagServiceImpl(TagDAO tagDAO) { this.tagDAO = tagDAO;}

    @Override
    public List<Tag> retrieveAllTags(Integer limite,Integer pagina,String nombre,String creador) { return this.tagDAO.retrieveAllTags(limite,pagina,nombre,creador);}

    @Override
    public Tag retrieveTagById(Long id) {return this.tagDAO.retrieveTagById(id);}

    @Override
    public Tag createTag (Tag tag) {return this.tagDAO.createTag(tag);}

    @Override
    public Tag updateTag (Tag tag) {return this.tagDAO.updateTag(tag);}

    @Override
    public void deleteTag (Long id) {this.tagDAO.deleteTag(id);}

    @Override
    public List<Tag> retrieveAllByNombre(String nombre, Integer limite, Integer pagina){return tagDAO.retrieveAllByNombre(nombre,limite,pagina);};

    @Override
    public List<Tag> retrieveTagsByExpert(String creador, Integer limite, Integer pagina){return tagDAO.retrieveTagsByExpert(creador,limite,pagina);};
}
