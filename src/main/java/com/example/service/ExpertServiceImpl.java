package com.example.service;

import com.example.dao.ExpertDAO;
import com.example.model.Expert;
import com.example.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService{

    public ExpertDAO expertDAO;

    public ExpertServiceImpl(ExpertDAO expertDAO){this.expertDAO = expertDAO;};

    @Override
    public List<Expert> retrieveAllExperts(String nombre, String estado,Integer puntuacion,String etiqueta,Integer limite, Integer pagina){ return this.expertDAO.retrieveAllExperts(nombre, estado, puntuacion, etiqueta,limite,pagina);}

    @Override
    public Expert retrieveExpertByID(Long id) { return this.expertDAO.retrieveExpertByID(id);}

    @Override
    public Expert createExpert(Expert expert) {return this.expertDAO.createExpert(expert);}

    @Override
    public Expert updateExpert(Expert expert, Long id) {return this.expertDAO.updateExpert(expert,id);}

    @Override
    public void deleteExpert(Long id) {this.expertDAO.deleteExpert(id);}

    @Override
    public List<Expert> retrieveAllByNombre(String nombre, Integer limite, Integer pagina){return expertDAO.retrieveAllByNombre(nombre,limite,pagina);};

    @Override
    public List<Expert> retrievellByEtiqueta(Long id, Integer limite, Integer pagina){return expertDAO.retrievellByEtiqueta(id,limite,pagina);};

    @Override
    public List<Expert> retrieveAllByModalidad(String modalidad, Integer limite, Integer pagina){return expertDAO.retrieveAllByModalidad(modalidad,limite,pagina);};

    @Override
    public List<Expert> retrieveAllByEstado(String estado, Integer limite, Integer pagina){return expertDAO.retrieveAllByEstado(estado,limite,pagina);};

    @Override
    public List<Expert> retrieveAllExpertsLimite(Integer limite, Integer pagina){return expertDAO.retrieveAllExpertsLimite(limite,pagina);};



}
