package com.rigon.calculonotas.domain.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rigon.calculonotas.domain.dto.ResultadoDTO;
import com.rigon.calculonotas.domain.entity.Aluno;
import com.rigon.calculonotas.domain.service.CalculoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/aluno")
public class CalculoController {
    
    CalculoService calculoService;

    @PostMapping("/calcular-nota")
    public ResultadoDTO calcularNota(@RequestBody Aluno aluno) {
        return calculoService.isAprovado(aluno);
    }
}
