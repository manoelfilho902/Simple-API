/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Simple.API.controller;

import com.example.Simple.API.controller.common.BaseController;
import com.example.Simple.API.model.entity.Pessoa;
import com.example.Simple.API.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@RestController
@RequestMapping("/pessoa")
@CrossOrigin
public class PessoaController extends BaseController<Pessoa, Long> {

    @Autowired
    private PessoaService service;

    public PessoaController(PessoaService service) {
        super(service);
        this.service = service;
    }

}
