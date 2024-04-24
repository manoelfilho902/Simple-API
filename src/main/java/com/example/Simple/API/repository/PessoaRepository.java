/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.Simple.API.repository;

import com.example.Simple.API.model.entity.Pessoa;
import com.example.Simple.API.repository.common.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
@Repository
public interface PessoaRepository extends BaseRepository<Pessoa, Long> {

}
