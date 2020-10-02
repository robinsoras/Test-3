package no.kristiania.test3;


import java.io.IOException;
import java.net.Socket;

public class HttpClient {

    public HttpClient(String hostname, int port, String requestTarget) throws IOException {
        Socket socket = new Socket(hostname, port);

        String request = "GET " + requestTarget + " HTTP/1.1\r\n" +
                "Host: " + hostname + "\r\n\r\n";
        socket.getOutputStream().write(request.getBytes());

        int c;
        while ((c = socket.getInputStream().read()) != -1) {
            System.out.print((char)c);
        }
    }

    public static void main(String[] args) throws IOException {
        new HttpClient("urlecho.appspot.com", 80, "/echo?status=200&body=Hello%20world!");
    }
}
