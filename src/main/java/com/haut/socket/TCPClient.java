package com.haut.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author xxx_xx
 * @date 2018/1/12
 */
public class TCPClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            OutputStream outputStream = socket.getOutputStream();
            String info = "user:Tom age:12";
            outputStream.write(info.getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
