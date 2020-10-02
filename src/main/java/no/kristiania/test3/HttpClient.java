package no.kristiania.test3;


import java.io.IOException;
import java.net.Socket;

public class HttpClient {

    private int statusCode = 200;

    public HttpClient(String hostname, int port, String requestTarget) throws IOException {
        Socket socket = new Socket(hostname, port);

        String request = "GET " + requestTarget + " HTTP/1.1\r\n" +
                "Host: " + hostname + "\r\n\r\n";
        socket.getOutputStream().write(request.getBytes());

        StringBuilder line = new StringBuilder();
        int c;
        while ((c = socket.getInputStream().read()) != -1) {
            if (c == '\n') break;
            line.append((char)c);
        }
        System.out.println(line);
        String[] parts = line.toString().split(" ");
        statusCode = Integer.parseInt(parts[1]);
    }

    public static void main(String[] args) throws IOException {
        new HttpClient("urlecho.appspot.com", 80, "/echo?status=200&body=Hello%20world!");
    }

    public int getStatusCode() {
        return statusCode;
    }

}
