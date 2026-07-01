import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class HttpStatusImageDownloader {

    public String downloadStatusImage(int code) throws Exception {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String url;

        try {
            url = httpStatusChecker.getStatusImage(code);
        } catch (Exception e) {
            throw new IllegalArgumentException("file not found or server unavailable: " + e.getMessage());
        }

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());

            Path outPutPath = Path.of(code + ".jpg");
            Files.write(outPutPath, response.body());

        System.out.println("Image successfully downloaded: " + outPutPath.toAbsolutePath());

        return url;
    }
}

