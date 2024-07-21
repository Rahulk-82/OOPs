package OOPs.Comparator;

import java.util.Comparator;

public class EmployeeCustom {
    int id;
    String name;
    String department;
    int salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public EmployeeCustom(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public static Comparator<EmployeeCustom> nameComparator=new Comparator<EmployeeCustom>() {
        @Override
        public int compare(EmployeeCustom o1, EmployeeCustom o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<EmployeeCustom> salaryComparator=new Comparator<EmployeeCustom>(){
        public int compare(EmployeeCustom o1,EmployeeCustom o2){
            return Integer.compare(o1.getSalary(),o2.getSalary());
        }
    };

    public static Comparator<EmployeeCustom> SalaryNameComparator=new Comparator<EmployeeCustom>() {
        @Override
        public int compare(EmployeeCustom o1, EmployeeCustom o2) {
            int flag= o1.getSalary()-o2.getSalary();
            return flag==0?o1.getName().compareTo(o2.getName()):flag;
        }
    };
}
