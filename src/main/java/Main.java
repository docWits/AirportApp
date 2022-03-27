import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis() ;
        String fileName = "src/main/resources/airports.csv";

        int numberCols = 1;
        String input = "";

        ReadCsvWithBuffer csv = new ReadCsvWithBuffer();
        ReadCsvWithScanner csv1 = new ReadCsvWithScanner();
        ReadCsvWithUniVosity csv2 = new ReadCsvWithUniVosity();

        //List<String[]> result = csv1.readCsv(fileName,numberCols,input);
        List<String[]> result =csv.readCsv(fileName,numberCols,input);
        //List<String[]> result = csv2.readCsv(fileName,numberCols,input);
        long finish = System.currentTimeMillis();

        result.forEach(strings -> {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.print("\n");
        });

        System.out.println("Используемая память:" + ((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1048576));
        System.out.println("Количество найденных строк равно " + result.size());
        System.out.println("Общее время:" + (finish-start) + " миллисекунда");
    }
}