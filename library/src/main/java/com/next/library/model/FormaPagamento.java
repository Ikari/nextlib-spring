/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.model;

import org.bson.types.ObjectId;

/**
 *
 * @author roger
 */
public interface FormaPagamento {    
    
    public ObjectId getId();
    public boolean validarPagamento();
}
