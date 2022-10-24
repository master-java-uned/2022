CREATE TABLE `categorias` (
  `idcategorias` int NOT NULL,
  `categoriasNombre` varchar(45) DEFAULT NULL,
  PRIMACREATE TABLE `tablero` (
  `idtablero` int NOT NULL,
  `idCategoria` int DEFAULT NULL,
  PRIMARY KEY (`idtablero`),
  UNIQUE KEY `idtablero_UNIQUE` (`idtablero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
tableroRY KEY (`idcategorias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `preguntas` (
  `idpregunta` int NOT NULL,
  `idCategoria` int DEFAULT NULL,
  `pregunta` varchar(45) DEFAULT NULL,
  `opcion1` varchar(45) DEFAULT NULL,
  `opcion2` varchar(45) DEFAULT NULL,
  `opcion3` varchar(45) DEFAULT NULL,
  `opcion4` varchar(45) DEFAULT NULL,
  `correcta` int DEFAULT NULL,
  PRIMARY KEY (`idpregunta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tablero` (
  `idtablero` int NOT NULL,
  `idCategoria` int DEFAULT NULL,
  PRIMARY KEY (`idtablero`),
  UNIQUE KEY `idtablero_UNIQUE` (`idtablero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
