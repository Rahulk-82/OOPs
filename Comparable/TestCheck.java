package OOPs.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCheck {
    public static void main(String [] args){
        List<Employee> list=new ArrayList<>();
        list.add(new Employee(10,"Rahul","SW",10000));
        list.add(new Employee(11,"Sanjay","SWE",20000));
        list.add(new Employee(12,"Ravi","FED",30000));
        list.add(new Employee(13,"Sandesh","SW",40000));
        list.add(new Employee(14,"Monesh","BED",10000));

        Collections.sort(list);
        for(Employee e:list){
            System.out.println(e.getName());
        }

    }
}
