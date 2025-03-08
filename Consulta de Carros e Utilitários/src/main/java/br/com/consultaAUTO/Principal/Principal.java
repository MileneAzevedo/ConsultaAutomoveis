package br.com.consultaAUTO.Principal;
import br.com.consultaAUTO.model.Dados;
import br.com.consultaAUTO.model.Modelos;
import br.com.consultaAUTO.model.Veiculo;
import br.com.consultaAUTO.service.ConsumoAPI;
import br.com.consultaAUTO.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    String endereco;
    private ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
        System.out.println("**** OPÇÕES ****\n" +
                "\n" +
                "Carro\n" +
                "\n" +
                "Moto\n" +
                "\n" +
                "Caminhão");

        System.out.println("Digite uma das opções para consultar valores: ");
        String opcao = leitura.nextLine().toLowerCase().trim();

        if (opcao.toLowerCase().contains("carr")) {
            endereco = (URL_BASE + "carros/marcas");
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

        var marcas = conversor.obterLista(json, Dados.class);

        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        var codigo = leitura.nextLine();

        endereco = endereco + "/" + codigo + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);

        System.out.println("Modelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Digite um trecho do nome do carro a ser buscado: ");
        var nomeTrecho = leitura.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeTrecho.toLowerCase()))
                        .collect(Collectors.toList());

        System.out.println("\nModelos filtrados: ");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("\nDigite o código do modelo para buscar os valores de avaliação: ");
        var codigoModelo = leitura.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);
        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
            
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);



        







    }
}