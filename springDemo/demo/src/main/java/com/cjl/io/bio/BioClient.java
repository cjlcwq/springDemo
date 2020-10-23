package com.cjl.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName BioClient
 * @Description Bio�Ŀͻ���
 * @Author chen jingling
 * @Date 2020/9/16 9:46
 */
public class BioClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket("127.0.0.1", 9000);
            new Thread(new BioClientHandler(socket)).start();
            outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("������Ҫ���͵�����");
            while (true){
                String s = scanner.nextLine();
                if (s.trim().contains("by")){
                    break;
                }
                outputStream.write(s.getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            new BioClose().close(null, outputStream, socket);
        }
    }
}
