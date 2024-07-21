package OOPs.StreamExamples;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static  void main(String []args){
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32);

        // Elements stating with 1.
        List<String> result1=myList.stream().map(s->s+"").filter(s->s.startsWith("1")).collect(Collectors.toList());
        System.out.println(result1);

        //give duplicate element
        HashSet<Integer> set=new HashSet<>();
        List<Integer> i=myList.stream().filter(n->!set.add(n)).collect(Collectors.toList());

        // first element in list
        myList.stream().findFirst().ifPresent(System.out::println);

        // max elements in array
        int s=myList.stream().collect(Collectors.maxBy((o1, o2)->(int)(o1.intValue()-o2.intValue()))).get();
        System.out.println(s);

        // Find second largest element from array

        Optional<Integer> element=myList.stream().sorted(Comparator.reverseOrder()).limit(3).skip(2).findFirst();
        System.out.println("Second largest elements : "+element.get());

        //get duplicate elements

        List<Integer> po=myList.stream().map(e->e+"").collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(p->p.getValue()!=1).map(r->r.getKey()).map(Integer::valueOf).collect(Collectors.toList());
        System.out.print("Duplicate value:");
        System.out.println(po);
        //get non-repeting element in array
        List<Integer> result3=myList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1L)
                .map(r->r.getKey())
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(result3);

        //convert array to stream.
        Arrays.stream(new int []{1,2,3,4,5}).map(r->r*r).forEach(System.out::println);



        // Stream API with List of Objects

        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));


        //employee whose name start with A.
        list.stream().filter(e->e.getFirstName().startsWith("A")).forEach(System.out::println);

        // Group The Student By Department Names
        Map<String,List<Student>> map=list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        System.out.println("Group The Student By Department Names");
        System.out.println(map);

        //total Count of student
        Long count=list.stream().count();
        System.out.println("total Count of student");
        System.out.println(count);

        // Max age of student
        Optional<Student> age=list.stream().max(Comparator.comparing(Student::getAge));
        System.out.println("Max age of student");
        System.out.println(age);

        //All department name
        List<String> names=list.stream().map(p->p.getDepartmantName()).distinct().toList();
        System.out.println("All department name");
        System.out.println(names);

        // Find count of student in each department
        Map<String, Long>map1=list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()));
        System.out.println("Find count of student in each department");
        System.out.println(map1);

        //Average age of male and female
        Map<String,Double> map3=list.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge)));
        System.out.println("Average age of male and female");
        System.out.println(map3);

        //Department with max students
        Map.Entry<String,Long> deaprment=list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Department with max students");
        System.out.println(deaprment);


        //generate fibonacchi series:
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(x -> System.out.println("{" + x[0] + "," + x[1] + "}"));
    }

}
