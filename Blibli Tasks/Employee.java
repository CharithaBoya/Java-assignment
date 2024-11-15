import java.util.Date;

class Employee { 
    private int id; 
    private String name;
    private int age;
    private Date dateOfJoining;

    public Employee(int id, String name, int age, Date dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', age=" + age + ", dateOfJoining=" + dateOfJoining + "}";
    }
}

class MyList<T> {
    private Object[] array;
    private int size;

    public MyList() {
        array = new Object[100];
        size = 0;
    }

    public void add(T value) {
        if (size == array.length) {
            resizeArray(array.length * 2);
        }
        array[size++] = value;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void deleteByValue(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                deleteAtIndex(i);
                return;
            }
        }
        System.out.println("Value not found.");
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return null;
        }
        return (T) array[index];
    }

    private void resizeArray(int newCapacity) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getSize() {
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        MyList<Employee> employeeList = new MyList<>();

        Employee e1 = new Employee(101, "Charitha", 30, new Date(120, 0, 15)); 
        Employee e2 = new Employee(102, "Supriya", 25, new Date(121, 4, 10));
        Employee e3 = new Employee(103, "Krishna", 35, new Date(119, 7, 25));

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        System.out.println("Employee List:");
        for (int i = 0; i < employeeList.getSize(); i++) {
            System.out.println(employeeList.get(i));
        }

        employeeList.deleteAtIndex(1); 

        System.out.println("\nUpdated Employee List:");
        for (int i = 0; i < employeeList.getSize(); i++) {
            System.out.println(employeeList.get(i));
        }

        employeeList.deleteByValue(e3); 

        System.out.println("\nFinal Employee List:");
        for (int i = 0; i < employeeList.getSize(); i++) {
            System.out.println(employeeList.get(i));
        }
    }
}
