package com.example.service;

import com.example.model.Expert;

import java.util.List;

public interface ExpertService {

   public List<Expert> retrieveAllExperts(String nombre, String estado,Integer puntuacion,Long etiqueta,Integer limite, Integer pagina);

    public Expert retrieveExpertByID(Long id);

    public Expert createExpert(Expert expert);

    public Expert updateExpert(Expert expert,Long id);

    public void deleteExpert(Long id);

    public List<Expert> retrieveAllByNombre(String nombre, Integer limite, Integer pagina);

    public List<Expert> retrievellByEtiqueta(Long id, Integer limite, Integer pagina);

    public List<Expert> retrieveAllByModalidad(String modalidad, Integer limite, Integer pagina);

    public List<Expert> retrieveAllByEstado(String estado, Integer limite, Integer pagina);

    public List<Expert> retrieveAllExpertsLimite(Integer limite, Integer pagina);

}
