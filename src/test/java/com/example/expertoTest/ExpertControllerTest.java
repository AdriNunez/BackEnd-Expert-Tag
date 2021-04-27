package com.example.expertoTest;

import com.example.model.Expert;
import com.example.service.ExpertService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ExpertControllerTest {

    @Autowired
    ExpertService service;

    @Test
    public void retrieveAllByNombreTest(){

        List<Expert> expertoList = service.retrieveAllByNombre("Adri",5,0);

        System.out.println(expertoList.toString());
    }
}
