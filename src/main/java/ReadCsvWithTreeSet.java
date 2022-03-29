import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class ReadCsvWithTreeSet {

    public TreeMap<Integer,Airport> readCsv(String fileName, int numberCols, String input) throws IOException {
        TreeMap<Integer, Airport> lines = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName), 1024)) {
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                String[] list1 = tmp.split(",");
                if (list1[numberCols].startsWith(input)) {
                    lines.put(Integer.parseInt(list1[0]), new Airport(list1[0],
                            list1[1],
                            list1[2],
                            list1[3],
                            list1[4],
                            list1[5],
                            list1[6],
                            list1[7],
                            list1[8],
                            list1[9],
                            list1[10],
                            list1[11]));
                }
            }
        }
        return lines;
    }

}
