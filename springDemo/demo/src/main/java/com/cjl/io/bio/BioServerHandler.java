package com.cjl.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName BioServerHandler
 * @Description TODO
 * @Author chen jingling
 * @Date 2020/9/16 9:13
 */
public class BioServerHandler implements Runnable {

    private Socket socket;

    public BioServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            int count = 0;
            String content = null;
            byte[] bytes = new byte[1024];
            while ((count = inputStream.read(bytes))!=-1){
                String line=new String(bytes,0,count,"utf-8");
                System.out.println(line);
                content=line.trim().equalsIgnoreCase("SJ")?new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()): "�㷢��ɶ��";
                outputStream.write(content.getBytes());
                outputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            new BioClose().close(inputStream, outputStream, socket);
        }
    }
}
