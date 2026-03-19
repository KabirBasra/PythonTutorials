import java.util.Arrays; 
// | 

public class queues {
    private int[] data;
    private int length;
    private int next;
    private int largest;
    private int smallest;

    public queues(int[] ndata, int nlength) {
        this.length = ndata.length;
        this.data = new int[nlength];
        this.largest = 0; this.smallest = 0; this.next = 0;
        for (int i = 0; i<length ; i++) {
            data[next] = ndata[i];
            if (data[i] > data[largest]) {
                largest = i;
            }
            if (data[i] < data[smallest]) {
                smallest = i;
            }
            data[i] = ndata[i];
            next = next + 1;
        }
        System.out.println("Largest: "+data[largest]);
        System.out.println("Smallest: "+data[smallest]);
        System.out.println("Next: "+next);
    }

    public void insert(int x) {
        if (next < data.length) {
            data[next] = x;
            if (data[largest] < data[next]) {
                largest = next;
            }
            if (data[smallest] > data[next]) {
                smallest = next;
            }
            next ++ ;
            length ++ ;
            System.out.print("After Insert: ");
            System.out.println(Arrays.toString(data));
        }
    }

    public int getLargest() {
        return data[largest];
    }

    public void replace(int index, int value) {
        if ((data[largest] < value && index == largest)||(data[smallest] > value && index == smallest)) {
            data[index] = value;    
        } else {
            data[index] = value;
            updateLargest(); updateSmallest();    
        }
    }

    public void updateLargest() {
        largest = 0;
        for (int i = 0; i<length ; i++) {
            if (data[i] > data[largest]) {
                largest = i;
            }
        }
    }

    public void updateSmallest() {
        smallest = 0;
        for (int i = 0; i<length ; i++) {
            if (data[i] < data[smallest]) {
                smallest = i;
            }
        }
    }

    public int extractLargest() {
        int tempLargest = data[largest];
        data[largest] = data[length-1];
        data[length-1] = 0;
        if (length-1==smallest) { updateSmallest();}
        length -- ; next -- ;
        updateLargest();
        System.out.println(Arrays.toString(data));
        return tempLargest;
    }

// MAIN CONSTRUCTOR
    public static void main(String[] args) {
        queues temp = new queues(new int[]{3,2} , 5);
        temp.insert(10);
        temp.replace(0,9);
        System.out.println(temp.extractLargest());
        System.out.println(temp.largest);
    }
}



// | A method to insert a new priority into the queue ✅
// | A method that returns the largest priority in the queue ✅
// | A method that changes one of the priorities in the queue (having received an
//   index, and a new value). Note that this is different to the examples in the
//   lecture! So think about what problems this might cause. ✅
// | A method that extracts and returns the largest priority in the queue ✅
// | A toString method that returns some basic information about the queue, maybe
//   just the priorities in the queue. ➖