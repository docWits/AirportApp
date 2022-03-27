import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadCsvWithBuffer implements ReadCsv{

    // в обычном случае находит и фильтрует строки используя 13 мб за 61 мс
    // в худшем случае когда нужно отфильтровать все строки использует 7 мб за 68 мс
    @Override
    public List<String[]> readCsv(String fileName, int numberCols, String input) throws IOException {
        List<String[]> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName),8192 * 16);
        String tmp;
        String[] list1;
        while ((tmp = reader.readLine()) != null){
            list1 = tmp.split(",");
            if (list1[numberCols].contains("\""+ input)){
                lines.add(list1);
            }
        }
        reader.close();
        //lines.sort(Comparator.comparing(o -> o[numberCols]));
        for(int i = 0; i < lines.size(); i++){

        }
        return lines;
    }
}
