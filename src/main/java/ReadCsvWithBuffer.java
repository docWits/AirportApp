import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ReadCsvWithBuffer implements ReadCsv{


    @Override
    public List<String[]> readCsv(String fileName, int numberCols, String input) throws IOException {

        //System.out.println(getClass().getResource("/").getPath()+fileName);
        //fileName = getClass().getResource("/").getPath() + fileName;
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
