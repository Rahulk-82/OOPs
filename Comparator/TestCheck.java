package OOPs.Comparator;



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

        System.out.println("-----------------Natural Ordering Comparator-------------------");
        Collections.sort(list,new Employee());
        for(Employee e:list){
            System.out.println(e.getName());
        }

        System.out.println("-----------------Custom Comparator-------------------");

        List<EmployeeCustom> list1=new ArrayList<>();
        list1.add(new EmployeeCustom(10,"Rahul","SW",10000));
        list1.add(new EmployeeCustom(11,"Sanjay","SWE",20000));
        list1.add(new EmployeeCustom(12,"Ravi","FED",30000));
        list1.add(new EmployeeCustom(13,"Sandesh","SW",40000));
        list1.add(new EmployeeCustom(14,"Monesh","BED",10000));

        System.out.println("Salary Comparator");
        Collections.sort(list1,EmployeeCustom.salaryComparator);
        for(EmployeeCustom e:list1){
            System.out.println(e.getName());
        }

        System.out.println("Name Comparator");
        Collections.sort(list1,EmployeeCustom.nameComparator);
        for(EmployeeCustom e:list1){
            System.out.println(e.getName());
        }



        System.out.println("Salary Name Comparator");
        Collections.sort(list1,EmployeeCustom.SalaryNameComparator);
        for(EmployeeCustom e:list1){
            System.out.println(e.getName());
        }
    }
}
