import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

class Result {
    public static int getTotalGoals(String team, int year) {
        int totalGoals = 0;
        int currentPage = 1;
        int totalPages;

        // Recorrer todas las páginas de resultados
        do {
            // Construye las URLs para los equipos local (team1) y visitante (team2)
            String url1 = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team1=" + team + "&page=" + currentPage;
            String url2 = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&team2=" + team + "&page=" + currentPage;

            // Suma los goles en la página actual de ambos equipos y agrega al total
            int goalsInPage = getTotalGoalsInPage(url1, team) + getTotalGoalsInPage(url2, team);
            totalGoals += goalsInPage;

            currentPage++;
            totalPages = getTotalPages(url1);
            totalPages = getTotalPages(url2);
        } while (currentPage <= totalPages);

        return totalGoals;
    }

    static int getTotalGoalsInPage(String url, String team) {
        int totalGoals = 0;
        try {
            // Establece una conexión HTTP para obtener la página de resultados
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = connection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Busca los campos de goles para el equipo especificado
                    if (line.contains(team)) {
                        // Divide la línea en campos y suma los goles
                        String[] fields = line.split("\"team1goals\":|\"team2goals\":");
                        for (String field : fields) {
                            if (!field.trim().isEmpty()) {
                                totalGoals += Integer.parseInt(field.trim());
                            }
                        }
                    }
                }
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalGoals;
    }

    static int getTotalPages(String url) {
        int totalPages = 0;
        try {
             // Establece una conexión HTTP para obtener el número total de páginas
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = connection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Busca el campo "total_pages" en la respuesta JSON
                    if (line.contains("\"total_pages\":")) {
                        // Extrae y convierte el valor en el campo
                        totalPages = Integer.parseInt(line.split(":")[1].trim().replaceAll(",", ""));
                    }
                }
                scanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalPages;
    }
}

