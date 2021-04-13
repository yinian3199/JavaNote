package com.example.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author lixiang
 * @date 2021/4/11 14:29
 */
public class BIOClient {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1",3199);
                while (true){
                    socket.getOutputStream().write((new Date()+"hello: server").getBytes());
                    Thread.sleep(2000);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
