import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ReadCsv {

    List<String[]> readCsv(String fileName, int numberCols, String input) throws IOException;
}
