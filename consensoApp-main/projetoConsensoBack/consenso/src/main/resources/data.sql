/*
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/restapi_db
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.jpa.show-sql: true

INSERT INTO `tipo_usuario`(`nome`)
VALUES 
("cliente"),
("prestador");

INSERT INTO `Usuario` (`nome`,`sobrenome`,`email`,`senha`)
VALUES
("Tana","Summers","vehicula@aol.couk","CTW58COG9BJ"),
("Oprah","Luna","ut.pellentesque@aol.net","BEJ48PUA7RX"),
("Finn","Vaughan","aliquam.arcu@hotmail.net","ZDI38RHL0QF"),
("Peter","Stone","nec.leo@protonmail.edu","RVT22IJR6FJ"),
("Nigel","Baird","vitae@icloud.couk","CRL11IWU7WD");
*/