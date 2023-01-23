package src.presentacion;

import java.time.LocalDate;


import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import src.excepciones.ActividadRepetidaException;
import src.excepciones.DepartamentoRepetidoException;
import src.excepciones.ExcepcionAltaCategoria;
import src.excepciones.InscripcionCapacidadExcedidaException;
import src.excepciones.InscripcionYaExisteException;
import src.excepciones.PaqueteRepetidoException;
import src.excepciones.UsuarioRepetidoException;
import src.excepciones.ExcepcionAltaSalida;
import src.logica.clases.Fabrica;
import src.logica.clases.IActividad;
import src.logica.clases.IPaquete;
import src.logica.clases.IUsuario;
import src.logica.clases.Manejador;
import src.logica.datatypes.DTCategoria;

public class Prueba {
	
	public Prueba()throws ActividadRepetidaException, DepartamentoRepetidoException, PaqueteRepetidoException, ExcepcionAltaSalida, UsuarioRepetidoException, ExcepcionAltaCategoria{
		
        Fabrica fabrica = new Fabrica();
        IActividad controladorActividad = fabrica.getIActividad();
        IUsuario controladorusuario = fabrica.getIUsuario();
        IPaquete controladorpaquete = fabrica.getIPaquete();
        Manejador manejador = Manejador.getInstancia();

        //carga departamentos
        controladorActividad.altaDepartamento("Canelones", "División Turismo de la Intendencia" , "https://www.imcanelones.gub.uy/es");
        controladorActividad.altaDepartamento("Maldonado", "División Turismo de la Intendencia" , "https://www.maldonado.gub.uy/");
        controladorActividad.altaDepartamento("Rocha", "La Organización de Gestión del Destino (OGD) Rocha es un ámbito de articulación público - privada en el sector turístico que integran la Corporación Rochense de Turismo y la Intendencia de Rocha a través de su Dirección de Turismo." , "www.turismorocha.gub.uy");
        controladorActividad.altaDepartamento("Treinta y Tres", "División Turismo de la Intendencia" , "https://treintaytres.gub.uy/");
        controladorActividad.altaDepartamento("Cerro Largo", "División Turismo de la Intendencia" , "https://www.gub.uy/intendencia-cerro-largo/");
        controladorActividad.altaDepartamento("Rivera", "Promociona e implementa proyectos e iniciativas sostenibles de interés turístico con la participación institucional pública - privada en bien del desarrollo socioeconómico de la comunidad." , "www.rivera.gub.uy/social/turismo/");
        controladorActividad.altaDepartamento("Artigas", "División Turismo de la Intendencia" , "http://www.artigas.gub.uy");
        controladorActividad.altaDepartamento("Salto", "División Turismo de la Intendencia" , "https://www.salto.gub.uy");
        controladorActividad.altaDepartamento("Paysandú", "División Turismo de la Intendencia" , "https://www.paysandu.gub.uy");
        controladorActividad.altaDepartamento("Río Negro", "División Turismo de la Intendencia" , "https://www.rionegro.gub.uy");
        controladorActividad.altaDepartamento("Soriano", "División Turismo de la Intendencia" , "https://www.soriano.gub.uy");
        controladorActividad.altaDepartamento("Colonia", "La propuesta del Departamento de Colonia divide en cuatro actos su espectáculo anual. Cada acto tiene su magia. Desde su naturaleza y playas hasta sus tradiciones y el patrimonio mundial. Todo el aÃ±o se disfruta." , "https://colonia.gub.uy/turismo/");
        controladorActividad.altaDepartamento("San José", "División Turismo de la Intendencia" , "https://sanjose.gub.uy");
        controladorActividad.altaDepartamento("Flores", "División Turismo de la Intendencia" , "https://flores.gub.uy");
        controladorActividad.altaDepartamento("Florida", "División Turismo de la Intendencia" , "http://www.florida.gub.uy");
        controladorActividad.altaDepartamento("Lavalleja", "División Turismo de la Intendencia" , "http://www.lavalleja.gub.uy");
        controladorActividad.altaDepartamento("Durazno", "División Turismo de la Intendencia" , "https://durazno.uy");
        controladorActividad.altaDepartamento("Tacuarembó", "División Turismo de la Intendencia" , "https://tacuarembo.gub.uy");
        controladorActividad.altaDepartamento("Montevideo", "División Turismo de la Intendencia" , "https://montevideo.gub.uy/areas-tematicas/turismo");
        
        //alta proveedor
        String imagenProv1 ="https://c.wallhere.com/photos/55/39/safe_house_cia_agent_tobin_frost_denzel_washington-584127.jpg!d";
        String contraProv1 ="asdfg654";
        controladorusuario.aceptarAltaProveedor("Washington", "Rocha", "washington", "washington@turismorocha.gub.uy", contraProv1, LocalDate.of(1970, 9, 14), imagenProv1, "Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay", "http://turismorocha.gub.uy/");
        
        String imagenProv2 ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSI6iVebQtM32FoIZFXUPSIhJlQo2asvOouzw&usqp=CAU";
        String contraProv2 ="ytrewq10";
        controladorusuario.aceptarAltaProveedor("Pablo", "Bengochea", "eldiez", "eldiez@socfomturriv.org.uy", contraProv2, LocalDate.of(1965, 6, 27), imagenProv2, "Pablo es el presidente de la Sociedad de Fomento Turístico de Rivera (conocida como Socfomturriv)", "http://wwww.socfomturriv.org.uy");
        
        String imagenProv3 ="https://pbs.twimg.com/media/EmLg8pkXYAAkuGY?format=jpg&name=small";
        String contraProv3 ="mnjkiu89";
        controladorusuario.aceptarAltaProveedor("Mercedes", "Venn", "meche", "meche@colonia.gub.uy", contraProv3,  LocalDate.of(1990, 12, 31), imagenProv3,"Departamento de Turismo del Departamento de Colonia", "https://colonia.gub.uy/turismo/");
        
        //alta turista
        String turista1 ="https://pbs.twimg.com/media/EOHAP9zWoAsnkiM?format=jpg&name=small";
        String contraturista1 ="awdrg543";
        controladorusuario.aceptarAltaTurista("lachiqui", "Rosa María", "Martínez", "mirtha.legrand.ok@hotmail.com.ar", contraturista1,  LocalDate.of(1927, 2, 23), turista1,  "argentina"); 
        
        String turista2 ="https://ca-times.brightspotcdn.com/dims4/default/2413d30/2147483647/strip/true/crop/720x1024+0+0/resize/840x1195!/format/webp/quality/90/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F9b%2Fe3%2F0973ea3441e396271b457c1e0b31%2Fap22146719572803.jpg";
        String contraturista2 ="r5t6y7u8";
        controladorusuario.aceptarAltaTurista("isabelita", "Elizabeth", "Windsor", "isabelita@thecrown.co.uk", contraturista2,  LocalDate.of(1926, 4, 21), turista2,  "inglesa");
        
        String turista3 ="https://es.web.img2.acsta.net/c_310_420/pictures/14/01/20/09/27/059623.jpg";
        String contraturista3 ="edrft543";
        controladorusuario.aceptarAltaTurista("anibal", "Aníbal", "Lecter", "anibal@fing.edu.uy", contraturista3,  LocalDate.of(1937, 12, 31), turista3,  "lituana");
        
        String turista4 ="https://i.pinimg.com/originals/88/aa/b9/88aab93b1948c13d6acb878ced5e182e.jpg";
        String contraturista4 ="poiuy987";
        controladorusuario.aceptarAltaTurista("waston", "Emma", "Waston", "e.waston@gmail.com", contraturista4,  LocalDate.of(1990, 4, 15), turista4,  "inglesa");
        
        String turista5 ="https://sc2.elpais.com.uy/files/article_default_content/uploads/2021/11/03/61830c08f3881.jpeg";
        String contraturista5 ="45idgaf67";
        controladorusuario.aceptarAltaTurista("elelvis", "Elvis", "Lacio", "suavemente@hotmail.com", contraturista5,  LocalDate.of(1971, 7, 30), turista5,  "estadounidense");
        
        String turista6 ="https://static.zerochan.net/Eleven.%28Stranger.Things%29.full.2671625.jpg";
        String contraturista6 ="xdrgb657";
        controladorusuario.aceptarAltaTurista("eleven11", "Eleven", "Once", "eleven11@gmail.com", contraturista6,  LocalDate.of(2004, 02, 19), turista6,  "española");
        
        String turista7 ="https://smoda.elpais.com/wp-content/uploads/2020/06/bob-esponja-591x447.jpg";
        String contraturista7 ="sbsplol1";
        controladorusuario.aceptarAltaTurista("bobesponja", "Bob", "Esponja", "bobesponja@nickelodeon.com", contraturista7,  LocalDate.of(1999, 5, 1), turista7, "japonesa");
        
        String turista8 ="https://vinostonypacheco.com/images/500x500_2.jpg";
        String contraturista8 ="okmnji98";
        controladorusuario.aceptarAltaTurista("tony", "Antonio", "Pacheco", "eltony@manya.org.uy", contraturista8,  LocalDate.of(1976, 4, 11), turista8,   "uruguaya");
        
        String turista9 ="https://www.doblealturadeco.com/wp-content/uploads/2020/08/02-ChinoRecoba.jpg";
        String contraturista9 ="qsxcdw43";
        controladorusuario.aceptarAltaTurista("chino", "Álvaro", "Recoba", "chino@trico", contraturista9,  LocalDate.of(1976, 3, 17), turista9,  "uruguaya");
        
        String turista10 ="https://static.lesluthiers.org/fotos/Personajes/mastropiero.png";
        String contraturista10 ="qpwoei586";
        controladorusuario.aceptarAltaTurista("mastropiero", "Johann Sebastian", "Mastropiero", "johann.sebastian@gmail.com", contraturista10,  LocalDate.of(1922, 2, 7), turista10,  "austriaca");
        
      //seguidores y seguidos
        controladorusuario.seguirONoAUsuario("lachiqui", "isabelita");
        controladorusuario.seguirONoAUsuario("lachiqui", "mastropiero");
        controladorusuario.seguirONoAUsuario("lachiqui", "washington");
        controladorusuario.seguirONoAUsuario("lachiqui", "eldiez");
        controladorusuario.seguirONoAUsuario("lachiqui", "meche");
        controladorusuario.seguirONoAUsuario("isabelita", "lachiqui");
        controladorusuario.seguirONoAUsuario("anibal", "waston");
        controladorusuario.seguirONoAUsuario("anibal", "eleven11");
        controladorusuario.seguirONoAUsuario("anibal", "bobesponja");
        controladorusuario.seguirONoAUsuario("anibal", "meche");
        controladorusuario.seguirONoAUsuario("waston", "isabelita");
        controladorusuario.seguirONoAUsuario("waston", "washington");
        controladorusuario.seguirONoAUsuario("elelvis", "bobesponja");
        controladorusuario.seguirONoAUsuario("elelvis", "tony");
        controladorusuario.seguirONoAUsuario("elelvis", "eldiez");
        controladorusuario.seguirONoAUsuario("eleven11", "lachiqui");
        controladorusuario.seguirONoAUsuario("eleven11", "waston");
        controladorusuario.seguirONoAUsuario("eleven11", "mastropiero");
        controladorusuario.seguirONoAUsuario("bobesponja", "anibal");
        controladorusuario.seguirONoAUsuario("bobesponja", "eleven11");
        controladorusuario.seguirONoAUsuario("tony", "chino");
        controladorusuario.seguirONoAUsuario("tony", "eldiez");
        controladorusuario.seguirONoAUsuario("chino", "elelvis");
        controladorusuario.seguirONoAUsuario("chino", "mastropiero");
        controladorusuario.seguirONoAUsuario("chino", "washington");
        controladorusuario.seguirONoAUsuario("chino", "meche");
        controladorusuario.seguirONoAUsuario("washington", "mastropiero");
        controladorusuario.seguirONoAUsuario("washington", "waston");
        controladorusuario.seguirONoAUsuario("eldiez", "tony");
        controladorusuario.seguirONoAUsuario("meche", "lachiqui");
        controladorusuario.seguirONoAUsuario("meche", "isabelita");
        controladorusuario.seguirONoAUsuario("meche", "waston");
        controladorusuario.seguirONoAUsuario("meche", "eleven11");
        
        //alta categorias
        controladorActividad.aceptarAltaCategoria("Aventura y Deporte");
        controladorActividad.aceptarAltaCategoria("Campo y Naturaleza");
        controladorActividad.aceptarAltaCategoria("Cultura y Patrimonio");
        controladorActividad.aceptarAltaCategoria("Gastronomia");
        controladorActividad.aceptarAltaCategoria("Turismo Playas");
        
        //creo map de categorias para pasarle al altaActividad
        Map<String,DTCategoria> categoriaparaAct1 = new HashMap<String, DTCategoria>();
        categoriaparaAct1.put("Gastronomia", manejador.getCategorias().get("Gastronomia").obtenerDTCategoria()); //terminar de agregar las actividades al mapping
        
        Map<String,DTCategoria> categoriaparaAct2 = new HashMap<String, DTCategoria>();
        categoriaparaAct2.put("Cultura y Patrimonio",  manejador.getCategorias().get("Cultura y Patrimonio").obtenerDTCategoria());
        categoriaparaAct2.put("Gastronomia",  manejador.getCategorias().get("Gastronomia").obtenerDTCategoria());
        
        Map<String,DTCategoria> categoriaparaAct3 = new HashMap<String, DTCategoria>();
        categoriaparaAct3.put("Cultura y Patrimonio",  manejador.getCategorias().get("Cultura y Patrimonio").obtenerDTCategoria());
        
        Map<String,DTCategoria> categoriaparaAct4 = new HashMap<String, DTCategoria>();
        categoriaparaAct4.put("Gastronomia",  manejador.getCategorias().get("Gastronomia").obtenerDTCategoria());
        
        Map<String,DTCategoria> categoriaparaAct5 = new HashMap<String, DTCategoria>();
        categoriaparaAct5.put("Campo y Naturaleza",  manejador.getCategorias().get("Campo y Naturaleza").obtenerDTCategoria());
        categoriaparaAct5.put("Gastronomia",  manejador.getCategorias().get("Gastronomia").obtenerDTCategoria());
        
        Map<String,DTCategoria> categoriaparaAct6 = new HashMap<String, DTCategoria>();
        categoriaparaAct6.put("Campo y Naturaleza",  manejador.getCategorias().get("Campo y Naturaleza").obtenerDTCategoria());
        
        Map<String,DTCategoria> categoriaparaAct7 = new HashMap<String, DTCategoria>();
        categoriaparaAct7.put("Cultura y Patrimonio",  manejador.getCategorias().get("Cultura y Patrimonio").obtenerDTCategoria());
  
        Map<String,DTCategoria> categoriaparaAct8 = new HashMap<String, DTCategoria>();
        categoriaparaAct8.put("Cultura y Patrimonio",  manejador.getCategorias().get("Cultura y Patrimonio").obtenerDTCategoria());
        
        Map<String,DTCategoria> categoriaparaAct9 = new HashMap<String, DTCategoria>();
        categoriaparaAct9.put("Aventura y Deporte",  manejador.getCategorias().get("Aventura y Deporte").obtenerDTCategoria());
        categoriaparaAct9.put("Turismo Playas",  manejador.getCategorias().get("Turismo Playas").obtenerDTCategoria());
        
        Map<String,DTCategoria> categoriaparaAct10 = new HashMap<String, DTCategoria>();
        categoriaparaAct10.put("Cultura y Patrimonio",  manejador.getCategorias().get("Cultura y Patrimonio").obtenerDTCategoria());
        
        
        //alta de actividades    
        LocalDate fechaAA1 = LocalDate.of(2022, 7, 20);
        LocalDate fechaAA2 = LocalDate.of(2022, 7, 21);
        LocalDate fechaAA3 = LocalDate.of(2022, 8, 1);
        LocalDate fechaAA4 = LocalDate.of(2022, 8, 1);
        LocalDate fechaAA5 = LocalDate.of(2022, 8, 1);
        LocalDate fechaAA6 = LocalDate.of(2022, 8, 1);
        LocalDate fechaAA7 = LocalDate.of(2022, 9, 1);
        LocalDate fechaAA8 = LocalDate.of(2022, 9, 3);
        LocalDate fechaAA9 = LocalDate.of(2022, 9, 5);
        LocalDate fechaAA10 = LocalDate.of(2022, 9, 16);
        
        String imagenA1 = "https://s3.amazonaws.com/turismorocha/eventos/2569/cover/degusta-048968300-1659558891.jpg";
        controladorActividad.aceptarAltaActividad("washington", "Rocha", "Degusta", "Festival gastronómico de productos locales en Rocha", "Rocha", 3, 800, fechaAA1,categoriaparaAct1,imagenA1);
        controladorActividad.confirmarActividad("Degusta");
        
        String imagenA2 = "https://s3.amazonaws.com/turismorocha/eventos/2579/cover/teatro-con-sabores-008950900-1659638152.jpg";
        controladorActividad.aceptarAltaActividad("washington", "Rocha", "Teatro con Sabores", "En el mes aniversario del Club Deportivo Unión de Rocha te invitamos a una merienda deliciosa." , "Rocha", 3, 500, fechaAA2,categoriaparaAct2,imagenA2);
        controladorActividad.confirmarActividad("Teatro con Sabores");
        
        String imagenA3 ="https://www.coloniauy.com/wp-content/uploads/2014/10/city-tour-por-colonia-del-sacramento-2.jpg";
        controladorActividad.aceptarAltaActividad("meche", "Colonia", "Tour por Colonia del Sacramento", "Con guía especializado y en varios idiomas.", "Colonia del Sacramento", 2, 400, fechaAA3,categoriaparaAct3,imagenA3);
        controladorActividad.confirmarActividad("Tour por Colonia del Sacramento");
        
        String imagenA4 ="https://www.colonia.gub.uy/uploads/noticia_9539a26b2ab84e8e5f3dc136206ffa24857f2850.jpg";
        controladorActividad.aceptarAltaActividad("meche", "Colonia", "Almuerzo en el Real de San Carlos", "Restaurante en la renovada Plaza de Toros con menÃº internacional", "Colonia del Sacramento", 2, 800, fechaAA4,categoriaparaAct4,imagenA4);
        controladorActividad.confirmarActividad("Almuerzo en el Real de San Carlos");
        
        String imagenA5 ="https://www.gub.uy/ministerio-ambiente/sites/ministerio-ambiente/files/inline-images/Lunarejo.jpg";
        controladorActividad.aceptarAltaActividad("eldiez", "Rivera", "Almuerzo en Valle del Lunarejo", "Almuerzo en la Posada con ticket fijo. MenÃº que incluye bebida y postre casero.", "Tranqueras", 2, 300, fechaAA5,categoriaparaAct5,imagenA5);
        controladorActividad.confirmarActividad("Almuerzo en Valle del Lunarejo");
        
        String imagenA6 ="http://elgavilan-valledellunarejo.com.uy/wp-content/uploads/2020/12/WhatsApp-Image-2020-12-21-at-4.28.25-PM.jpeg";
        controladorActividad.aceptarAltaActividad("eldiez", "Rivera", "Cabalgata en Valle del Lunarejo", "Cabalgata por el Área protegida. Varios recorridos para elegir.", "Tranqueras", 2, 150, fechaAA6,categoriaparaAct6,imagenA6);
        controladorActividad.confirmarActividad("Cabalgata en Valle del Lunarejo");
        
        String imagenA7 ="https://viajeacoloniauruguay.com/wp-content/uploads/2019/04/Bus_Turistico_Colonia.jpg";
        controladorActividad.aceptarAltaActividad("meche","Colonia", "Bus turístico Colonia", "Recorrida por los principales atractivos de la ciudad", "Colonia del Sacramento", 3, 600, fechaAA7,categoriaparaAct7,imagenA7);
        //queda en estado agregada por la funcion aceptarAlta()
        
        String imagenA8 ="https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/9d/ed/fd.jpg";
        controladorActividad.aceptarAltaActividad("meche","Colonia", "Colonia Premium Tour", "Visita lugares exclusivos y relevantes", "Colonia del Sacramento", 4, 2600, fechaAA8,categoriaparaAct8,imagenA8);
        controladorActividad.rechazarActividad("Colonia Premium Tour");
        
        String imagenA9 ="https://s3.amazonaws.com/turismorocha/operadores/202/med/la-barrita-de-la-laguna-032637600-1546992923.jpg";
        controladorActividad.aceptarAltaActividad("washington", "Rocha", "Deportes náuticos sin uso de motor", "kitsurf - windsurf - kayakismo - canotaje en Rocha", "Rocha", 3, 1200, fechaAA9,categoriaparaAct9,imagenA9);
        //queda en estado agregada por la funcion aceptarAlta()
        
        String imagenA10 ="https://upload.wikimedia.org/wikipedia/commons/6/6e/Obelisco_-_Plaza_Internacional_-_Frontera_de_la_Paz_-_Livramento_-_Rivera.jpeg";
        controladorActividad.aceptarAltaActividad("eldiez", "Rivera", "Descubre Rivera", "Rivera es un departamento de extraordinaria riqueza natural patrimonial y cultural con una ubicación geográfica privilegiada", "Rivera", 2, 650, fechaAA10,categoriaparaAct10,imagenA10);
        controladorActividad.rechazarActividad("Descubre Rivera");
        
        //Carga salidas
        LocalTime hora1 = LocalTime.of(17, 00);
        LocalTime hora2 = LocalTime.of(17, 00);
        LocalTime hora3 = LocalTime.of(18, 00);
        LocalTime hora4 = LocalTime.of(18, 00);
        LocalTime hora5 = LocalTime.of(10, 00);
        LocalTime hora6 = LocalTime.of(10, 00);
        LocalTime hora7 = LocalTime.of(12, 00);
        LocalTime hora8 = LocalTime.of(12, 00);
        LocalTime hora9 = LocalTime.of(12, 00);
        LocalTime hora10 = LocalTime.of(12, 00);
        LocalTime hora11 = LocalTime.of(16, 00);
        LocalTime hora12 = LocalTime.of(16, 00);
        LocalTime hora13 = LocalTime.of(17, 00);
        LocalTime hora14 = LocalTime.of(17, 00);
        LocalTime hora15 = LocalTime.of(18, 00);
        LocalTime hora16 = LocalTime.of(10, 00);
        LocalTime hora17= LocalTime.of(16, 00);
        LocalTime hora18 = LocalTime.of(12, 00);
        LocalTime hora19 = LocalTime.of(17, 00);
        LocalTime hora20 = LocalTime.of(18, 00);
        
        LocalDate fecha1 = LocalDate.of(2022, 7 , 21);
        LocalDate fecha2 = LocalDate.of(2022, 8, 20);
        LocalDate fecha3 = LocalDate.of(2022, 7, 22);
        LocalDate fecha4 = LocalDate.of(2022, 9, 03);
        LocalDate fecha5 = LocalDate.of(2022, 7, 23);
        LocalDate fecha6 = LocalDate.of(2022, 9, 04);
        LocalDate fecha7 = LocalDate.of(2022, 7, 23);
        LocalDate fecha8 = LocalDate.of(2022, 9, 11);
        LocalDate fecha9 = LocalDate.of(2022, 8, 05);
        LocalDate fecha10= LocalDate.of(2022, 9, 11);
        LocalDate fecha11 = LocalDate.of(2022, 8, 05);
        LocalDate fecha12 = LocalDate.of(2022, 9, 18);
        LocalDate fecha13 = LocalDate.of(2022, 8, 04);
        LocalDate fecha14= LocalDate.of(2022, 9, 18);
        LocalDate fecha15 = LocalDate.of(2022, 8, 04);
        LocalDate fecha16 = LocalDate.of(2022, 9, 25);
        LocalDate fecha17 = LocalDate.of(2022, 8, 15);
        LocalDate fecha18 = LocalDate.of(2022, 9, 10);
        LocalDate fecha19 = LocalDate.of(2022, 8, 15);
        LocalDate fecha20 = LocalDate.of(2022, 9, 11);
        LocalDate fecha21 = LocalDate.of(2022, 8, 15);
        LocalDate fecha22 = LocalDate.of(2022, 9, 10);
        LocalDate fecha23 = LocalDate.of(2022, 8, 15);
        LocalDate fecha24 = LocalDate.of(2022, 9, 11);
        LocalDate fecha25 = LocalDate.of(2022, 9, 22);
        LocalDate fecha26 = LocalDate.of(2022, 10, 30);
        LocalDate fecha27 = LocalDate.of(2022, 10, 2);
        LocalDate fecha28 = LocalDate.of(2022, 11, 5);
        LocalDate fecha29 = LocalDate.of(2022, 8, 25);
        LocalDate fecha30 = LocalDate.of(2022, 11, 11);
        LocalDate fecha31 = LocalDate.of(2022, 9, 7);
        LocalDate fecha32 = LocalDate.of(2022, 10, 30);
        LocalDate fecha33 = LocalDate.of(2022, 9, 15);
        LocalDate fecha34 = LocalDate.of(2022, 10, 30);
        LocalDate fecha35 = LocalDate.of(2022, 10, 10);
        LocalDate fecha36 = LocalDate.of(2022, 10, 30);
        LocalDate fecha37 = LocalDate.of(2022, 11, 7);
        LocalDate fecha38 = LocalDate.of(2022, 12, 2);
        LocalDate fecha39 = LocalDate.of(2022, 11, 7);
        LocalDate fecha40 = LocalDate.of(2022, 12, 3);
        
        
        
        String imagenSalida1 ="https://city.woow.com.uy/media/catalog/product/cache/dcf64a24127a43d9ce9fe76e3e5f8061/n/u/nueva2_3_1.jpg";
        controladorActividad.ingresarDatosSalidaTuristica("Degusta", "Degusta Agosto", 20, fecha1, fecha2, hora1, "Sociedad Agropecuaria de Rocha",imagenSalida1);
        
        String imagenSalida2 = "https://s3.amazonaws.com/turismorocha/operadores/1/med/bahia-resto-053888900-1458674720.JPG";
        controladorActividad.ingresarDatosSalidaTuristica("Degusta", "Degusta Setiembre", 20, fecha3, fecha4, hora2, "Sociedad Agropecuaria de Rocha",imagenSalida2);
        
        String imagenSalida3 ="https://thumbs.dreamstime.com/b/teatro-de-la-cena-3857878.jpg";
        controladorActividad.ingresarDatosSalidaTuristica("Teatro con Sabores", "Teatro con Sabores 1", 30, fecha5, fecha6, hora3, "Club Deportivo Unión",imagenSalida3);
        
        String imagenSalida4 = "https://www.teatroreal.es/sites/default/files/2019-09/MESITAS%20%281%29.jpg";
        controladorActividad.ingresarDatosSalidaTuristica("Teatro con Sabores", "Teatro con Sabores 2", 30, fecha7, fecha8, hora4, "Club Deportivo Unión",imagenSalida4);
        
        String imagenSalida5 ="https://upload.wikimedia.org/wikipedia/commons/4/42/Colonia_de_Sacramento.jpg";
        controladorActividad.ingresarDatosSalidaTuristica("Tour por Colonia del Sacramento", "Tour Colonia del Sacramento 11-09", 5, fecha9, fecha10, hora5, "Encuentro en la base del Faro",imagenSalida5);
        
        String imagenSalida6 ="https://www.surfingtheplanet.com/wp-content/uploads/2012/04/DSC4945.jpg";
        controladorActividad.ingresarDatosSalidaTuristica("Tour por Colonia del Sacramento", "Tour Colonia del Sacramento 18-09", 5, fecha11, fecha12 , hora6, "Encuentro en la base del Faro",imagenSalida6);
        
        //sin foto
        controladorActividad.ingresarDatosSalidaTuristica("Almuerzo en el Real de San Carlos", "Almuerzo 1" , 5 , fecha13, fecha14, hora7, "Restaurante de la Plaza de Toros",null);
        
        //sin foto
        controladorActividad.ingresarDatosSalidaTuristica("Almuerzo en el Real de San Carlos", "Almuerzo 2", 5, fecha15, fecha16, hora8, "Restaurante de la Plaza de Toros",null);
        
        //sin foto
        controladorActividad.ingresarDatosSalidaTuristica("Almuerzo en Valle del Lunarejo", "Almuerzo 3" , 4 , fecha17 , fecha18 , hora9, "Posada Del Lunarejo",null);
        
        //sin foto
        controladorActividad.ingresarDatosSalidaTuristica("Almuerzo en Valle del Lunarejo", "Almuerzo 4", 4, fecha19, fecha20, hora10, "Posada Del Lunarejo",null);
        
        String imagencabalgata1 ="https://volemos.nyc3.cdn.digitaloceanspaces.com/blog/wp-content/uploads/2021/12/14132221/cabalgatas-valle-del-Lunarejo.jpg";
        controladorActividad.ingresarDatosSalidaTuristica("Cabalgata en Valle del Lunarejo", "Cabalgata 1" , 4, fecha21, fecha22, hora11, "Posada Del Lunarejo",imagencabalgata1);
        
        //sin foto
        controladorActividad.ingresarDatosSalidaTuristica("Cabalgata en Valle del Lunarejo", "Cabalgata 2", 4, fecha23, fecha24, hora12, "Posada Del Lunarejo",null);
        
        String imagenSalidadegustaoctubre ="https://www.cucinare.tv/wp-content/uploads/2020/02/Carne-Hermanos-1024x579.jpg";
        controladorActividad.ingresarDatosSalidaTuristica("Degusta", "Degusta Octubre", 20, fecha25, fecha26, hora13, "Sociedad Agropecuaria de Rocha",imagenSalidadegustaoctubre);
        
        String imagenSalidaDegusNoviembre ="https://s3.amazonaws.com/turismorocha/operadores/156/med/maria-esther-089483400-1481752402.JPG";
        controladorActividad.ingresarDatosSalidaTuristica("Degusta", "Degusta Noviembre", 20, fecha27, fecha28, hora14, "Sociedad Agropecuaria de Rocha",imagenSalidaDegusNoviembre);
        
        //sin foto
        //no agarra la salida. poniendo 29,30 se rompe , 30,29 compila.
        controladorActividad.ingresarDatosSalidaTuristica("Teatro con Sabores", "Teatro con Sabores 3", 30 ,fecha29, fecha30, hora15, "Club Deportivo Unión",null);
        
        String imagenSalidaTeatroSabores3010 ="https://www.globeguide.ca/wp-content/uploads/2017/10/Uruguay-Colonia-52.jpg";
        controladorActividad.ingresarDatosSalidaTuristica("Tour por Colonia del Sacramento", "Tour Colonia del Sacramento 30-10", 10, fecha31, fecha32, hora16, "Encuentro en la base del Fato",imagenSalidaTeatroSabores3010);
        
        //no agarra
        String imagenSalidaValleLunarejo ="http://elgavilan-valledellunarejo.com.uy/wp-content/uploads/2020/12/WhatsApp-Image-2020-12-21-at-4.28.25-PM.jpeg";
        controladorActividad.ingresarDatosSalidaTuristica("Cabalgata en Valle del Lunarejo", "Cabalgata Extrema",4,fecha33, fecha34, hora17, "Posada del Lunarejo",imagenSalidaValleLunarejo);
        
        
        //sin foto
        //no agarra
        controladorActividad.ingresarDatosSalidaTuristica("Almuerzo en el Real de San Carlos", "Almuerzo en el Real 1",10,fecha35, fecha36, hora18, "Restaurante de la Plaza de Toros",null);
        
        //S19
        controladorActividad.ingresarDatosSalidaTuristica("Degusta", "Degusta Diciembre", 20, fecha37, fecha38, hora19, "Sociedad Agropecuaria de Rocha","https://s3.amazonaws.com/turismorocha/operadores/156/med/maria-esther-089483400-1481752402.JPG");
        
        //s20
        controladorActividad.ingresarDatosSalidaTuristica("Teatro con Sabores","Teatro con Sabores 4" , 30,fecha39, fecha40, hora20,"Club Deportivo Unión, 07/11/2022",null);
        

        
        
        //Carga Paquetes
        LocalDate fechap1 = LocalDate.of(2022, 8, 10);
        LocalDate fechap2 = LocalDate.of(2022, 8, 1);
        LocalDate fechap3 = LocalDate.of(2022, 9, 15);
        LocalDate fechap4 = LocalDate.of(2022, 11, 7);
        controladorpaquete.crearNuevoPaquete("Disfrutar Rocha", "Actividades para hacer en familia y disfrutar arte y gastronomía", 60, 20, fechap1, "https://sites.google.com/site/areasprotegidasenuruguay/_/rsrc/1411660757953/algunas-de-las-areas-ingresadas-por-el-snap/laguna-de-rocha/Mapa_Rocha_BLOG.jpg?height=280&width=400");
        controladorpaquete.crearNuevoPaquete("Un día en Colonia", "Paseos por el casco histórico y se puede terminar con Almuerzo en la Plaza de Toros", 45, 15, fechap2, "https://www.lr21.com.uy/wp-content/uploads/2021/12/plaza-toros-colonia.jpg");
        controladorpaquete.crearNuevoPaquete("Valle del Lunarejo", "Visite un área protegida con un paisaje natural hermoso", 60, 15, fechap3, "http://www.indra.org.uy/images/inauguracion-03.jpg");
        controladorpaquete.crearNuevoPaquete("Rocha de Fiesta","Para cerrar el año a lo grande en nuestro departamento más oceánico", 45, 30, fechap4,null);

        //Carga De Actividades En Paquete
        //se saco uno se agrego el ultimo
        controladorpaquete.ingresarActividadTuristica("Degusta", "Disfrutar Rocha");
        controladorpaquete.ingresarActividadTuristica("Teatro con Sabores", "Disfrutar Rocha");
        controladorpaquete.ingresarActividadTuristica("Tour por Colonia del Sacramento", "Un día en Colonia");
        controladorpaquete.ingresarActividadTuristica("Almuerzo en Valle del Lunarejo", "Valle del Lunarejo");
        controladorpaquete.ingresarActividadTuristica("Cabalgata en Valle del Lunarejo", "Valle del Lunarejo");
        controladorpaquete.ingresarActividadTuristica("Degusta","Rocha de Fiesta");
        
        //alta de inscripciones
        LocalDate fechaI1 = LocalDate.of(2022, 8, 15);
        LocalDate fechaI2 = LocalDate.of(2022, 8, 16);
        LocalDate fechaI3 = LocalDate.of(2022, 8, 18);
        LocalDate fechaI4 = LocalDate.of(2022, 8, 19);
        LocalDate fechaI5 = LocalDate.of(2022, 8, 19);
        LocalDate fechaI6 = LocalDate.of(2022, 8, 19);
        LocalDate fechaI7 = LocalDate.of(2022, 8, 20);
        LocalDate fechaI8 = LocalDate.of(2022, 8, 20);
        LocalDate fechaI9 = LocalDate.of(2022, 8, 21);
        LocalDate fechaI10 = LocalDate.of(2022, 8, 21);
        
        LocalDate fechaI11 = LocalDate.of(2022, 10, 3);
        LocalDate fechaI12 = LocalDate.of(2022, 10, 3);
        LocalDate fechaI13 = LocalDate.of(2022, 9, 2);
        LocalDate fechaI14 = LocalDate.of(2022, 9, 2);
        LocalDate fechaI15 = LocalDate.of(2022, 9, 3);
        LocalDate fechaI16 = LocalDate.of(2022, 9, 3);
        LocalDate fechaI17 = LocalDate.of(2022, 9, 5);
        LocalDate fechaI18 = LocalDate.of(2022, 9, 5);
        LocalDate fechaI19 = LocalDate.of(2022, 10, 2);
        LocalDate fechaI20 = LocalDate.of(2022, 10, 11);
        LocalDate fechaI21 = LocalDate.of(2022, 10, 12);
        LocalDate fechaI22 = LocalDate.of(2022, 10, 12);
        
        try {
        controladorusuario.aceptarInscripcion("lachiqui", "Degusta Agosto", "Degusta", 3, fechaI1);
        controladorusuario.aceptarInscripcion("elelvis", "Degusta Agosto", "Degusta", 5, fechaI2);
        controladorusuario.aceptarInscripcion("lachiqui", "Tour Colonia del Sacramento 18-09", "Tour por Colonia del Sacramento", 3, fechaI3);
        controladorusuario.aceptarInscripcion("isabelita", "Tour Colonia del Sacramento 18-09", "Tour por Colonia del Sacramento", 1, fechaI4);
        controladorusuario.aceptarInscripcion("mastropiero","Almuerzo 2","Almuerzo en el Real de San Carlos",2,fechaI5);
        controladorusuario.aceptarInscripcion("chino", "Teatro con Sabores 1", "Teatro con Sabores", 1, fechaI6);
        controladorusuario.aceptarInscripcion("chino", "Teatro con Sabores 2", "Teatro con Sabores", 10, fechaI7);
        controladorusuario.aceptarInscripcion("bobesponja", "Teatro con Sabores 2", "Teatro con Sabores", 2, fechaI8);
        controladorusuario.aceptarInscripcion("anibal", "Teatro con Sabores 2", "Teatro con Sabores", 1, fechaI9);
        controladorusuario.aceptarInscripcion("tony", "Degusta Setiembre", "Degusta", 11, fechaI10);
        
        controladorusuario.aceptarInscripcion("lachiqui", "Degusta Noviembre", "Degusta", 2, fechaI11);
        controladorusuario.aceptarInscripcion("lachiqui", "Teatro con Sabores 3", "Teatro con Sabores", 2, fechaI12);
        controladorusuario.aceptarInscripcion("elelvis", "Degusta Setiembre", "Degusta", 5, fechaI13);
        controladorusuario.aceptarInscripcion("elelvis", "Teatro con Sabores 1", "Teatro con Sabores", 5, fechaI14);
        controladorusuario.aceptarInscripcion("lachiqui", "Tour Colonia del Sacramento 11-09", "Tour por Colonia del Sacramento", 5, fechaI15);
        controladorusuario.aceptarInscripcion("lachiqui", "Almuerzo 1", "Almuerzo en el Real de San Carlos", 5, fechaI16);
        controladorusuario.aceptarInscripcion("waston", "Tour Colonia del Sacramento 18-09", "Tour por Colonia del Sacramento", 1, fechaI17);
        controladorusuario.aceptarInscripcion("waston", "Almuerzo 2", "Almuerzo en el Real de San Carlos", 1, fechaI18);
        controladorusuario.aceptarInscripcion("elelvis", "Tour Colonia del Sacramento 30-10", "Tour por Colonia del Sacramento", 2, fechaI19);
        controladorusuario.aceptarInscripcion("elelvis", "Almuerzo en el Real 1",  "Almuerzo en el Real de San Carlos", 2, fechaI20);
        controladorusuario.aceptarInscripcion("mastropiero", "Tour Colonia del Sacramento 30-10", "Tour por Colonia del Sacramento", 4, fechaI21); //puede llegar a romper
        controladorusuario.aceptarInscripcion("mastropiero", "Almuerzo en el Real 1", "Almuerzo en el Real de San Carlos", 4, fechaI22); //puede llegar a romper
        
        }
        catch(InscripcionYaExisteException e) {
            System.out.print(e.getMessage());
        }
        catch(InscripcionCapacidadExcedidaException ee) {
            System.out.print(ee.getMessage());
        }
	}
}
