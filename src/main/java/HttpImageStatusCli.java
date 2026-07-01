import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    public void askStatus() {
        System.out.println("Enter HTTP status code: ");

        int code = 0;

        try {
            String input = bufferedReader.readLine();
            code = Integer.parseInt(input);

            downloader.downloadStatusImage(code);


            System.out.println("Image downloaded successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
        } catch (IOException e) {
            System.out.println("Error reading input from console: " + e.getMessage());
        } catch (HttpImageNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error:" + e.getMessage());
        }
    }
}
