/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Simple.API.controller;

import com.example.Simple.API.controller.common.BaseController;
import com.example.Simple.API.model.entity.Endereco;
import com.example.Simple.API.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@RestController
@RequestMapping("/endereco")
@CrossOrigin
public class EnderecoController extends BaseController<Endereco, Long> {

    @Autowired
    private EnderecoService service;

    public EnderecoController(EnderecoService service) {
        super(service);
        this.service = service;
    }

}
