import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {

    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<Void> response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());

        if (response.statusCode() == 404) {
            throw new HttpImageNotFoundException("There is no image for HTTP status: " + code);

        }
        return url;
    }
}


