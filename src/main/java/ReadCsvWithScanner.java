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
    public List<String[]> readCsv(String fileName, int numberCols, String input) throws IOException {
        List<String[]> lines = new ArrayList<>(8000);
        try (FileInputStream inputStream = new FileInputStream(fileName);
             Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8)) {
            while (sc.hasNext()) {
                String[] list1 = sc.nextLine().split(",");
                if (list1[numberCols].startsWith(input)) {
                    lines.add(list1);
                }
            }
        }
        lines.sort(Comparator.comparing(o -> o[numberCols]));
        return lines;
    }
}
