import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadCsvWithUniVosity implements ReadCsv {

    // Быстрый, но затратный по памяти вариант
    // в обычном случае находит и фильтрует строки используя 26 мб за 92 мс
    // в худшем случае, когда нужно отфильтравать все строки использует 36мб за 75мс
    @Override
    public List<String[]> readCsv(String fileName, int numberCols, String input) throws IOException {
        List<String[]> lines = new ArrayList<>();
        CsvParserSettings settings = new CsvParserSettings();
        CsvParser parser = new CsvParser(settings);
        String[] row;
        parser.beginParsing(new File(fileName));
        while ((row = parser.parseNext()) != null){
            if (row[numberCols].startsWith(input)) {
                lines.add(row);
            }
        }
        lines.sort(Comparator.comparing(o -> o[numberCols]));
        return lines;
    }
}
