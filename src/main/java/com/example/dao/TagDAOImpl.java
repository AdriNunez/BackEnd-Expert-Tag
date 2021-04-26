package com.example.dao;

import com.example.model.Tag;
import com.example.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TagDAOImpl implements TagDAO {


    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> retrieveAllTags(){
        return manager.createQuery("From Tag",Tag.class).getResultList();
    }

    @Override
    public Tag retrieveTagById(Long id){
        return manager.find(Tag.class,id);
    }

    @Override
    public Tag createTag(Tag tag){
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag){
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long id) {tagRepository.delete(manager.find(Tag.class,id)) ;}



}
