package com.cjl.io.nio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @ClassName ChatService
 * @Description Nio�ķ�������
 * @Author chen jingling
 * @Date 2020/9/17 8:30
 */
public class ChatService {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private long timeout = 2000;

    public ChatService(){
        try {
            serverSocketChannel = ServerSocketChannel.open();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
