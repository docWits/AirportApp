import java.io.IOException;
import java.util.List;

public interface ReadCsv {

    List<String[]>readCsv(String fileName, int numberCols, String input) throws IOException;

    default void addString(List<String[]> lines, String input, int numberCols, String[] list1){
        if (list1[numberCols].contains("\"" + input)) {
            lines.add(list1);
        }
    }
}
