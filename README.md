# ConsultaAuto

O **ConsultaAuto** é um projeto em Java que realiza consultas de veículos, como carros, motos e caminhões, utilizando uma API externa da Fipe. Através de um menu interativo no terminal, o usuário pode consultar marcas, modelos e valores de avaliação de veículos.

## Funcionalidades

- **Consulta de Marcas**: O usuário pode selecionar entre **carros**, **motos** ou **caminhões** para consultar as marcas disponíveis.
- **Consulta de Modelos**: Após selecionar uma marca, o usuário pode escolher entre os modelos disponíveis dessa marca.
- **Filtragem de Modelos**: O sistema permite filtrar os modelos por nome.
- **Consulta de Avaliação de Veículos**: O usuário pode consultar a avaliação de veículos com base no modelo e no ano.

## Como funciona

1. O sistema oferece um menu com três opções: **Carro**, **Moto** e **Caminhão**.
2. Após a escolha, o sistema consulta a API da Fipe para listar as marcas disponíveis do tipo escolhido.
3. O usuário informa o código da marca para buscar os **modelos** dessa marca.
4. O sistema filtra os modelos conforme o nome e exibe as opções disponíveis.
5. O usuário escolhe um modelo e, em seguida, consulta os valores de avaliação do veículo, que são apresentados por ano.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **API Fipe**: API externa usada para consultar informações sobre veículos.
- **Streams**: Utilizados para manipulação de dados e filtragem de modelos de forma eficiente.

