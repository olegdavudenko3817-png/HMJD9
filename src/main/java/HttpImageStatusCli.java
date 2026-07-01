import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {

    public void askStatus() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter HTTP status code: ");

        int code = 0;

        try {
            String input = bufferedReader.readLine();
            code = Integer.parseInt(input);

            HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
            httpStatusImageDownloader.downloadStatusImage(code);

            System.out.println("Image downloaded successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
        } catch (IOException e) {
            System.out.println("Error reading input from console: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("There is not imgae for HTTP status " + code);
        }
    }
}
