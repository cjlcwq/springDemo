package com.cjl.map;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class HashMapTest {
    public static void main(String[] args) throws IOException {
//        //读取文件并获取到通道
//        FileInputStream fl = new FileInputStream("D:\\gonghzong\\test.txt");
//        FileChannel channel = fl.getChannel();
//        //创建缓冲区
//        ByteBuffer allocate = ByteBuffer.allocate(1024);
//        //将通道的数据写入到缓冲区
//        int read = channel.read(allocate);
//        System.out.println(read);

        //获取一个通道到指定文件
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\gonghzong\\test.txt");
        FileChannel channel = fileOutputStream.getChannel();
        String str = "someString nio";
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        allocate.put(str.getBytes());
        allocate.flip();
        channel.write(allocate);

    }
}
