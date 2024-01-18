import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Customer[] customers = {
                new Customer("pavithra", 10),
                new Customer("pooja", 5),
                new Customer("charu", 7),
                new Customer("srija", 3)
        };

        System.out.println("Original order of customers: " + Arrays.toString(customers));

        heapSort(customers);

        System.out.println("Sorted order of customers: " + Arrays.toString(customers));
    }

    public static void heapSort(Customer[] customers) {
        int n = customers.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(customers, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            Customer temp = customers[0];
            customers[0] = customers[i];
            customers[i] = temp;

            heapify(customers, i, 0);
        }
    }

    private static void heapify(Customer[] customers, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && customers[leftChild].getArrivalTime() > customers[largest].getArrivalTime()) {
            largest = leftChild;
        }

        if (rightChild < n && customers[rightChild].getArrivalTime() > customers[largest].getArrivalTime()) {
            largest = rightChild;
        }

        if (largest != i) {

            Customer swap = customers[i];
            customers[i] = customers[largest];
            customers[largest] = swap;

            heapify(customers, n, largest);
        }
    }
}

class Customer {
    private String name;
    private int arrivalTime;

    public Customer(String name, int arrivalTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return name + " (Arrival Time: " + arrivalTime + ")";
    }
}