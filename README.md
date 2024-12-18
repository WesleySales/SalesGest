# SalesGest: Sistema de Gestão Comercial

## Descrição do Projeto

**SalesGest** é um sistema de gestão comercial desenvolvido em Java, projetado para atender as necessidades de gerenciamento de vendas, produtos, pagamentos e funcionários. O sistema suporta múltiplos tipos de usuários, como vendedores e gerentes, com permissões específicas e funcionalidades adaptadas a cada perfil.

## Funcionalidades Principais

### Controle de Acessos:
- **Vendedor**: Gerencia vendas, atualiza pedidos e registra pagamentos.
- **Gerente**: Acesso total, incluindo cadastro e gerenciamento de funcionários, visualização de relatórios e controle de produtos.

### Gestão de Vendas:
- Registro e acompanhamento de vendas, com múltiplos status (Aberta, Finalizada, Cancelada).

### Gerenciamento de Pagamentos:
- Suporte a métodos como Cartão, PIX e Boleto, com status configuráveis (Pendente, Concluído).

### Gestão de Produtos:
- Cadastro, edição e controle de estoque de itens.

### Gerenciamento de Funcionários:
- Cadastro e monitoramento de vendas por funcionário.

## Tecnologias Utilizadas
- **Java**: Linguagem principal para o desenvolvimento.
- **JDBC**: Para conexão e manipulação dos dados no banco de dados relacional.
- **MySQL**: Banco de dados utilizado para armazenamento persistente das informações.
- **Java Swing**: Construção de uma interface gráfica intuitiva e interativa.

## Conceitos Aplicados
- **Arquitetura MVC**: Organização do sistema em camadas separadas para facilitar manutenção e escalabilidade.
- **Enums**: Definição de constantes para padronização de status de vendas e métodos de pagamento.
- **Programação Orientada a Objetos (POO)**: Modularização, encapsulamento e reutilização de código por meio de herança e polimorfismo.

## Objetivo do Sistema

SalesGest oferece uma solução prática e eficiente para o gerenciamento completo de lojas, centralizando as operações em uma interface unificada e promovendo maior controle e segurança por meio de permissões específicas para cada tipo de usuário.

## Como Executar

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/seuusuario/SalesGest.git
    ```

2. **Importe o projeto para sua IDE**.

3. **Configure o banco de dados**:
   - Importe o script inicial no seu banco MySQL.
   - Altere as configurações de conexão no arquivo de configuração para o banco de dados.

4. **Execute o projeto**:
   - Se estiver usando uma IDE, basta rodar a aplicação como um projeto Java normal.

## Contribuindo

Se você deseja contribuir para o projeto, siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma nova branch para sua feature (`git checkout -b feature-nome-da-feature`).
3. Faça suas alterações.
4. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
5. Envie para o repositório remoto (`git push origin feature-nome-da-feature`).
6. Abra um Pull Request.

## Licença

Distribuído sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
