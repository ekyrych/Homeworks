package task2;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class StringNIOBuffer {
    private FileChannel inChannel;
    private BlockingQueue<ByteBuffer> queue;

    public StringNIOBuffer(FileChannel inChannel) throws InterruptedException {
        this.inChannel = inChannel;
        this.queue = new LinkedBlockingQueue<>();
        this.queue.put(ByteBuffer.allocate(1024));
    }

    public String read() throws IOException, InterruptedException {
        ByteBuffer byteBuffer = this.queue.take();
        int bytesRead = inChannel.read(byteBuffer);
        String text = "";
        byteBuffer.flip();

        while(byteBuffer.hasRemaining()){
            text += (char) byteBuffer.get();
        }
        this.queue.put(byteBuffer);
        return text;
    }

    public void write(String str) throws IOException, InterruptedException {
        ByteBuffer byteBuffer = this.queue.take();
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        inChannel.write(byteBuffer);
        this.queue.put(byteBuffer);

    }
    public void close() throws IOException {
        inChannel.close();
    }

}

