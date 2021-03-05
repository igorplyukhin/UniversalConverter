import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;

public class test {
    private static final String alph = "абвгдеёжзийклмнопрстуфхцчщшэьъюя";
    private static final Random r = new Random();
    private static final HashMap<Integer, String> units = GenerateUnits();

    public static void createFile() throws IOException {
        var fileName = "123.csv";
        var len = 10;
        var path = Paths.get(fileName);
        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
            Files.delete(path);
            Files.createFile(path);
        }
        FileWriter fw = new FileWriter(fileName);
        for (var i=0; i < 1000000; i++){
            var s = String.format("%s,%s,%d\n", units.get(r.nextInt(200000)), units.get(r.nextInt(200000)),
                    r.nextInt(10000));
            fw.write(s);
        }
        fw.close();
    }

    private static HashMap<Integer, String> GenerateUnits(){
        var m = new HashMap<Integer, String>();
        for (var i = 0 ; i < 200000; i++){
            m.put(i, GetRandomString(2));
        }
        return m;
    }
    private  static String GetRandomString(Integer length){
        var s = new StringBuilder();
        for (var i=0; i<length;i++){
            s.append(alph.charAt(r.nextInt(alph.length())));
        }
        return s.toString();
    }
}
