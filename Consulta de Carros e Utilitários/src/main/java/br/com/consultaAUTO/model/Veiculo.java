package br.com.consultaAUTO.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(@JsonAlias("Valor") String valor,
                      @JsonAlias("Marca") String marca,
                      @JsonAlias("Modelo") String modelo,
                      @JsonAlias("AnoModelo") Integer ano,
                      @JsonAlias("Conbustível") String tipoCombustivel){

    @Override
    public String toString() {
        return String.format("%s %s  ano: %s valor: %s combustível: %s",
                marca, modelo, ano, valor, tipoCombustivel);
    }

}


