import java.util.Arrays;

class Quicksort {
    private int[] array;
    private int capacity;

    public Quicksort(int[] array) {
        this.array = array;
    }

    public void quicksort(int l, int r) {
        if (l < r) {
            int m = partition(l, r);
            quicksort(l, m-1);
            quicksort(m+1, r);

        }
        
    }

    public int partition(int l, int r) {
        int pivot = array[r];
        int i = l;
        for(int j=l ; j<r-1 ; j++) {
            if (array[j]<=pivot) {
                swap(i, j);
                i ++ ;
            }
        }
        swap(i, r);
        return i;
    }

    public void swap(int l, int r) {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }


    public static void main(String[] args) {
        Quicksort data = new Quicksort(new int[] {4,3,2,1});
        System.out.println(Arrays.toString(data.array));
    }
}