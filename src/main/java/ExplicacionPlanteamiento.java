//            1. API REST: Total de goles por equipo
//            En este desafío, la API REST contiene información sobre partidos de fútbol. La API proporcionada permite consultar partidos por equipos y año. Su tarea es obtener el número total de goles marcados por un equipo determinado en un año determinado.
//
//
//
//            Para acceder a una colección de coincidencias, realice solicitudes GET a
//
//            https://jsonmock.hackerrank.com/api/football_matches?year=<año>&team1=<equipo>&page=<página>
//
//            https://jsonmock.hackerrank.com/api/football_matches?year=<año>&team2=<equipo>&page=<página>
//
//            donde <año> es el año de la competencia, <equipo> es el nombre del equipo y <página> es la página de resultados a solicitar. Los resultados pueden dividirse en varias páginas. Las páginas están numeradas a partir del 1.
//
//
//
//            Tenga en cuenta que las dos URL anteriores son diferentes. La primera URL especifica el parámetro equipo1 (que indica el equipo local), mientras que la segunda URL especifica el parámetro equipo2 (que indica el equipo visitante). Por lo tanto, para obtener todos los partidos en los que jugó un equipo en particular, debe recuperar los partidos en los que el equipo fue el equipo local y el equipo visitante.
//
//
//
//            Por ejemplo, una solicitud GET para
//
//            https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1=Barcelona&page=2
//
//            devuelve datos asociados a partidos del año 2011, donde el equipo 1 (el equipo de casa) era el Barcelona, ​​en la segunda página de los resultados.
//
//
//
//            De manera similar, una solicitud GET para
//
//            https://jsonmock.hackerrank.com/api/football_matches?year=2011&team2=Barcelona&page=1
//
//            devuelve datos asociados a partidos del año 2011 donde el equipo 2 (el equipo visitante) fue el Barcelona, ​​en la primera página de los resultados.
//
//
//
//            La respuesta a dicha solicitud es un JSON con los siguientes 5 campos:
//
//            page: La página actual de los resultados.
//
//            per_page: El número máximo de coincidencias devueltas por página.
//
//            total: El número total de coincidencias en todas las páginas de los resultados.
//
//            total_pages: El número total de páginas con resultados.
//
//            data: una matriz de objetos que contiene información de coincidencias en la página solicitada.
//
//
//
//            Cada registro de coincidencia tiene varios campos, pero en esta tarea solo son relevantes los 4 siguientes:
//
//            team1: una cadena que indica el nombre del primer equipo en el partido
//
//            team2: una cadena que indica el nombre del segundo equipo en el partido
//
//            team1goals: una cadena que indica el número de goles marcados por team1 en el partido
//
//            team2goals: una cadena que indica el número de goles marcados por team2 en el partido
//
//
//
//            Función descriptiva
//
//            Complete la función getTotalGoals en el editor a continuación.
//
//
//
//            getTotalGoals tiene los siguientes parámetros:
//
//                equipo de cuerdas : el nombre del equipo
//
//                int year : el año de la competencia
//
//
//
//            La función debe devolver un número entero que indique el número total de goles marcados por el equipo dado en todos los partidos del año dado en el que jugó el equipo.
//
//
//
//            Formato de entrada para pruebas personalizadas
//            Caso de muestra 0
//            Entrada de muestra para pruebas personalizadas
//
//            Barcelona
//            2011
//            Salida de muestra
//
//            35
//            Explicación
//
//            El equipo es Barcelona y el año es 2011. Cuando buscamos todos los partidos que jugó Barcelona en el año 2011, encontramos que marcaron un total de 35 goles, que es la respuesta requerida.
//
