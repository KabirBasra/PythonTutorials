// Required for clean output of Arrays
// when using S.O.println(Arrays.toString(data))
import java.util.Arrays; 

// CLASS
public class algorithms {
    private int[] data = {5,4,3,2,1};

// Insertion Sort
// | Taking an element from the unsorted section and
// | placing it in the sorted section of the array
    public void insertionSort() {
        System.out.print("Before: ");
        System.out.println(Arrays.toString(data));
        
        for (int i=1; i<data.length; i++) {
            int compare = data[i];
            int count = i;
            while (count>0 && compare<data[count-1]) { 
                data[count] = data[count-1];
                count--;
            }
            data[count] = compare;
        }
        System.out.print("After: ");
        System.out.println(Arrays.toString(data));
    }


// Selection Sort
// | 
    public void selectionSort() {
        System.out.print("Before: ");
        System.out.println(Arrays.toString(data));
        for (int i = 1; i < data.length-1; i++) {
            int smallest = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[i] < data[smallest]) {
                    smallest = j;
                }
                int temp = data[i];
                data[i] = data[smallest];
                data[smallest] = data[i];
            }
        }
        System.out.print("After: ");
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        algorithms insertSort = new algorithms();
        insertSort.selectionSort();
    }
    
}