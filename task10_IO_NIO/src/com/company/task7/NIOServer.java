package com.company.task7;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {


    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel socket = ServerSocketChannel.open();
        InetSocketAddress addr = new InetSocketAddress("localhost", 7777);
        socket.bind(addr);
        socket.configureBlocking(false);

        int ops = socket.validOps();
        SelectionKey selectKy = socket.register(selector, ops, null);
        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = keys.iterator();

            while (iterator.hasNext()) {
                SelectionKey myKey = iterator.next();
                if (myKey.isAcceptable()) {
                    SocketChannel client = socket.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                } else if (myKey.isReadable()) {

                    SocketChannel client = (SocketChannel) myKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(256);
                    client.read(buffer);
                    String result = new String(buffer.array()).trim();
                    client.write(ByteBuffer.wrap(result.getBytes()));
                    if (result.equals("name")) {
                        client.close();
                    }
                }
                iterator.remove();
            }
        }
    }

}
