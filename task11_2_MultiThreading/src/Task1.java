import java.io.File;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class Task1 {
    private String currentDir;
    private ReentrantLock lock = new ReentrantLock();

    public void printDirectories(String dirName) throws IOException {
        lock.lock();
        try {
            this.currentDir = dirName;
            System.out.println("Current dir name is " + dirName);
            File f = new File(currentDir);

            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.print("directory:");
                } else {
                    System.out.print("     file:");
                }
                System.out.println(file.getCanonicalPath());
            }
        } finally {
           lock.unlock();
        }
    }
}
