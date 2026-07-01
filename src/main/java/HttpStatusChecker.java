import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";

        HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            try {
                HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());

                if (response.statusCode() == 404) {
                    throw new IllegalArgumentException("Cat status not found " + code);

                } else if (response.statusCode() == 200) {
                    return url;

                } else {
                    throw new IllegalArgumentException("Something went wrong on the http.cat server.");
                }

            } catch (Exception e) {
                throw new Exception("Error while checking HTTP status", e);
            }
        }
    }

