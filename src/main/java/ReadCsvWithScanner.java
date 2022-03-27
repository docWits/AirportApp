import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ReadCsvWithScanner implements ReadCsv{

    //  в обычном случае находит и фильтрует строки используя 7 мб за 109 мс
    // в худшем случае когда нужно отфильтровать все строки использует 20 мб за 126 мс
    @Override
    public List<String[]> readCsv(String fileName, int numberCols, String input) {
        List<String[]> lines = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(fileName);
             Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8)) {
            String line;
            String[] list1;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                list1 = line.split(",");
                if (list1[numberCols].startsWith("\""+ input)){
                    lines.add(list1);
                }
            }
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.sort(Comparator.comparing(o -> o[numberCols]));
        return lines;
    }
}
