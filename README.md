# Descrição
Projeto desenvolvido em trabalho da faculdade.

# Guia
- Iniciar o banco de dados MySQL 8 localmente ou em um container Docker.
- Iniciar a aplicação: ao realizar o deploy (ServletContextListener), o banco de dados é criado conforme as propriedades de conexão fornecidas no arquivo "database.properties",
se a conexão for estabelecida com sucesso, o sistema irá interpretar o script "sql/script-create.sql" e em seguida irá executar os comandos de criação da tabela de produtos e
também irá inserir alguns produtos por padrão.

# Dependências
Tecnologias: Java, Servlets, JSP, JSTL, HTML, Bootstrap, Javascript
Banco de Dados: MySQL 8.0
Servidor: Apache Tomcat 9.0 (https://tomcat.apache.org/download-90.cgi)
Gerenciador de Dependências: Maven

# Demo
![Lista de Produtos](https://i.imgur.com/1gaezuT.png)
![Cadastro de Produtos](https://i.imgur.com/sZISvXX.png)
