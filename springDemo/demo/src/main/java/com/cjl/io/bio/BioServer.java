package com.cjl.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName BioServer
 * @Description Bio�ķ�������
 * @Author chen jingling
 * @Date 2020/9/15 22:00
 */
public class BioServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(9000);
            TimeServerHandlerExecutorPool timeServerHandlerExecutorPool = new TimeServerHandlerExecutorPool(50, 1000);
            while (true){
                //���������
                Socket socket = serverSocket.accept();
                System.out.println("�ͻ���"+socket.getRemoteSocketAddress().toString()+"��������");
                timeServerHandlerExecutorPool.execute(new BioServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
