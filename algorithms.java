// Required for clean output of Arrays
// when using S.O.println(Arrays.toString(data))
import java.util.Arrays; 

// CLASS
public class algorithms {
    private static int[] data = {5,4,3,2,1};
    private static int dlength = data.length;

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
// | UNFINISHED
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


// Merge Sort
// | Divide and conquer sorting algorithm
// | One method to divide the array recursively
// | One method designed to merge the array in order
    public void mergeSort(int[] a, int l, int r) {
        if (l<r) {
            int m = (l+r)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,r);
            merge(a,l,m,r);
        }
    }

    public void merge(int[] a, int l, int m, int r) {
        int n1 = m-l+1; int n2 = r-m;
        int[] tL = new int[n1+1]; int[] tR = new int[n2+1];
        for (int index = 0; index<n1; index++) {
            tL[index] = a[l+index];
        }
        for (int index = 0; index<n2; index++) {
            tR[index] = a[m+1+index];
        }
        tL[n1] = tR[n2] = 999999;
        int i = 0; int j = 0;
        for (int k = l; k<=r; k++) {
            if (tL[i] <= tR[j]) {
                a[k]= tL[i];  i++;
            } else {
                a[k]= tR[j];  j++;                
            }
        }
    }


// Palindrome (text)
// | Checking whetehr tetxt strings are palindromes
// | Utiliisng recursion and performs string validation

    public boolean palindrome(String pal, int first, int last) {
        if (first >= last) {
            return true;
        }
        char asciiCheck = pal.charAt(first);
        if ((pal.charAt(first) < 'a')||(pal.charAt(first) > 'z')) {
            return (palindrome(pal, first+1, last));
        } 
        if ((pal.charAt(last) < 'a')||(pal.charAt(last) > 'z')) {
            return (palindrome(pal, first, last-1));
        }
        if (pal.charAt(first)==pal.charAt(last)) {
            return (palindrome(pal, first+1, last-1));
        } else {
            return false;
        }
    }


// Fibonacci Sequence
// |
// |

    public int fib(int num1, int num2, int count) {
        if (count <= 0) {
            return num1;
        } else {
            int temp = num1;
            num1 = num2;
            num2 = num2 + temp;
            count = count - 1;
            return fib(num1,num2,count);
        }
    }




// MAIN //
    public static void main(String[] args) {
        algorithms sorting = new algorithms();
        sorting.mergeSort(data,0,dlength-1);
        System.out.print("After: ");
        System.out.println(Arrays.toString(data));
        String tempWord = "A man, a plan, a canal - Panama";
        System.out.println(sorting.palindrome(tempWord.toLowerCase().trim(), 0, tempWord.length()-1));
        System.out.println(sorting.fib(0, 1, 6));
    }
}