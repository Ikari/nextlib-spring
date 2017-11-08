/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library;

import org.springframework.beans.factory.annotation.Autowired;
import com.next.library.controller.ProdutoController;
import com.next.library.model.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author roger.roliveira
 */
//@RunWith(SpringRunner.class)
//@WebMvcTest(ProdutoController.class)
//public class ProdutoControllerTest {
//    
//    @Autowired
//    private MockMvc mock;
//    
//    public ProdutoControllerTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void validarCadastroProduto() {
//        Produto produto = new Produto();
//        produto.setNome("ProdutoTeste");
//        produto.setPreco(10.00);
//        produto.setEan("000111");
//        
////        mock.perform(
////                post("/produtos/cadastrar")
////                .contentType(MediaType.APPLICATION_JSON)
////                .andExpect(status().isOk()));
//    }
//}
