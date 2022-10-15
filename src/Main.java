public class Main {



    public static void main(String[] args){
        double[] doubles = {
                20.2, 200.3, 3.3, 4000.9,
                75.334, 60.0, 5003.905043, 62.7
        };

        //demonstrating selection sort algorithm
        System.out.println("Selection Sort");
        System.out.println("Before sorting");
        printArray(doubles);
        selectionSort(doubles);
        System.out.println("After sorting");
        printArray(doubles);

        //demonstrating linear search
        System.out.println("\nLinear Search");
        printArray(doubles);
        linearSearch(doubles, 5003.905043);

        //demonstrating binary search
        System.out.println("\nBinary Search");
        printArray(doubles);
        binarySearch(doubles, 5003.905043);

    }
    public static void selectionSort(double[] arr) {
            //selection sort:   algorithm is used to find the smallest element, and move it to the first
            //                  position of an array. it has a sorted section and unsorted section. becomes
            //                  more inefficient as the data set grows larger.
            //                  loop will start at i = 0, which is the first element of the unsorted sub array.

            //      runtime complexity: Quadratic time O(N^2)
            //      small data set: okay
            //      large data set: inefficient

            int n = arr.length;
            for(int i = 0; i < n - 1; i++){
                int min = i; // minimum index = to the current iteration of the outer loop.
                for (int j = i + 1; j < n; j++) { //for each element, in unsorted part of array
                    if (arr[j] < arr[min]) { //check if element in question is smaller than current minimum
                        min = j; //update minimum element to be this value in question
                    }
                }
                //swap with element at the beginning of sub array
                double temp = arr[i]; // set value of temp equal to index i
                arr[i] = arr[min]; //set element i = to element min which was the updated minimum element
                arr[min] = temp; // set the value of arr @ min = temp
            }
    }

    public static void linearSearch(double[] arr, double key){
        int searchNum = 0;
        for(int i = 0; i < arr.length; i++ ){
            if(arr[i] == key){
                searchNum++;
                System.out.println("Key found on search number: " + searchNum + ". Key is: " + key + ".");
                return;
            } else{
                searchNum++;
                System.out.println("Index: " + i + " Key not found. " + "\nNumber of searches: " + searchNum );
            }
        }
    }

    public static void binarySearch(double[] arr, double key){
        int low, mid, high;
        low = 0;
        high = arr.length - 1;
        int splitNum = 0;

        while (high >= low){
            mid = (high + low)/ 2;
            if (arr[mid] < key ){ //if the middle element is less than the key,
                low = mid + 1; // set the new low to mid +1
                splitNum++;
                System.out.println("Diving in two and searching second half Number of splits: " + splitNum);
            }
            else if (arr[mid] > key){ //if the middle element is greater than the key,
                high = mid - 1; //set the new
                splitNum++;
                System.out.println("Diving in two and searching first half. Number of splits: " + splitNum);
            }
            else{
                System.out.println("Found the key! Key is: " + key + ".");
                return;
            }
        }
        System.out.println("Not found!");
    }

    public static void printArray(double[] arr){
        for (double i : arr) {
            System.out.print("* " + i + " * ");
        }
        System.out.println();
    }


}