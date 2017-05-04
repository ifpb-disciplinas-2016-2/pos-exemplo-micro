# PayaraMicro

Este projeto exemplifica o uso da especificação JPA, EJB e Servlet em um ambiente JavaEE. Realizando o deploy com o Docker e PayaraMicro com a persistência no SGBD PostgreSQL.

Há duas possibilidades de configuração: usando a anotação `DataSourceDefinition` e o arquivo `web.xml`.

Observem que no `persistence.xml` a configuração do `<jta-data-source>` se mantém, independente da opção selecionada.

Para realizar o `deploy` da aplicação executar o arquivo `startup.sh`. Depois acessar `<host>:8081/exemplo-micro/cadastro`, sendo possível passar como parametro `<host>:8081/exemplo-micro/cadastro?nome=<nome>`.
