import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        //test.createFile();
        var tree = new Tree();
        BufferedReader br = new BufferedReader(new FileReader("1.csv"));
        try {
            String line = br.readLine();

            while (line != null) {
                var a = line.split(",");
                var from = a[0];
                var to = a[1];
                var factor = Double.parseDouble(a[2]);
                tree.addVertex(from, to, factor);
                line = br.readLine();
            }
        } finally {
            br.close();
        }

    }
}

