package com.example.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lixiang
 * @date 2021/4/12 21:50
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {

        //serverSelector负责轮询是否有新的连接，服务端监测到新连接之后，不在创建一个新的线程
        //而是直接将新连接绑定到clientSelector上，这样就不用IO模型中大量的white循环在死等
        Selector serverSelector = Selector.open();
        //clientSelector负责轮询连接是否有数据可读
        Selector clientSelector = Selector.open();

        new Thread(()->{
            try {
                //对应IO编程中服务端启动
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(3199));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);
                while (true){
                    //监测是否有新的连接，这里的1是指阻塞的时间为1ms
                    if (serverSelector.select(1)>0){
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while (keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if (key.isAcceptable()){
                                //每来一个新连接，不需要创建一个线程，而是直接注册到clientSelector
                                try {
                                    SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector,SelectionKey.OP_READ);
                                }finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try{
                while (true){
                    //批量轮询是否有哪些连接有数据可读，这里的1是指阻塞的时间为1ms
                    if (clientSelector.select(1)>0){
                        Set<SelectionKey> set = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();
                        while (keyIterator.hasNext()){
                            SelectionKey key = keyIterator.next();
                            if (key.isReadable()){
                                try {
                                    SocketChannel clientChannel = (SocketChannel) key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    //面向Buffer
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                }finally {
                                    keyIterator.remove();
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }
}
