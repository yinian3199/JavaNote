package com.example.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lixiang
 * @date 2021/4/11 15:55
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3199);
        new Thread(()->{
            while (true){
                //阻塞方法获取新的连接
                try {
                    Socket socket = serverSocket.accept();
                    //每一个新的连接都创建一个新的线程，负责读取数据
                    new Thread(()->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            //按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1){
                                System.out.println(new String(data,0,len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
