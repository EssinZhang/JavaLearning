`t_student`CREATE TABLE `learnmybatis`.`t_student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NULL,
  `age` INT NULL,
  `score` DOUBLE NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE t_team(
	id INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(45) NULL,
	PRIMARY KEY(id)
  );
  
  CREATE TABLE t_player(
	id INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR(45) NULL,
	tid INT NULL,
	PRIMARY KEY(id)
  );
  INSERT INTO t_team(NAME) VALUES ('洛杉矶湖人'),('费城76人'),('圣安东尼奥马刺');
  INSERT INTO t_player(NAME,tid) VALUES ('Bryant','1'),('Duncan','3'),('Iverson','2');