package com.example.dao;

import com.example.model.Expert;
import com.example.model.Tag;
import com.example.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Override
    public List<Tag> retrieveAllByNombre(String nombre, Integer limite, Integer pagina){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        criteria.where(builder.like(root.get("nombre"),"%"+nombre+"%"));

        Query query = manager.createQuery(criteria);
        //     query.setFirstResult(limite);
       // query.setMaxResults(pagina);
        return query.getResultList();

    }

    @Override
    public List<Tag> retrieveTagsByExpert(String creador, Integer limite, Integer pagina){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        criteria.where(builder.like(root.get("creador"),creador));

        Query query = manager.createQuery(criteria);
        //     query.setFirstResult(limite);
        // query.setMaxResults(pagina);
        return query.getResultList();

    }

}
