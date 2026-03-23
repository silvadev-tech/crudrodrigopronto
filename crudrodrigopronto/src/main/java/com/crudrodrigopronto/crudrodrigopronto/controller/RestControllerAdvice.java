package com.crudrodrigopronto.crudrodrigopronto.controller;

import com.crudrodrigopronto.crudrodrigopronto.exception.ProdutoNaoEcontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice  {



    @ExceptionHandler(ProdutoNaoEcontradoException.class)
    public ResponseEntity<String> tratarProdutoNaoEncontrado(ProdutoNaoEcontradoException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }



}
