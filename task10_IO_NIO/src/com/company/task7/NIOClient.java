package com.company.task7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class NIOClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        InetSocketAddress addr = new InetSocketAddress("localhost", 7777);
        SocketChannel client = SocketChannel.open(addr);
        List<String> messages = new ArrayList<>();
        messages.add("mean");
        messages.add("nmea");
        messages.add("eman");
        messages.add("mane");
        messages.add("name");

        for (String message : messages) {

            byte[] messageBytes = new String(message).getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(messageBytes);
            client.write(buffer);
            client.read(buffer);
            String response = new String(buffer.array()).trim();
            System.out.println("response=" + response);
            buffer.clear();
            Thread.sleep(2000);
        }
        client.close();
    }
}
