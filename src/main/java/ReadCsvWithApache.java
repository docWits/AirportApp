import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadCsvWithApache implements ReadCsv {

    // в обычном случае находит и фильтрует строки используя 13 мб за 102 мс
    // в худшем случае когда нужно отфильтровать все строки использует 7 мб за 79 мс
    @Override
    public List<String[]> readCsv(String fileName, int numberCols, String input) throws IOException {
        LineIterator it = FileUtils.lineIterator(new File(fileName));
        List<String[]> lines = new ArrayList<>();
        try {
            String[] list1;
            while (it.hasNext()){
                list1 = it.nextLine().split(",");
                if (list1[numberCols].contains("\""+ input)){
                    lines.add(list1);
                }
            }
        } finally {
            it.close();
        }
        lines.sort(Comparator.comparing(o -> o[numberCols]));
        return lines;
    }
}
