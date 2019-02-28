import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Task1 example = new Task1();
        Thread thread1 = new Thread(() -> {
            try {
                example.printDirectories(".");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                example.printDirectories("../");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();


    }
}
