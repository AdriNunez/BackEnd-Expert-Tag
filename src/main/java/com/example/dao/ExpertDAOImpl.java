package com.example.dao;

import com.example.model.Expert;
import com.example.model.Tag;
import com.example.repository.ExpertRepository;
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
import java.util.Optional;

@Repository
@Transactional
public class ExpertDAOImpl implements ExpertDAO{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ExpertRepository expertRepository;

    @Autowired
    private TagDAO tagDAO;

   @Override
   public List<Expert> retrieveAllExperts(String nombre, String estado,Integer puntuacion,String etiqueta,Integer limite, Integer pagina){


       CriteriaBuilder builder = manager.getCriteriaBuilder();
       CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
       Root<Expert> root = criteria.from(Expert.class);

       List<Predicate> predicates = new ArrayList<>();

       if (nombre != null) {
           predicates.add(builder.like(root.get("nombre"),"%"+nombre+"%"));

       }
       if (etiqueta != null) {
           Join<Expert, Tag> rootTags = root.join("etiquetas");
           predicates.add(builder.equal(rootTags.get("id"), etiqueta));

       }
       if(puntuacion != null) {
           predicates.add(builder.equal(root.get("puntuacion"),puntuacion));

       }
       if (estado != null) {
           predicates.add(builder.equal(root.get("estado"), estado));
       }

           criteria.distinct(true).select(root).where(builder.and(predicates.toArray(new Predicate[0])));
       TypedQuery<Expert> expertsQuery = manager.createQuery(criteria);
       if(limite!=null && pagina!=null){
           expertsQuery.setFirstResult(pagina);
           expertsQuery.setMaxResults(limite);
       }
       return expertsQuery.getResultList();
    }

    @Override
    public Expert retrieveExpertByID(Long id){
        return manager.find(Expert.class,id);
    }

    @Override
    public Expert createExpert(Expert expert){
        expert.setCreated_at(LocalDateTime.now());
       return expertRepository.save(expert);
    }

    @Override
    public Expert updateExpert(Expert expert,Long id){
        expert.setUpdated_at(LocalDateTime.now());
       return expertRepository.save(expert);
    }

    @Override
    public void deleteExpert(Long id) {expertRepository.delete(manager.find(Expert.class,id)) ;}


    @Override
    public List<Expert> retrieveAllByNombre(String nombre, Integer limite, Integer pagina){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.where(builder.like(root.get("nombre"),"%"+nombre+"%"));

        Query query = manager.createQuery(criteria);
  //     query.setFirstResult(limite);
  //     query.setMaxResults(pagina);
        return query.getResultList();

    }

    @Override
    public List<Expert> retrieveAllByModalidad(String modal, Integer limite, Integer pagina){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("modalidad"),modal));

        Query query = manager.createQuery(criteria);
  //      query.setFirstResult(limite);
        query.setMaxResults(pagina);
        return query.getResultList();

    }


    @Override
    public List<Expert> retrievellByEtiqueta(Long id, Integer limite, Integer pagina){

        Query query = manager.createQuery("From expert e INNER JOIN e.etiquetas where id =" + id);
 //       query.setFirstResult(limite);
        query.setMaxResults(pagina);
        return query.getResultList();

     }



    @Override
    public List<Expert> retrieveAllByEstado(String estado, Integer limite, Integer pagina){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("estado"), estado));

        Query query = manager.createQuery(criteria);
     //   query.setFirstResult(limite);
        query.setMaxResults(pagina);
        return query.getResultList();

    }

    @Override
    public List<Expert> retrieveAllExpertsLimite(Integer limite, Integer pagina){

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);
        criteria.select(root);

        Query query = manager.createQuery(criteria);
      //  query.setFirstResult(limite);
        query.setMaxResults(pagina);
        return query.getResultList();

    }



}
