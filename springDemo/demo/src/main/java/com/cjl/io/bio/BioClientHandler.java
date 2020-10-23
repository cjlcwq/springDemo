package com.cjl.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @ClassName BioClientHandler
 * @Description TODO
 * @Author chen jingling
 * @Date 2020/9/16 9:31
 */
public class BioClientHandler implements Runnable {

    private Socket socket;

    public BioClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            int count = 0;
            byte[] bytes = new byte[1024];
            while ((count = inputStream.read(bytes)) != -1){
                System.out.println("\n�յ���������Ϣ��  "+new String(bytes,0,count,"utf-8"));
                System.out.print("������Ҫ���͵���Ϣ��");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
