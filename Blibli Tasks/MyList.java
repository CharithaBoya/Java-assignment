import java.util.Scanner;

public class MyList {
    private int[] array;
    private int size; 

    public MyList() {
        array = new int[100];
        size = 0;
    }

    public void add(int value) {
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

        if (size <= array.length / 4 && array.length > 100) {
            resizeArray(array.length / 2);
        }
        System.out.println("Deleted element at index " + index);
    }

    public void deleteByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                deleteAtIndex(i);
                System.out.println("Deleted element with value " + value);
                return;
            }
        }
        System.out.println("Value not found.");
    }

    public int get(int index) {
    if (index < 0 || index >= size) {
        System.out.println("Invalid index.");
        return -1; 
    }
    return array[index];
}


    private void resizeArray(int newCapacity) {
        int[] newArray = new int[newCapacity];
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
        MyList myList = new MyList();
        
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
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the value to add: ");
                    int valueToAdd = scanner.nextInt();
                    myList.add(valueToAdd);
                    System.out.println("Added " + valueToAdd);
                    break;
                    
                case 2:
                    System.out.print("Enter the index to delete: ");
                    int indexToDelete = scanner.nextInt();
                    myList.deleteAtIndex(indexToDelete);
                    break;
                    
                case 3:
                    System.out.print("Enter the value to delete: ");
                    int valueToDelete = scanner.nextInt();
                    myList.deleteByValue(valueToDelete);
                    break;
                    
                case 4:
                    System.out.print("Enter the index to retrieve: ");
                    int indexToRetrieve = scanner.nextInt();
                    int retrievedValue = myList.get(indexToRetrieve);
                    if (retrievedValue != -1) { 
                        System.out.println("Element at index " + indexToRetrieve + ": " + retrievedValue);
                     }
                    break;

                    
                case 5:
                    System.out.print("Current list: ");
                    for (int i = 0; i < myList.getSize(); i++) {
                        System.out.print(myList.get(i) + " ");
                    }
                    System.out.println();
                    break;
                    
                case 6:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
