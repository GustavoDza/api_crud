#Iremos rodar dois comandos antes de inicializar a aplicação,
#para que quando ela suba configure o banco certinho 
#(OBS: Não esqueça de mudar a senha no aplication.properties)
#Primeiro comando
CREATE DATABASE api_crud;

#Segundo comando
use api_crud;

#Após rodar os comandos acima, pode inicializar a aplicação e posteriormente rodar o restante do Script.

#Terceiro comando, rodar o bloco de códigos Insert na base Supplier juntos.
INSERT INTO SUPPLIER(name, date_creation, date_last_update) VALUES('Fornecedor de comidas', '1999-11-10 15:00:00', '2022-05-02 17:30:00');
INSERT INTO SUPPLIER(name, date_creation, date_last_update) VALUES('Fornecedor de acessorios', '2005-02-23 10:00:00', '2022-05-05 13:00:00');
INSERT INTO SUPPLIER(name, date_creation, date_last_update) VALUES('Fornecedor de utensilios', '2019-06-02 10:00:00', '2022-04-30 09:00:00');


#Quarto comando, rodar o bloco de códigos Insert na base Product juntos.
INSERT INTO PRODUCT(name, quantity_stock, unit_price, supplier_id_id, date_creation, date_last_update) VALUES('Pacotes de batata frita', 10, 18.99, 1, '2022-05-07 15:00:00', '2022-05-09 08:30:00');
INSERT INTO PRODUCT(name, quantity_stock, unit_price, supplier_id_id, date_creation, date_last_update) VALUES('Avental', 10, 150.00, 2, '2021-10-15 10:00:00', '2022-05-05 13:00:00');
INSERT INTO PRODUCT(name, quantity_stock, unit_price, supplier_id_id, date_creation, date_last_update) VALUES('Colher', 100, 2.00, 3, '2021-05-02 10:00:00', '2022-05-01 16:00:00');

#Fim do Script