package com.company.Task6;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class StringNIOBuffer {
    private FileChannel inChannel;
    private ByteBuffer byteBuffer;

    public StringNIOBuffer(FileChannel inChannel) {
        this.inChannel = inChannel;
        this.byteBuffer = ByteBuffer.allocate(1024);
    }

    public String read() throws IOException {
        int bytesRead = inChannel.read(this.byteBuffer);
        String text = "";
        byteBuffer.flip();

        while(byteBuffer.hasRemaining()){
            text += (char) byteBuffer.get();
        }
        return text;
    }

    public void write(String str) throws IOException {
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        inChannel.write(byteBuffer);

    }
    public void close() throws IOException {
        inChannel.close();
    }

}
