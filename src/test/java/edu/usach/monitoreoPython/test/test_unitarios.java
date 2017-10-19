/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.usach.monitoreoPython.test;

import edu.usach.monitoreoPython.controller.CoordinacionController;
import edu.usach.monitoreoPython.model.Coordinacion;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//importaciones para rest
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.http.MediaType;
import java.nio.charset.Charset;

/**
 *
 * @author Diego
 */


public class test_unitarios {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private MockMvc mockMvc;
    //private List<Bookmark> bookmarkList = new ArrayList<>();
    
    public test_unitarios() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /*
    @Test
    public void tes(){
    int n1=1;
    int n2=2;
    int total=3;
    //int sumas=AlumnoController.suma(n1,n2);
    //Assert.assertEquals(sumas,total);
    }*/
    @Test
    public void test_coordinacion_lista(){
        CoordinacionController cc= new CoordinacionController();
        ResponseEntity<List<Coordinacion>> lista_prueba=cc.list();
        Assert.assertNotEquals(HttpStatus.NO_CONTENT,lista_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.NOT_FOUND,lista_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNAUTHORIZED,lista_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE,lista_prueba.getStatusCode());
    }
    @Test
    public void test_coordinacion_put(){
        CoordinacionController cc= new CoordinacionController();
        Coordinacion coordinacion_prueba= new Coordinacion();
        ResponseEntity<?> put_prueba=cc.put("3",coordinacion_prueba);
        Assert.assertNotEquals(HttpStatus.NOT_MODIFIED,put_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.NOT_FOUND,put_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNAUTHORIZED,put_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE,put_prueba.getStatusCode());
    }
    @Test
    public void test_coordinacion_post(){
        CoordinacionController cc= new CoordinacionController();
        Coordinacion coordinacion_prueba= new Coordinacion();
        coordinacion_prueba.setIdCoordinacion(Long.MIN_VALUE);
        ResponseEntity<?> post_prueba=cc.post(coordinacion_prueba);
        Assert.assertNotEquals(HttpStatus.NOT_MODIFIED,post_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.NOT_FOUND,post_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNAUTHORIZED,post_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE,post_prueba.getStatusCode());
    }
    @Test
    public void test_coordinacion_get(){
        CoordinacionController cc= new CoordinacionController();
        ResponseEntity<Coordinacion> get_prueba=cc.get("1");
        Assert.assertNotEquals(HttpStatus.NOT_FOUND,get_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNAUTHORIZED,get_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE,get_prueba.getStatusCode());
    }
    
    @Test
    public void ccc() throws Exception {
        mockMvc.perform(get("/mingeso/coordinacion")
            .header("host", "localhost:8081"))
            .andExpect(status().isOk());
    }
    //http://localhost:8081/mingeso/coordinacion/1
    /*
    @Test
    public void geet()throws Exception {
        CoordinacionController cc= new CoordinacionController();
        ResponseEntity<Coordinacion> get_prueba=cc.get("1");
        mockMvc.perform(get("/1/mingeso/coordinacion"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
                //.andExpect(jsonPath("$.id", 1))
                //.andExpect(jsonPath("$.uri", is("http://bookmark.com/1/" + userName)))
                //.andExpect(jsonPath("$.description", is("A description"))));
    }
    /*
    @Test
    public void test_coordinacion_delete(){
        CoordinacionController cc= new CoordinacionController();
        ResponseEntity<Coordinacion> delete_prueba=cc.get("1");
        Assert.assertNotEquals(HttpStatus.NOT_FOUND,delete_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNAUTHORIZED,delete_prueba.getStatusCode());
        Assert.assertNotEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE,delete_prueba.getStatusCode());
    }
    */
}
