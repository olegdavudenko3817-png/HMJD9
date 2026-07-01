import java.util.Scanner;

public class Main {

    private static final HttpStatusChecker checker = new HttpStatusChecker();
    private static final HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
    private static final HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();

    public static void main(String[] args) throws Exception {

        try {
            String imageUrl1 = checker.getStatusImage(200);
            System.out.println("Test 1 passed: " + imageUrl1);
        } catch (Exception e) {
            System.out.println("Test 1 failed: " + e.getMessage());
        }

        try {
            System.out.println("Try code 10000...");
            checker.getStatusImage(10000);

            System.out.println("Error: Method return url ");
        } catch (Exception e) {
            System.out.println("Test 2 passed:" + e.getMessage());
        }

        System.out.println("=============================================");

        try {
            System.out.println("Launch Test 1: download cat 200...");

            httpStatusImageDownloader.downloadStatusImage(200);
            System.out.println("Test 1 successfully completed! " +
                    " Check the project folder—a file named 200.jpg should appear there. ");
        } catch (Exception e) {
            System.out.println("Test 1 failed, but code 200 is exists " + e.getMessage());
        }

        System.out.println("------------------------------------");

        try {
            System.out.println("Launch Test 2: try download code 10000...");

            httpStatusImageDownloader.downloadStatusImage(10000);
            System.out.println("Test 2 failed! Method don't input error for code 10000");
        } catch (Exception e) {
            System.out.println("Test 2 successfully completed! Exception catch: " + e.getMessage());
        }

        System.out.println("=============================================");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println(" [ HTTP CAT Downloader CLI ] ");

        while (running == true) {
            httpImageStatusCli.askStatus();

            System.out.println("\n Do you want to check another status ? (yes/no): ");
            String answer = scanner.nextLine().toLowerCase().trim();

            if (answer.equals("no") || answer.equals("n")) {
                running = false;
                System.out.println("Goodbye!");
            }
        }
        scanner.close();

    }
}
