# api_crud
API crud de Produtos e Fornecedores

Como instalar e usar a API REST CRUD de produtos e fornecedores.

Primeiramente será necessario fazer a instalação dos seguintes softwares: Eclipse, Postman, MySql.

Após ter todos os softwares instalados você irá fazer o clone do projeto para a sua maquina, ao clonar o projeto você deve abrir o eclipse e selecionar sua workspace. Quando o Eclipse abrir você irá selecionar a opção "File" e "Import", clique em "Maven" e posteriormente "Existing Maven Projects", clique em Browse e navegue até a pasta clonada, selecione ela e verique se a opção do POM.XML está marcada (Caso não esteja marcada, marque), clique em "Finish" e o projeto será importado.

Quando o projeto terminar de importar, vá até o AplicationProperties, que está dentro de src/main/resources e altere o Username e a senha para o que você cadastrou no MySQL, após realizar esse passo abrá o MYSQL Workbench e se conecte no banco de dados, após conectar-se abra o Script chamado Script_crud que está dentro da pasta CRUD que foi clonada.

Abrindo o Script ele terá comentado o passo a passo que deve ser realizado, primeiramente rode o primeiro comando(CREATE DATABASE api_crud;) assim a base será criada no database, posteriormente rode o segundo comando(use api_crud;) pois ele irá selecionar a base api_crud para que os comanado do Java se consiga se conectar com o banco,ao rodar estes dois comandos você pode voltar ao Eclipse e inicializar a aplicação no CrudApplication.

****OBS: Caso de algum erro da porta do Tomcat, você irá precisar mudar a porta da aplicação (com o comando server.port = 8090 no applicationProperties) ou encerrar a aplicação que está na porta LocalHost:8080****

Quando a aplicação iniciar rode os comandos no Script para inserir na tabela SUPPLIES e posteriormente rode a inserção na tabela PRODUCT também.

Prontinho a aplicação já está rodando com o Banco de dados alimentado.

Agora é hora de abrir o Postman e importar a coleção que está dentro da pasta PostmanEvidencias, que se localiza dentro da pasta CRUD que foi clonada no inicio do processo. Após importar você verá que as requisões já estão montadas, para testar você preciar apenas envia-las (clicando em send), sinta-se a vontade para criar novas requisões e testes. 

Plus: Dentro da pasta PostmanEvidencias tem um word onde eu evidenciei todos os casos de testes do postman, caso queira fique a vontade para olhar ele também.
