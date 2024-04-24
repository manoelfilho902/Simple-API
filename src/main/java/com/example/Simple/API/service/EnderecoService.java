/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Simple.API.service;

import com.example.Simple.API.model.entity.Endereco;
import com.example.Simple.API.repository.EnderecoRepository;
import com.example.Simple.API.service.common.BaseService;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@Service
public class EnderecoService extends BaseService<Endereco, Long> {

    private EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public <R> R findBy(Example<Endereco> example, Function<FluentQuery.FetchableFluentQuery<Endereco>, R> queryFunction) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
