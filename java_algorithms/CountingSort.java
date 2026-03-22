import java.util.Arrays;

class CountingSort {
    private int[] array;
    private int[] sorted;
    private int[] count;

    public CountingSort(int[] A) {
        array = A;
    }

    public void countingSort(int k) {
        sorted = new int[array.length];
        count = new int[k+1];

        for (int i=0 ; i<array.length ; i++) {
            count[array[i]]++;
        }
        for (int j=1 ; j<k ; j++) {
            count[j] = count[j] + count[j-1];
        }
        for (int i=array.length-1 ; i >= 0 ; i--) {
            sorted[count[array[i]]-- -1] = array[i];
        }
        array = sorted;
        System.out.println(Arrays.toString(array));
    }
    public static void main(String[] args) {
        CountingSort sorting = new CountingSort(new int[]{0,3,2,1,2,1,4});
        sorting.countingSort(5);
    }  
}