package com.haut.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xxx_xx
 * @date 2018/1/12
 */
public class TCPServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while (!((info = bufferedReader.readLine()) == null)) {
                System.out.println(info);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
