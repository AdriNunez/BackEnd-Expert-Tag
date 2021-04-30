package com.example.dao;

import com.example.model.Expert;
import com.example.model.Tag;
import com.example.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class TagDAOImpl implements TagDAO {


    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> retrieveAllTags(Integer limite,Integer pagina,String nombre,String creador){
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);
        List<Predicate> predicates = new ArrayList<>();

        if (nombre != null) {
            predicates.add(builder.like(root.get("nombre"),nombre+"%"));

        }
        if (creador != null) {
            predicates.add(builder.like(root.get("creador"),creador));

        }
        criteria.distinct(true).select(root).where(builder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<Tag> tagsQuery = manager.createQuery(criteria);
        if(limite!=null && pagina!=null){
            tagsQuery.setFirstResult(pagina);
            tagsQuery.setMaxResults(limite);
        }
        return tagsQuery.getResultList();
//        return manager.createQuery("From Tag",Tag.class).getResultList();
    }

    @Override
    public Tag retrieveTagById(Long id){
        return manager.find(Tag.class,id);
    }

    @Override
    public Tag createTag(Tag tag){
        tag.setCreated_at(LocalDateTime.now());
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(Tag tag){
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long id) {

        Query queryNative = manager.createNativeQuery("delete from expertos_etiquetas where tag_id = "+ id);
        queryNative.executeUpdate();
        tagRepository.delete(manager.find(Tag.class,id)) ;

    }

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
