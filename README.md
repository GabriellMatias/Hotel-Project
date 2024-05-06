# 🏨 Projeto de Simulação de Reserva e Controle de Quartos em um Hotel 🛏️
## Descrição do Projeto
Este é um projeto em Java 17 que simula um sistema de reserva e controle de quartos em um hotel, utilizando threads para representar diferentes entidades envolvidas, como quartos, hóspedes, camareiras e recepcionistas.

## Funcionalidades Implementadas 🛠️
 - Representação de quartos, hóspedes, camareiras e recepcionistas como threads.
 - Funcionamento de alocação de hóspedes em quartos vagos.
 - Capacidade de até 4 hóspedes por quarto.
 - Tratamento de casos em que grupos/famílias possuem mais de 4 membros, dividindo-os em vários quartos.
 - Sistema para deixar a chave na recepção ao sair para passear.
 - Entrada de camareiras para limpeza de quartos após a saída dos hóspedes.
 - Quartos vazios que passam por limpeza não podem ser alocados para novos hóspedes.
 - Fila de espera para casos em que não há quartos vagos.
 - Funcionalidade para os hóspedes passearem pela cidade caso não haja quartos disponíveis.
 - Registro de reclamação caso um hóspede não consiga alugar um quarto após duas tentativas.
## Regras e Observações 📝
Não é possível para um mesmo quarto ter parte dos hóspedes saindo para passear, ou todos saem ou nenhum sai.
A implementação deve ser abrangente e simular diferentes situações, como número variável de hóspedes chegando, grupos com mais de 4 pessoas e todos os quartos lotados.
É necessário garantir sincronia e coordenação entre as entidades envolvidas.
## Como Executar o Projeto 🚀
Certifique-se de ter o Java 17 instalado em sua máquina.
Clone este repositório em sua máquina local.
Navegue até o diretório do projeto.
Compile os arquivos Java: javac *.java.
Execute o programa: java HotelSimulation.
## Autores ✍️
 - [GabriellMatias]
 - [Joao Pedro de Alcantra]
 - [Victor]
 - [Linek Reis]
## Licença ⚖️
Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE.md] para detalhes.
