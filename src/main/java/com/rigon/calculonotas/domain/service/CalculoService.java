package com.rigon.calculonotas.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rigon.calculonotas.domain.dto.ResultadoDTO;
import com.rigon.calculonotas.domain.entity.Aluno;

@Service
public class CalculoService {

    private static final double MEDIA_APROVACAO = 7.0;

    public Double calcularMedia(Aluno aluno) {
        List<Double> notas = aluno.getNotas();

        double soma = 0;
        for(Double nota : notas) {
            soma += nota;
        }

        double media = soma / notas.size();

        return media;
    }

    public ResultadoDTO isAprovado(Aluno aluno) {
        ResultadoDTO resultado = new ResultadoDTO();

        double media = calcularMedia(aluno);
        resultado.setMedia(media);

        if(media >= MEDIA_APROVACAO) {
            resultado.setStatus("Aprovado");
        } else {
            resultado.setStatus("Reprovado");
        }

        return resultado;
    }
    
    
}
