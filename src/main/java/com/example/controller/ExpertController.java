package com.example.controller;

import com.example.model.Expert;
import com.example.model.Tag;
import com.example.service.ExpertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/API")
@CrossOrigin(origins = "http://localhost:4200", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ExpertController {

    private ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }
//
//    @GetMapping("/expertos")
//    public List<Expert> retrieveAllExperts() {
//        return expertService.retrieveAllExperts();
//    }

    @GetMapping("/expertos/{id}")
    public ResponseEntity<Expert> retrieveExpertById(@PathVariable Long id) {
        return ResponseEntity.ok().body(expertService.retrieveExpertByID(id));
    }

    @GetMapping("/expertos")
    public List<Expert> retrieveByFilter( @RequestParam(name="limite", required=false ) Integer limite,
                                          @RequestParam(name="pagina", required=false) Integer pagina,
                                          @RequestParam(name="nombre", required=false) String nombre,
                                          @RequestParam(name="etiqueta",required=false) String etiqueta,
                                          @RequestParam(name="puntuacion",required=false) Integer puntuacion,
                                          @RequestParam(name="estado",required=false) String estado) {

//
//        if (nombre != null) {
//            return expertService.retrieveAllByNombre(nombre, limite, pagina);
//
//        } else if (etiqueta != null) {
//            return expertService.retrievellByEtiqueta(etiqueta, limite, pagina);
//
//        }else if(modalidad != null) {
//            return expertService.retrieveAllByModalidad(modalidad, limite, pagina);
//
//        }else if (estado != null) {
//            return expertService.retrieveAllByEstado(estado, limite, pagina);
//        }
//        else{

            return expertService.retrieveAllExperts(nombre,estado,puntuacion,etiqueta,limite,pagina);
//        }
    }


    @PostMapping("/expertos")
    public ResponseEntity<Expert> createExpert(@RequestBody Expert expert) throws URISyntaxException {
        if (expert.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Expert expertCreation = expertService.createExpert(expert);
            return ResponseEntity.created(new URI("/API/expert" + expertCreation.getId())).body(expertCreation);
        }
    }

    @PutMapping("/expertos/{id}")
    public ResponseEntity<Expert> updateExpert(@RequestBody Expert expert, @PathVariable Long id){
        if(expert.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return ResponseEntity.ok().body(expertService.updateExpert(expert,id));
        }
    }

    @DeleteMapping("/expertos/{id}")
    public void deleteExpert(@PathVariable Long id){
       expertService.deleteExpert(id);
    }


}

