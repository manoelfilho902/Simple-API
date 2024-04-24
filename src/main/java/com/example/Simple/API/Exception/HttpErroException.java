/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Simple.API.Exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author Manoel Batista <manoelbatista902@gmail.com>
 */
public class HttpErroException extends RuntimeException {

    private final HttpStatus status;

    public HttpErroException(String string, HttpStatus status) {
        super(string);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
