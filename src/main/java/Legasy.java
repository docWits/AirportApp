import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Legasy {
    private static final long MAP_SIZE = 5242880;
    public static List<Airport> readCsvAsObject(Path fileName, int numberCols, String input) throws IOException {
        List<Airport> context = new ArrayList<>();

        try(BufferedReader br = Files.newBufferedReader(fileName)){
            String line;

            while ((line = br.readLine()) != null){
                String [] values = line.split(",");
                if (values[numberCols].startsWith("\""+ input)) {
                    context.add(new Airport(values[0],
                            values[1],
                            values[2],
                            values[3],
                            values[4],
                            values[5],
                            values[6],
                            values[7],
                            values[8],
                            values[9],
                            values[10],
                            values[11]));
                }
            }
        }
        context.sort(Comparator.comparing(Airport::getName));
        return context;
    }
    //        List<String> list = Files.lines(Paths.get(fileName))
//                .parallel()
//                .filter(s -> s.contains(input))
//                .sorted()
//                .collect(Collectors.toList());

    public static void memoryMappedFile(String fileName) throws FileNotFoundException {
        CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();

        long linesReadCount = 0;
        StringBuilder line = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile(new File(fileName),"r")){
            long position = 0;
            FileChannel fileChannel = file.getChannel();

            long length = fileChannel.size();
            long remaining = length - position;
            long bytestomap = (long) Math.min(MAP_SIZE, remaining);
            MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0L,bytestomap);
            CharBuffer decodedBuffer = decoder.decode(buffer);

            for(int i = 0; i < decodedBuffer.limit(); i++){
                char a = decodedBuffer.get();
                if(a == '\n'){
                    line = new StringBuilder();
                }else {
                    line.append(a);
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Airport> readCsvWithOpenCsv(String fileName, int numberCols, String input) throws FileNotFoundException {
        return new CsvToBeanBuilder<Airport>(new FileReader(fileName))
                .withType(Airport.class)
                .withSeparator(',')
                .withFilter(line -> line[numberCols].startsWith("\""+ input))
                .build().parse();
    }
}
