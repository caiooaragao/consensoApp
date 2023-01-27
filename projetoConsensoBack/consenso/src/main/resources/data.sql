/*
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.defer-datasource-initialization=true
#spring.sql.init.mode=always
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/restapi_db
spring.datasource.username=root
spring.datasource.password=root1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.show-sql: true


INSERT INTO `tipo_usuario` (`nome`)
VALUES

("cliente"),
("prestador");

INSERT INTO `Servico` (`nome`,`descricao`)
VALUES
("Drenagem urbana","teste1"),
("Fatura","teste2"),
("Revisao de leitura","teste3"),
("Coleta de residuos solidos","teste4"); 

INSERT INTO `Usuario` (`nome`,`sobrenome`,`email`,`senha`,`tipo_usuario_id_tipo_usuario`)
VALUES
("Nell","Petty","eget.laoreet@aol.org","RDE71XKG3LJ",2),
("Hyatt","Sanford","enim.gravida@google.com","NJP62LCM4VH",1),
("Tashya","Petersen","morbi@protonmail.com","SMH43HPE6YV",1),
("Keely","Glenn","vel.lectus@google.net","EBV59MDQ8JC",2),
("Rooney","Donovan","dis@protonmail.org","SPS17EUL6BP",1);
("Ray","Kirby","dolor@icloud.couk","TGL19IHF5HU",1),
("Hashim","Good","penatibus.et@yahoo.couk","AOR27RRY5BJ",1),
("George","Bradley","magna.et.ipsum@icloud.ca","ICI04CUU4HJ",1),
("Caldwell","Snow","eu.odio.phasellus@google.edu","CQX96YVN6WD",2),
("Elizabeth","Kane","fusce@outlook.net","UAC86MLS6WE",2);

*/