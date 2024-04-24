/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Simple.API.service;

import com.example.Simple.API.model.entity.Pessoa;
import com.example.Simple.API.repository.PessoaRepository;
import com.example.Simple.API.service.common.BaseService;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@Service
public class PessoaService extends BaseService<Pessoa, Long> {

    @Autowired
    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public <R> R findBy(Example<Pessoa> example, Function<FluentQuery.FetchableFluentQuery<Pessoa>, R> queryFunction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
