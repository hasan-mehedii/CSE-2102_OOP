import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatApplication {
    public static void main(String[] args) throws IOException {
        if (args.length > 0 && args[0].equalsIgnoreCase("server")) {
            startServer();
        } else if (args.length > 0 && args[0].equalsIgnoreCase("client")) {
            startClient();
        } else {
            System.out.println("Usage: java ChatApplication <server/client>");
        }
    }

    // Start the server
    public static void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is waiting for a client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        new Thread(new MessageReceiver(socket)).start();
        new Thread(new MessageSender(socket)).start();
    }

    // Start the client
    public static void startClient() throws IOException {
        Socket socket = new Socket("localhost", 12345);
        System.out.println("Connected to server!");

        new Thread(new MessageReceiver(socket)).start();
        new Thread(new MessageSender(socket)).start();
    }
}

// Handles sending messages
class MessageSender implements Runnable {
    private PrintWriter out;
    private Scanner scanner;

    public MessageSender(Socket socket) throws IOException {
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            String message = scanner.nextLine();
            out.println(message);
        }
    }
}

// Handles receiving messages
class MessageReceiver implements Runnable {
    private BufferedReader in;

    public MessageReceiver(Socket socket) throws IOException {
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
