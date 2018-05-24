import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            // ip = "10.5.11.100";
            System.out.println("opretter forbindelse...");
            Socket socket = new Socket(ip, 5555);
            System.out.println("har oprettet forbindelse.");
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("hello");
            InputStream inputStream = socket.getInputStream();

            Scanner scanner = new Scanner(inputStream);
            String message = scanner.nextLine();
            System.out.println(message);

            System.out.println(ip);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
