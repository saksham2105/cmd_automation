import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        String CMD = "C:\\Windows\\System32\\cmd.exe";
        ProcessBuilder processBuilder = new ProcessBuilder(CMD);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        InputStream is = process.getInputStream();
        Scanner scan = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        OutputStream out = process.getOutputStream();
        String line;
        try {
            while (!scan.nextLine().equals("exit")) {
                System.out.println("Enter your query : ");
                String input = scan.nextLine();
                input += "\n";
                out.write(input.getBytes());
                out.flush();
                line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                    if (line == null || line.length() == 0) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
