package es.uned.master.java.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uned.master.java.interfaces.Ijuego;
import es.uned.master.java.models.ECategoria;
import es.uned.master.java.models.Preguntas;
import es.uned.master.java.models.PreguntasOpciones;
import es.uned.master.java.models.Tablero;
import es.uned.master.java.repository.PreguntasOpcionesRepository;
import es.uned.master.java.repository.PreguntasRepository;
import es.uned.master.java.repository.TableroRepository;


@Service
public class Juego implements Ijuego{
	

	private int resultado;
	
	@Autowired
	PreguntasRepository preguntasRepository;
	
	@Autowired
	TableroRepository tableroRepository;
	
	@Autowired
	PreguntasOpcionesRepository preguntasOpcionesRepository;

	
	@Override
	public int identificarJugador(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int posicionesPropuestas1(int posicionActual,int dado) {
		//verificamos que  la casilla actual sea menor o igual a 6
		System.out.println("posicionActual opcion1: "+ posicionActual);
		int posicion1=0;
		if (posicionActual<=6) {
			posicion1=posicionActual+dado;
		}
		if (posicionActual==0 || posicionActual>6) {
			posicion1=posicionActual+dado;
		}
		if (posicion1>24){
			posicion1=posicion1-24;
		}
		System.out.println("opcion1: "+ posicion1);
		return posicion1;
	}
	@Override
	public int posicionesPropuestas2(int posicionActual,int dado) {
		System.out.println("posicionActual opcion2: "+ posicionActual);
		int posicion2=0;
		int validarCasilla=posicionActual-dado;
			if (validarCasilla<=0) {
				posicion2=24-(dado-posicionActual);
				
			}else {
			posicion2=validarCasilla;
		}
		
		System.out.println("opcion2: "+ posicion2);
		return posicion2;
	}
	
	
	public int lanzarDato() {
		//metodo que se llama para lanzar el dado
		resultado = (int) ((Math.random() * 6) + 1);
		return resultado;
	}

	@Override
	public int leerCasilla(int casillaAnterior, int casillaNueva) {
		if (casillaAnterior==0 && casillaNueva==0) {
			casillaAnterior=1;
			casillaNueva=0;
		}
		
		// TODO Auto-generated method stub
		return casillaAnterior;
	}
	
	@Override
	public Preguntas getPregunta(ECategoria categoria) {

		List<Preguntas> pregs = preguntasRepository.findAllByCategoria(categoria);
		
		int numPreg = (int) ((Math.random() * pregs.size()));
		
		int control = 0;
		
		while (pregs.get(numPreg).isUtilizada() && (control < pregs.size())) {
			numPreg = (int) ((Math.random() * pregs.size()));
			System.out.println("CONTROL: "+ control);
			control++;
		}
			
		if(control >= pregs.size()) return null;
		
		pregs.get(numPreg).setUtilizada(true);		
		preguntasRepository.save(pregs.get(numPreg));
		
		System.out.println("preg.getPregunta(): "+ pregs.get(numPreg).getPregunta());
		return pregs.get(numPreg);
	}
	
	@Override
	public boolean checkRespuesta(List<PreguntasOpciones> opciones, int respuesta) {
		
		System.out.println("respuesta: "+ opciones.get(respuesta-1).getOpcion());
		
		if(opciones.get(respuesta-1).getCorrecta() == 1) return true;
		
		return false;
	}
	@Override
	public void insertPreguntas() {
		
		if(preguntasRepository.count() == 0) {
			List<Preguntas> pregs = Arrays.asList(
				new Preguntas(1,0,"¿Cómo se llama el director de Hogwarts?"),
				new Preguntas(2,0,"¿A qué casa de Howarts perteneció Cedric Diggory?"),
				new Preguntas(3,0,"¿Cuál es el cuarto libro de la saga?"),
				new Preguntas(4,0,"¿Cuántos profesores de Defensa contra las Artes Oscuras ha tenido Harry?"),
				new Preguntas(5,0,"¿Quién entrega a Harry su carta de aceptación a Hogwarts?"),
				new Preguntas(6,0,"En la saga, ¿cómo se llaman los no-magos?"),
				new Preguntas(7,0,"¿Quién le regaló a Harry la Nimbus 2000?"),
				new Preguntas(8,0,"¿Quién derrota a Lord Voldemort?"),
				new Preguntas(9,0,"¿Cuál es el hechizo para ahuyentar a los dementores?"),
				new Preguntas(10,0,"La segunda prueba del torneo de los tres magos consistía en…"),

				new Preguntas(11,1,"Este chatarrero tiene una pequeña tienda en Tatooine. ¿Cómo se llama?"),
				new Preguntas(12,1,"¿Qué planeta es la capital de Theed?"),
				new Preguntas(13,1,"¿Qui-Gon Jinn fue el padawan de qué maestro Jedi?"),
				new Preguntas(14,1,"¿Quién era el Maestro Sith del Conde Dooku?"),
				new Preguntas(15,1,"¿Quién sirvió de plantilla genética de los soldados clonados?"),
				new Preguntas(16,1,"En Star Wars: El Despertar de la Fuerza, ¿qué planeta alberga la base de la Resistencia?"),
				new Preguntas(17,1,"¿Quién dice 'Necesito ayuda con este gigante peludo' en Star Wars: El Despertar de la Fuerza?"),
				new Preguntas(18,1,"¿Cuál era la denominación de Finn como stormtrooper?"),
				new Preguntas(19,1,"Cuando Finn era un stormtrooper, ¿cuál era su área de ocupación?"),
				new Preguntas(20,1,"¿Dónde encuentra Rey el sable de luz de Luke Skywalker?"),

				new Preguntas(21,2,"¿Quién encontró Narnia por primera vez?"),
				new Preguntas(22,2,"¿Cómo se llama el león?"),
				new Preguntas(23,2,"¿Qué dulces le ofreció la bruja blanca a Edmun cuando lo encontró por primera vez?"),
				new Preguntas(24,2,"¿Por dónde llegaron a Narnia?"),
				new Preguntas(25,2,"¿Cuántas partes tiene “Las crónicas de Narnia”?"),
				new Preguntas(26,2,"¿Cómo se llama el primer ser que se encontró Lucy al llegar a Narnia?"),
				new Preguntas(27,2,"¿Cómo se llama el príncipe de Narnia en la segunda parte de la saga?"),
				new Preguntas(28,2,"¿Quién escribió Las crónicas de Narnia?"),
				new Preguntas(29,2,"¿Por dónde entraron a Narnia en la tercera parte?"),
				new Preguntas(30,2,"¿A Susan qué arma le regaló Papa Noel en Narnia?"),

				new Preguntas(31,3,"¿Qué criatura tuvo el anillo después de Golum?"),
				new Preguntas(32,3,"¿Cómo se llama el mago, amigo del hobbit?"),
				new Preguntas(33,3,"¿Cómo se llama el portador del anillo?"),
				new Preguntas(34,3,"¿Cómo se llama el hobbit que le arrebató el anillo a Golum?"),
				new Preguntas(35,3,"¿Cómo se llama el dueño del anillo de poder?"),
				new Preguntas(36,3,"¿Cómo se llama la ciudad donde habitaba el malvado que quería recuperar el anillo de poder?"),
				new Preguntas(37,3,"¿Quién es el escritor del “señor de los anillos”?"),
				new Preguntas(38,3,"¿Cómo se llama la segunda parte de “El señor de los anillos”?"),
				new Preguntas(39,3,"¿Cómo se llama la tercera parte de “El señor de los anillos”?"),
				new Preguntas(40,3,"¿Cómo se llama la primera parte de “El señor de los anillos”?"),

				new Preguntas(41,4,"¿En qué año se estrenó la primera película de Iron Man, que lanzó el Marvel Cinematic Universe?"),
				new Preguntas(42,4,"¿Cómo se llama el martillo de Thor?"),
				new Preguntas(43,4,"En The Incredible Hulk, ¿qué le dice Tony a Thaddeus Ross al final de la película?"),
				new Preguntas(44,4,"¿De qué está hecho el escudo del Capitán América?"),
				new Preguntas(45,4,"Los Flerkens son una raza de alienígenas extremadamente peligrosos que se parece a qué."),
				new Preguntas(46,4,"Antes de convertirse en Visión, ¿cómo se llama el mayordomo de inteligencia artificial de Iron Man?"),
				new Preguntas(47,4,"¿Cuál es el verdadero nombre de la Pantera Negra?"),
				new Preguntas(48,4,"¿Cuál es la raza alienígena que Loki envía para invadir la Tierra en The Avengers?"),
				new Preguntas(49,4,"¿Quién fue el último titular de la Piedra espacial antes de que Thanos lo reclame por su Infinity Gauntlet?"),
				new Preguntas(50,4,"¿Qué nombre falso usa Natasha cuando conoce a Tony por primera vez?"),

				new Preguntas(51,5,"¿En qué año se estableció Disney?"),
				new Preguntas(52,5,"¿Cuántos resorts de Disney hay en el mundo?"),
				new Preguntas(53,5,"¿Dónde se encuentra Walt Disney Studios?"),
				new Preguntas(54,5,"¿Cuántas princesas de Disney hay?"),
				new Preguntas(55,5,"¿Cuál es la primera película de Disney que se estrena?"),
				new Preguntas(56,5,"¿Quién es el némesis de Mickey Mouse?"),
				new Preguntas(57,5,"En la película Aladdin, ¿cómo se llama el loro?"),
				new Preguntas(58,5,"En Atlantis: The Lost Empire, ¿cuál es el nombre de los personajes principales?"),
				new Preguntas(59,5,"¿Cuáles son los nombres de las hermanastras de Cenicienta?"),
				new Preguntas(60,5,"¿Para qué pensaba Ariel que era un tenedor?")
			);
			
			preguntasRepository.saveAll(pregs);
		}
		
	}
	@Override
	public void insertTablero() {
		
		if(tableroRepository.count() == 0) {
			List<Tablero> casillas = Arrays.asList(
					new Tablero(1,0,true),
					new Tablero(2,6,false),
					new Tablero(3,1,false),
					new Tablero(4,2,false),
					new Tablero(5,3,true),
					new Tablero(6,6,false),
					new Tablero(7,4,false),
					new Tablero(8,1,false),
					new Tablero(9,2,true),
					new Tablero(10,6,false),
					new Tablero(11,3,false),
					new Tablero(12,2,false),
					new Tablero(13,1,true),
					new Tablero(14,6,false),
					new Tablero(15,4,false),
					new Tablero(16,0,false),
					new Tablero(17,5,true),
					new Tablero(18,6,false),
					new Tablero(19,5,false),
					new Tablero(20,0,false),
					new Tablero(21,4,true),
					new Tablero(22,6,false),
					new Tablero(23,5,false),
					new Tablero(24,3,false)
			);
			
			tableroRepository.saveAll(casillas);
		}
		
	}
	@Override
	public void insertPreguntasOpciones() {
		if(preguntasOpcionesRepository.count() == 0) {
			List<PreguntasOpciones> opciones = Arrays.asList(
					new PreguntasOpciones(1,0,"Madame Maxime ",1),
					new PreguntasOpciones(2,1,"Severus Snape",1),
					new PreguntasOpciones(3,0,"Albus Dumbledore",1),
					new PreguntasOpciones(4,0,"Rubeus Hagrid",1),
					new PreguntasOpciones(5,0,"Gryffindor",2),
					new PreguntasOpciones(6,1,"Hufflepuff",2),
					new PreguntasOpciones(7,0,"Ravenclaw",2),
					new PreguntasOpciones(8,0,"Slytherin",2),
					new PreguntasOpciones(9,0,"H.P. y la piedra filosofal",3),
					new PreguntasOpciones(10,0,"H.P. y el misterio del príncipe",3),
					new PreguntasOpciones(11,1,"H.P. y el caliz de fuego",3),
					new PreguntasOpciones(12,0,"H.P. y el prisionero de azkaban",3),
					new PreguntasOpciones(13,0,"1",4),
					new PreguntasOpciones(14,0,"3",4),
					new PreguntasOpciones(15,1,"7",4),
					new PreguntasOpciones(16,0,"4",4),
					new PreguntasOpciones(17,0,"Su lechuza",5),
					new PreguntasOpciones(18,1,"Hagrid",5),
					new PreguntasOpciones(19,0,"Albus Dumbledore",5),
					new PreguntasOpciones(20,0,"Su padre",5),
					new PreguntasOpciones(21,0,"Kappa",6),
					new PreguntasOpciones(22,0,"Directioners",6),
					new PreguntasOpciones(23,1,"Muggles",6),
					new PreguntasOpciones(24,0,"Humanos",6),
					new PreguntasOpciones(25,0,"Albus Dumbledore",7),
					new PreguntasOpciones(26,1,"Minerva McGonagall",7),
					new PreguntasOpciones(27,0,"Rubeus Hagrid",7),
					new PreguntasOpciones(28,0,"Tom Riddle",7),
					new PreguntasOpciones(29,0,"Hermione Granger",8),
					new PreguntasOpciones(30,0,"Harry Potter",8),
					new PreguntasOpciones(31,0,"Draco Malfoy",8),
					new PreguntasOpciones(32,1,"Neville Lombottom",8),
					new PreguntasOpciones(33,0,"Desmaius",9),
					new PreguntasOpciones(34,0,"Occulus Reparo",9),
					new PreguntasOpciones(35,0,"Alohomora",9),
					new PreguntasOpciones(36,1,"Expecto Patronum",9),
					new PreguntasOpciones(37,1,"Recuperar algo valioso del lago de Hogwarts",10),
					new PreguntasOpciones(38,0,"Salir de un laberinto en el bosque perdido",10),
					new PreguntasOpciones(39,0,"Limpiar las mazmorras ",10),
					new PreguntasOpciones(40,0,"Escapar de Azkaban",10),

					new PreguntasOpciones(41,0,"Nute",11),
					new PreguntasOpciones(42,1,"Watto",11),
					new PreguntasOpciones(43,0,"Sebulba",11),
					new PreguntasOpciones(44,0,"Wald",11),
					new PreguntasOpciones(45,0,"Mandalore",12),
					new PreguntasOpciones(46,1,"Naboo",12),
					new PreguntasOpciones(47,0,"Takodana",12),
					new PreguntasOpciones(48,0,"Yavin 4",12),
					new PreguntasOpciones(49,1,"Conde Dooku",13),
					new PreguntasOpciones(50,0,"Yoda",13),
					new PreguntasOpciones(51,0,"Mace Windu",13),
					new PreguntasOpciones(52,0,"Palpatine",13),
					new PreguntasOpciones(53,0,"Darth Maul",14),
					new PreguntasOpciones(54,1,"Darth Sidious",14),
					new PreguntasOpciones(55,0,"Darth Vader",14),
					new PreguntasOpciones(56,0,"Darth Tyranus",14),
					new PreguntasOpciones(57,0,"Boba Fett",15),
					new PreguntasOpciones(58,0,"Hondo Ohnaka",15),
					new PreguntasOpciones(59,0,"Mace Windu",15),
					new PreguntasOpciones(60,1,"Jango Fett",15),
					new PreguntasOpciones(61,1,"D’Qar",16),
					new PreguntasOpciones(62,0,"Takodana",16),
					new PreguntasOpciones(63,0,"Jakku",16),
					new PreguntasOpciones(64,0,"Endor",16),
					new PreguntasOpciones(65,0,"Han Solo",17),
					new PreguntasOpciones(66,1,"Finn",17),
					new PreguntasOpciones(67,0,"Rey",17),
					new PreguntasOpciones(68,0,"Poe",17),
					new PreguntasOpciones(69,0,"FN-36",18),
					new PreguntasOpciones(70,0,"FN-2018",18),
					new PreguntasOpciones(71,0,"FN-3881",18),
					new PreguntasOpciones(72,1,"FN-2187",18),
					new PreguntasOpciones(73,0,"Gestión de armas",19),
					new PreguntasOpciones(74,1,"Saneamiento",19),
					new PreguntasOpciones(75,0,"Lavandería",19),
					new PreguntasOpciones(76,0,"Mecánica",19),
					new PreguntasOpciones(77,0,"Los patios de chatarra de Jakku",20),
					new PreguntasOpciones(78,0,"El Halcón Milenario",20),
					new PreguntasOpciones(79,0,"La Cantina",20),
					new PreguntasOpciones(80,1,"El castillo de Maz Kanata",20),

					new PreguntasOpciones(81,0,"SUSAN",21),
					new PreguntasOpciones(82,1,"LUCY",21),
					new PreguntasOpciones(83,0,"PETER ",21),
					new PreguntasOpciones(84,0,"EDMUN",21),
					new PreguntasOpciones(85,0,"ASTRAN",22),
					new PreguntasOpciones(86,0,"ASRAN",22),
					new PreguntasOpciones(87,1,"ASLAN ",22),
					new PreguntasOpciones(88,0,"ASKAN",22),
					new PreguntasOpciones(89,0,"CHOCOLATINAS",23),
					new PreguntasOpciones(90,0,"PASTELITOS DE ALMENDRA",23),
					new PreguntasOpciones(91,1,"DELICIAS TURCAS",23),
					new PreguntasOpciones(92,0,"GOFRES",23),
					new PreguntasOpciones(93,0,"POR LA PUERTA DEL SERVICIO",24),
					new PreguntasOpciones(94,0,"POR UNA CUEVA",24),
					new PreguntasOpciones(95,1,"POR UN ARMARIO",24),
					new PreguntasOpciones(96,0,"POR UNA BAÑERA",24),
					new PreguntasOpciones(97,0,"1",25),
					new PreguntasOpciones(98,1,"3",25),
					new PreguntasOpciones(99,0,"5",25),
					new PreguntasOpciones(100,0,"6",25),
					new PreguntasOpciones(101,1,"TUNNUS",26),
					new PreguntasOpciones(102,0,"LUCNUS",26),
					new PreguntasOpciones(103,0,"BULTUS",26),
					new PreguntasOpciones(104,0,"ZURNUS",26),
					new PreguntasOpciones(105,1,"CASPIAN",27),
					new PreguntasOpciones(106,0,"MACALIAN",27),
					new PreguntasOpciones(107,0,"CALIAN",27),
					new PreguntasOpciones(108,0,"FERNANDITO",27),
					new PreguntasOpciones(109,1,"C. LEWIS",28),
					new PreguntasOpciones(110,0,"ARTURO PEREZ REVERTE",28),
					new PreguntasOpciones(111,0,"JUAN  MANUEL DE PRADA",28),
					new PreguntasOpciones(112,0,"BENITO PEREZ GALDOS",28),
					new PreguntasOpciones(113,0,"POR UN SILLON",29),
					new PreguntasOpciones(114,0,"POR UNA MESA",29),
					new PreguntasOpciones(115,1,"POR UN CUADRO",29),
					new PreguntasOpciones(116,0,"POR EL FRIGORIFICO",29),
					new PreguntasOpciones(117,0,"ESPADA",30),
					new PreguntasOpciones(118,0,"PUÑAL",30),
					new PreguntasOpciones(119,0,"PISTOLA ",30),
					new PreguntasOpciones(120,1,"ARCO CON FLECHAS",30),

					new PreguntasOpciones(121,1,"UN HOBBIT",31),
					new PreguntasOpciones(122,0,"UN PERRO",31),
					new PreguntasOpciones(123,0,"UN ORCO",31),
					new PreguntasOpciones(124,0,"UN HADA",31),
					new PreguntasOpciones(125,1,"GANDALF",32),
					new PreguntasOpciones(126,0,"ESTRUJEN",32),
					new PreguntasOpciones(127,0,"SARUMAN",32),
					new PreguntasOpciones(128,0,"KINTERIUM",32),
					new PreguntasOpciones(129,1,"FRODO",33),
					new PreguntasOpciones(130,0,"SAM SAGAZ",33),
					new PreguntasOpciones(131,0,"ARAGON",33),
					new PreguntasOpciones(132,0,"EL REY ENANO",33),
					new PreguntasOpciones(133,1,"BILBO BOLSON",34),
					new PreguntasOpciones(134,0,"BARBO BOLSON",34),
					new PreguntasOpciones(135,0,"BERIO BOLSON",34),
					new PreguntasOpciones(136,0,"BASTION BOLSON",34),
					new PreguntasOpciones(137,0,"MAURON",35),
					new PreguntasOpciones(138,1,"SAURON",35),
					new PreguntasOpciones(139,0,"TRAURON",35),
					new PreguntasOpciones(140,0,"CRAURON",35),
					new PreguntasOpciones(141,0,"MARDOR",36),
					new PreguntasOpciones(142,0,"MUERDOR",36),
					new PreguntasOpciones(143,1,"MORDOR ",36),
					new PreguntasOpciones(144,0,"MENDOR",36),
					new PreguntasOpciones(145,0,"J.R. LEWIS",37),
					new PreguntasOpciones(146,1,"J.R.R. TOLKIEN",37),
					new PreguntasOpciones(147,0,"J.R.R. PEET",37),
					new PreguntasOpciones(148,0,"J.R.R. POE",37),
					new PreguntasOpciones(149,0,"LAS TRES TORRES",38),
					new PreguntasOpciones(150,0,"LAS CUATRO TORRES",38),
					new PreguntasOpciones(151,1,"LAS DOS TORRES ",38),
					new PreguntasOpciones(152,0,"LAS CINCO TORRES",38),
					new PreguntasOpciones(153,0,"EL ASCENSO DEL CABALLERO",39),
					new PreguntasOpciones(154,1,"EL RETORNO DEL REY",39),
					new PreguntasOpciones(155,0,"LA CAIDA DEL VILLANO",39),
					new PreguntasOpciones(156,0,"EL FIN DE LA MALDAD",39),
					new PreguntasOpciones(157,1,"LA COMUNIDAD DEL ANILLO",40),
					new PreguntasOpciones(158,0,"LA SOCIEDAD SECRETA DEL ANILLO",40),
					new PreguntasOpciones(159,0,"EL CLUB DEL ANILLO",40),
					new PreguntasOpciones(160,0,"LOS INVENCIBLES PORTADORES DEL ANILLO",40),

					new PreguntasOpciones(161,0,"2005",41),
					new PreguntasOpciones(162,1,"2008",41),
					new PreguntasOpciones(163,0,"2010",41),
					new PreguntasOpciones(164,0,"2012",41),
					new PreguntasOpciones(165,0,"Vanir",42),
					new PreguntasOpciones(166,1,"Mjolnir",42),
					new PreguntasOpciones(167,0,"Aesir",42),
					new PreguntasOpciones(168,0,"Norn",42),
					new PreguntasOpciones(169,0,"Que quiere estudiar The Hulk",43),
					new PreguntasOpciones(170,0,"Que él sabe sobre SHIELD",43),
					new PreguntasOpciones(171,1,"Que están formando un equipo",43),
					new PreguntasOpciones(172,0,"Que Thaddeus le debe dinero",43),
					new PreguntasOpciones(173,0,"Adamantium",44),
					new PreguntasOpciones(174,1,"Vibranio",44),
					new PreguntasOpciones(175,0,"prometeo",44),
					new PreguntasOpciones(176,0,"Carbonadio",44),
					new PreguntasOpciones(177,1,"Gatos",45),
					new PreguntasOpciones(178,0,"Patos",45),
					new PreguntasOpciones(179,0,"Reptiles",45),
					new PreguntasOpciones(180,0,"Mapaches",45),
					new PreguntasOpciones(181,0,"HOMERO",46),
					new PreguntasOpciones(182,1,"JARVIS",46),
					new PreguntasOpciones(183,0,"ALFREDO",46),
					new PreguntasOpciones(184,0,"MARVIN",46),
					new PreguntasOpciones(185,1,"T Challa",47),
					new PreguntasOpciones(186,0,"M Baku",47),
					new PreguntasOpciones(187,0,"N Jadaka",47),
					new PreguntasOpciones(188,0,"N Jobu",47),
					new PreguntasOpciones(189,1,"El chitauri",48),
					new PreguntasOpciones(190,0,"Los skrulls",48),
					new PreguntasOpciones(191,0,"El kree",48),
					new PreguntasOpciones(192,0,"Los flerkens",48),
					new PreguntasOpciones(193,0,"Thor",49),
					new PreguntasOpciones(194,1,"Loki",49),
					new PreguntasOpciones(195,0,"El coleccionista",49),
					new PreguntasOpciones(196,0,"Tony Stark",49),
					new PreguntasOpciones(197,1,"Natalie Rushman",50),
					new PreguntasOpciones(198,0,"Natalia Romanoff",50),
					new PreguntasOpciones(199,0,"Nicole Rohan",50),
					new PreguntasOpciones(200,0,"Naya Rabe",50),

					new PreguntasOpciones(201,1,"1923",51),
					new PreguntasOpciones(202,0,"1945",51),
					new PreguntasOpciones(203,0,"1970",51),
					new PreguntasOpciones(204,0,"1911",51),
					new PreguntasOpciones(205,1,"6",52),
					new PreguntasOpciones(206,0,"10",52),
					new PreguntasOpciones(207,0,"12",52),
					new PreguntasOpciones(208,0,"15",52),
					new PreguntasOpciones(209,0,"Los Angeles, California",53),
					new PreguntasOpciones(210,1,"Burbank, California",53),
					new PreguntasOpciones(211,0,"Jacksonville, Florida",53),
					new PreguntasOpciones(212,0,"Manhattan, Nueva York",53),
					new PreguntasOpciones(213,0,"15",54),
					new PreguntasOpciones(214,0,"8",54),
					new PreguntasOpciones(215,0,"17",54),
					new PreguntasOpciones(216,1,"13",54),
					new PreguntasOpciones(217,0,"Pinocho",55),
					new PreguntasOpciones(218,0,"Cenicienta",55),
					new PreguntasOpciones(219,1,"Blancanieves y los siete enanitos",55),
					new PreguntasOpciones(220,0,"Dumbo",55),
					new PreguntasOpciones(221,0,"Vaca clarabelle",56),
					new PreguntasOpciones(222,0,"Pato Donald",56),
					new PreguntasOpciones(223,1,"Pete",56),
					new PreguntasOpciones(224,0,"Horacio Horsecollar",56),
					new PreguntasOpciones(225,0,"Zazu",57),
					new PreguntasOpciones(226,1,"Iago",57),
					new PreguntasOpciones(227,0,"Rajah",57),
					new PreguntasOpciones(228,0,"Gus",57),
					new PreguntasOpciones(229,0,"Kiara y Mike",58),
					new PreguntasOpciones(230,0,"Kira y Mac",58),
					new PreguntasOpciones(231,0,"Keri y Malek",58),
					new PreguntasOpciones(232,1,"Kida y Milo",58),
					new PreguntasOpciones(233,1,"Anastasia y Drizella",59),
					new PreguntasOpciones(234,0,"Anna y Elsa",59),
					new PreguntasOpciones(235,0,"Jane y melanie",59),
					new PreguntasOpciones(236,0,"Aurora y Rapunzel",59),
					new PreguntasOpciones(237,0,"Para rascarse",60),
					new PreguntasOpciones(238,0,"Un palillo de dientes",60),
					new PreguntasOpciones(239,1,"Un peine",60),
					new PreguntasOpciones(240,0,"Algo para comer",60)
			);
			
			preguntasOpcionesRepository.saveAll(opciones);
		}
		
	}
	@Override
	public void reestablecerPreguntasUtilizadas() {
	   List<Preguntas> pregs = preguntasRepository.findAll();
	    
       for(Preguntas p : pregs){
           p.setUtilizada(false);
       }
       
       preguntasRepository.saveAll(pregs);
	}
}
