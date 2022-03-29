import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadCsvWithBuffer implements ReadCsv{


    @Override
    public List<String[]> readCsv(String fileName, int numberCols, String input) throws IOException {

        List<String[]> lines = new ArrayList<>(8000);
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName), 1024)) {
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                String[] list1 = tmp.split(",");
                if (list1[numberCols].startsWith(input)) {
                    lines.add(list1);
               }
            }
        }
        lines.sort(Comparator.comparing(o -> o[numberCols]));
        return lines;
    }
}
