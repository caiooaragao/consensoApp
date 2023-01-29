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


/*
INSERT INTO `tipo_usuario` (`nome`)
VALUES

("cliente"),
("prestador");

INSERT INTO `Usuario` (`nome`,`sobrenome`,`email`,`senha`,`tipo_usuario_id_tipo_usuario`)
VALUES
("Nell","Petty","eget.laoreet@aol.org","RDE71XKG3LJ",2),
("Hyatt","Sanford","enim.gravida@google.com","NJP62LCM4VH",1),
("Tashya","Petersen","morbi@protonmail.com","SMH43HPE6YV",1),
("Keely","Glenn","vel.lectus@google.net","EBV59MDQ8JC",2),
("Rooney","Donovan","dis@protonmail.org","SPS17EUL6BP",1),
("Ray","Kirby","dolor@icloud.couk","TGL19IHF5HU",1),
("Hashim","Good","penatibus.et@yahoo.couk","AOR27RRY5BJ",1),
("George","Bradley","magna.et.ipsum@icloud.ca","ICI04CUU4HJ",1),
("Caldwell","Snow","eu.odio.phasellus@google.edu","CQX96YVN6WD",2),
("Jessamine","Freeman","tristique.ac@outlook.ca","XLR55CQI7XV",1),
("Jerome","Gibbs","et@hotmail.com","WOJ55IQN3TH",1),
("Helen","Craft","mauris@protonmail.org","VPX76WOM7XQ",2),
("Victoria","Woodard","elit@yahoo.net","CJP93NYS6JY",1),
("Frances","Barton","adipiscing.fringilla.porttitor@google.couk","DDN98OPE3IW",2),
("Elizabeth","Kane","fusce@outlook.net","UAC86MLS6WE",2),
("Abraham","Hurst","metus@protonmail.com","HHC34HHJ1HK",1),
("Gwendolyn","Kerr","fringilla.mi.lacinia@yahoo.org","CUW71QDO8FH",2),
("Regan","Marsh","parturient@yahoo.couk","TVG65DVU2BS",1),
("Arthur","Molina","lacus.etiam.bibendum@google.edu","ARQ48PYF2AM",1),
("Lilah","Cox","ac.sem@outlook.org","BSB42HVH1OC",2);


INSERT INTO `Servico` (`nome`,`descricao`,`usuario_prestador_id_usuario`)
VALUES
("Drenagem","Lorem ipsum dolor sit amet, consectetur.",1),
("Fatura","Lorem ipsum dolor sit amet, consectetur.",2),
("Leitura","Lorem ipsum dolor sit amet, consectetur.",3),
("Revisao da Leitura","Lorem ipsum dolor sit amet, consectetur.",4),
("Limpeza","Lorem ipsum dolor sit amet, consectetur.",5),
("Coleta","Lorem ipsum dolor sit amet, consectetur.",6);


INSERT INTO `agendamento` (`data`,`hora`,`servico_id_servico`,`usuario_id_usuario`)
VALUES


("23-03-23","20:38",3,14),
("14-09-23","9:04",4,4),
("31-05-22","1:52",3,8),
("30-03-22","4:41",6,16),
("17-04-23","21:08",5,15),
("02-09-22","15:21",4,17),
("14-03-22","14:04",2,18),
("01-03-23","14:59",3,7),
("20-02-23","2:38",3,10),
("16-03-23","4:20",4,9),
("19-01-24","19:48",2,6),
("09-04-23","16:51",3,4),
("04-08-22","2:40",5,14),
("27-06-23","2:47",6,8),
("04-02-23","15:33",5,3),
("16-06-23","10:24",5,11),
("14-06-22","22:03",5,9),
("18-08-22","10:08",4,17),
("22-05-22","23:38",5,12),
("10-04-23","17:05",5,2),
("13-08-23","22:48",3,16),
("22-08-22","12:27",1,5),
("21-03-22","11:10",3,16),
("05-07-23","7:41",1,13),
("27-12-22","21:33",3,8),
("14-10-23","6:03",2,15),
("28-07-23","23:48",5,13),
("07-09-22","1:16",5,2),
("16-01-24","16:35",1,13),
("14-04-23","3:33",2,9),
("31-10-23","9:10",4,13),
("13-09-23","6:53",5,9),
("05-12-23","16:25",2,18),
("21-11-23","16:20",3,4),
("02-01-24","0:58",5,12),
("17-12-23","3:32",3,8),
("03-04-23","10:00",4,13),
("21-05-22","16:15",4,19),
("02-04-22","15:45",2,17),
("27-01-24","21:21",3,18),
("30-05-23","11:53",4,20),
("19-01-24","1:03",6,3),
("27-03-23","5:06",2,8),
("16-12-23","2:28",3,14),
("17-04-22","6:13",2,12),
("18-02-22","10:06",5,6),
("01-03-23","22:21",4,7),
("02-02-23","19:45",4,13),
("04-01-23","11:58",5,7),
("11-05-22","15:23",2,13),
("04-07-23","9:51",4,15),
("01-08-23","11:30",3,8),
("17-09-23","23:34",3,13),
("24-04-22","16:21",4,8),
("06-09-23","6:11",5,3);  */