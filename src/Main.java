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
        Supplier<List<Integer>> numberSupplier = () -> {
            List<Integer> numbers = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    for (String part : parts) {
                        numbers.add(Integer.parseInt(part));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return numbers;
        };

        Supplier<List<String>> stringSupplier = () -> {
            List<String> strings = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("strings.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    strings.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return strings;
        };

        Supplier<List<Student>> studentSupplier = () -> {
            List<Student> students = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] arr = line.split(",");
                    Student s = new Student();
                    s.name = arr[0];
                    s.age = Integer.parseInt(arr[1]);
                    s.score = Double.parseDouble(arr[2]);
                    students.add(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return students;
        };
        // Tạo List từ Supplier
        List<Integer> listNummber = numberSupplier.get();
        List<String> listString = stringSupplier.get();
        List<Student> listStudent = studentSupplier.get();

        //BÀI 2
        System.out.println("=====================BÀI 2=====================");
        //Tạo Consumer
        Consumer numberConsumer = System.out::println;
        Consumer stringConsumer = System.out::println;
        Consumer studentConsumer = System.out::println;

        // Sử dụng Consumer
        listNummber.stream().limit(3).forEach(numberConsumer);
        listString.stream().limit(3).forEach(stringConsumer);
        listStudent.stream().limit(3).forEach(studentConsumer);

        //BÀI 3
        System.out.println("=====================BÀI 3=====================");
        //Tạo Function
        Function<Integer, Double> numberFunction = Math::sqrt;
        Function<String, Character> stringFunction = str -> str.charAt(0);
        Function<Student, Integer> studentFunction = student -> (int) student.score;

        //Sử dụng Function để biến đổi dữ liệu
        listNummber.stream().map(numberFunction).limit(3).forEach(numberConsumer);
        listString.stream().map(stringFunction).limit(3).forEach(stringConsumer);
        listStudent.stream().map(studentFunction).limit(3).forEach(studentConsumer);

        //BÀI 4
        System.out.println("=====================BÀI 4=====================");
        //Tạo Predicate
        Predicate<Integer> predicateNumber = number -> number % 2 == 0;
        Predicate<String> predicateString = str -> str.length() > 30;
        Predicate<Student> predicateStudent = student -> student.score >= 9;

        //Sử dụng Predicate trên để lọc dữ liệu
        listNummber.stream().filter(predicateNumber).limit(3).forEach(numberConsumer);
        listString.stream().filter(predicateString).limit(3).forEach(stringConsumer);
        listStudent.stream().filter(predicateStudent).limit(3).forEach(studentConsumer);

        //BÀI 5
        System.out.println("=====================BÀI 5=====================");
        //Tạo Predicate
        BinaryOperator<Integer> operatorNumber = Integer::sum;
        UnaryOperator<String> operatorString = s -> s.substring(0, 1);

        //Sử dụng Operator trên để xử lý dữ liệu
        listNummber.stream().reduce(operatorNumber).ifPresent(System.out::println);
        listString.stream().map(operatorString).limit(15).forEach(System.out::print);

        //Tạo Comparator
        Comparator<Student> comparator = (s1, s2) -> s2.age - s1.age;
        //Sử dụng Comparator để sắp xếp danh sách sinh viên
        listStudent.stream().sorted(comparator).limit(4).forEach(studentConsumer);

    }
}

class Student {
    String name;
    int age;
    double score;

    @Override
    public String toString() {
        return name + "," + age + "," + score;
    }
}