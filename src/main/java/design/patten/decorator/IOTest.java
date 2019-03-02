package design.patten.decorator;

import java.io.*;


public class IOTest {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("hello.txt");
        InputStream is = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(is);
    }
}
