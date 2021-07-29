CREATE TABLE `tb_usuario` (
	`id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
	`nome` varchar(50) NOT NULL,
	`idade` int(10) NOT NULL,
	`genero` varchar(10) NOT NULL,
	`email` varchar(255),
	`telefone` varchar(255),
	`senha` varchar(20) NOT NULL,
	`id_tipo_usuario_fk` int(255) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

CREATE TABLE `tb_postagem` (
	`id_postagem` bigint NOT NULL AUTO_INCREMENT,
	`data_postagem` DATETIME NOT NULL,
	`corpo_postagem` varchar(3000),
	`url_foto` varchar(3000),
	`url_link_externo` varchar(3000),
	`url_video` varchar(3000),
	`id_usuario_fk` bigint(20) NOT NULL,
	PRIMARY KEY (`id_postagem`)
);

CREATE TABLE `tb_categoria` (
	`id_categoria` int NOT NULL AUTO_INCREMENT,
	`area` varchar(100),
	`cargo` varchar(100),
	`setor` varchar(100),
	`periodo` varchar(100),
	PRIMARY KEY (`id_categoria`)
);

ALTER TABLE `tb_usuario` ADD CONSTRAINT `tb_usuario_fk0` FOREIGN KEY (`id_tipo_usuario_fk`) REFERENCES `tb_categoria`(`id_categoria`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT `tb_postagem_fk0` FOREIGN KEY (`id_usuario_fk`) REFERENCES `tb_usuario`(`id_usuario`);




