import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        //BÀI 1
        System.out.println("=====================BÀI 1=====================");
        //Tạo Supplier đọc dữ liệu từ file, trả về List
        import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FileDataReader {
    public static Supplier<List<String>> readLinesFromFile(String filePath) {
        return () -> {
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return lines;
        };
    }

    public static void main(String[] args) {
        String filePath = "example.txt"; 
        Supplier<List<String>> fileDataSupplier = readLinesFromFile(filePath);
        List<String> lines = fileDataSupplier.get();
        for (String line : lines) {
            System.out.println(line);
        }
    }
}


        // Tạo List từ Supplier


        //BÀI 2
        System.out.println("=====================BÀI 2=====================");
        //Tạo Consumer


        // Sử dụng Consumer


        //BÀI 3
        System.out.println("=====================BÀI 3=====================");
        //Tạo Function


        //Sử dụng Function để biến đổi dữ liệu


        //BÀI 4
        System.out.println("=====================BÀI 4=====================");
        //Tạo Predicate


        //Sử dụng Predicate trên để lọc dữ liệu


        //BÀI 5
        System.out.println("=====================BÀI 5=====================");
        //Tạo Predicate


        //Sử dụng Operator trên để xử lý dữ liệu


        //Tạo Comparator


        //Sử dụng Comparator để sắp xếp danh sách sinh viên

        
    }
}

class Student {
    String name;
    int age;
    double score;

}
