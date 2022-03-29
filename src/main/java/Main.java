import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {



    public static void main(String[] args) throws IOException {

        String fileName = System.getProperty("user.dir") + "\\src\\main\\resources\\airports.csv";

        int numberCols = 1;
        if (args.length > 0){
            try {
                numberCols = Integer.parseInt(args[0]);
            }catch (NumberFormatException e){
                System.err.println("Argument must be an integer");
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String input;
        if (numberCols == 0 || numberCols ==6 || numberCols == 7 || numberCols == 8 || numberCols == 9){
            input = sc.nextLine();
        }else {
            input = "\"" + sc.nextLine();
        }
        sc.close();

        long start = System.currentTimeMillis() ;
        ReadCsvWithBuffer csv = new ReadCsvWithBuffer();
        List<String[]> result =csv.readCsv(fileName,numberCols,input);
        long finish = System.currentTimeMillis();
        result.forEach(strings -> {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.print("\n");
        });


        System.out.println("Используемая память:" + ((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1048576));
        System.out.println  ("Количество найденных строк равно " + result.size());
        System.out.println("Общее время:" + (finish-start) + " миллисекунда");
    }
}