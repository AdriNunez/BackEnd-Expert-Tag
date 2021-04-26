package com.example.dao;

import com.example.model.Expert;

import java.util.List;

public interface ExpertDAO {

   public List<Expert> retrieveAllExperts();

    public Expert retrieveExpertByID(Long id);

    public Expert createExpert(Expert expert);

    public Expert updateExpert(Expert expert,Long id);

    public void deleteExpert(Long id);

    public List<Expert> retrieveAllByNombre(String nombre, Integer limite, Integer pagina);

    public List<Expert> retrievellByEtiqueta(Long id, Integer limite, Integer pagina);

    public List<Expert> retrieveAllByModalidad(String modalidad, Integer limite, Integer pagina);

    public List<Expert> retrieveAllByEstado(String estado, Integer limite, Integer pagina);

    public List<Expert> retrieveAllExpertsLimite(Integer limite, Integer pagina);

//      if (nombre != null) {
//        return expertService.retrieveAllByNombre(nombre, limite, pagina);
//
//    } else if (etiqueta != null) {
//        return expertService.retrievellByEtiqueta(etiqueta, limite, pagina);
//
//    }else if(modalidad != null) {
//        return expertService.retrieveAllByModalidad(modalidad, limite, pagina);
//
//    }else if (estado != null) {
//        return expertService.retrieveAllByEstado(estado, limite, pagina);
//    }
//
//        return expertService.retrieveAllExpertsLimite(limite, pagina);

}
