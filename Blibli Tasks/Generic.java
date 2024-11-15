import java.util.Scanner;

public class MyList<T> {
    private T[] array;
    private int size; 

    public MyList() {
        array = (T[]) new Object[100]; 
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
        array[--size] = null; 

        if (size <= array.length / 4 && array.length > 100) {
            resizeArray(array.length / 2);
        }
        System.out.println("Deleted element at index " + index);
    }

    public void deleteByValue(T value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                deleteAtIndex(i);
                System.out.println("Deleted element with value " + value);
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
        return array[index];
    }

    private void resizeArray(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity]; 
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose the type of list:");
        System.out.println("1. Integer");
        System.out.println("2. String");
        System.out.println("3. Custom Object");
        System.out.print("Enter your choice: ");
        int typeChoice = scanner.nextInt();

        if (typeChoice == 1) {
            MyList<Integer> intList = new MyList<>();
            performOperations(intList, scanner);
        } else if (typeChoice == 2) {
            MyList<String> strList = new MyList<>();
            performOperations(strList, scanner);
        } else if (typeChoice == 3) {
            MyList<CustomClass> customList = new MyList<>();
            performOperations(customList, scanner);
        } else {
            System.out.println("Invalid choice. Exiting.");
        }

        scanner.close();
    }

    private static <T> void performOperations(MyList<T> list, Scanner scanner) {
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add an element");
            System.out.println("2. Delete element by index");
            System.out.println("3. Delete element by value");
            System.out.println("4. Retrieve element by index");
            System.out.println("5. Display list");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to add: ");
                    T valueToAdd = (T) scanner.nextLine(); 
                    list.add(valueToAdd);
                    System.out.println("Added " + valueToAdd);
                    break;
                    
                case 2:
                    System.out.print("Enter the index to delete: ");
                    int indexToDelete = scanner.nextInt();
                    list.deleteAtIndex(indexToDelete);
                    break;
                    
                case 3:
                    System.out.print("Enter the value to delete: ");
                    T valueToDelete = (T) scanner.nextLine();
                    list.deleteByValue(valueToDelete);
                    break;
                    
                case 4:
                    System.out.print("Enter the index to retrieve: ");
                    int indexToRetrieve = scanner.nextInt();
                    T retrievedValue = list.get(indexToRetrieve);
                    if (retrievedValue != null) {
                        System.out.println("Element at index " + indexToRetrieve + ": " + retrievedValue);
                    }
                    break;

                case 5:
                    System.out.print("Current list: ");
                    for (int i = 0; i < list.getSize(); i++) {
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                    break;
                    
                case 6:
                    System.out.println("Exiting program.");
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static class CustomClass {
        String name;

        CustomClass(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
