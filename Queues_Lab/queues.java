import java.util.Arrays; 
// | 

public class queues {
    private Task[] data;
    private int length;
    private int next;
    private int largest;
    private int smallest;

    public queues(Task[] ndata, int nlength) {
        this.length = ndata.length;
        this.data = new Task[nlength];
        this.largest = 0; this.smallest = 0; this.next = 0;
        for (int i = 0; i<length ; i++) {
            data[next] = ndata[i];
            if (data[i].getPriority() > data[largest].getPriority()) {
                largest = i;
            }
            if (data[i].getPriority() < data[smallest].getPriority()) {
                smallest = i;
            }
            data[i] = ndata[i];
            next = next + 1;
        }
        System.out.println("Largest: "+data[largest]);
        System.out.println("Smallest: "+data[smallest]);
        System.out.println("Next: "+next);
    }

    public void insert(Task x) {
        if (next < data.length) {
            data[next] = x;
            if (data[largest].getPriority() < data[next].getPriority()) {
                largest = next;
            }
            if (data[smallest].getPriority() > data[next].getPriority()) {
                smallest = next;
            }
            next ++ ;
            length ++ ;
            System.out.print("After Insert: ");
            System.out.println(Arrays.toString(data));
        }
    }

    public String getLargest() {
        return data[largest].toString();
    }

    public void replace(int index, int value) {
        if (index >= 0 && index < length) {
            data[index].setPriority(value);
            updateLargest();
            updateSmallest();
        }
    }

    public void updateLargest() {
        largest = 0;
        for (int i = 0; i<length ; i++) {
            if (data[i].getPriority() > data[largest].getPriority()) {
                largest = i;
            }
        }
    }

    public void updateSmallest() {
        smallest = 0;
        for (int i = 0; i<length ; i++) {
            if (data[i].getPriority() < data[smallest].getPriority()) {
                smallest = i;
            }
        }
    }

    public String extractLargest() {
        String tempLargest = data[largest].toString();
        length -- ; next -- ;
        data[largest] = data[length];
        data[length] = null;
        if (length==smallest) { updateSmallest();}
        
        updateLargest();
        System.out.println(Arrays.toString(data));
        return tempLargest;
    }

// MAIN CONSTRUCTOR
    public static void main(String[] args) {
        queues temp = new queues(new Task[]{new Task("Swim",2)},5);
        temp.insert(new Task("Clean",3));
        temp.replace(0,9);
        System.out.println(temp.extractLargest());
        System.out.println(temp.largest);
    }
}





// At the moment, your priority queue just holds some integers. Quickly implement a ‘Task’ class
// that just holds something like a task name, and a priority. Change your queue to
// accommodate this. This is not a short task in itself, especially if you have a changePriority
// method. We strongly recommend creating a new class for the queue, rather than modifying
// your existing one, but you can if you are super confident.
// You will also need your task class to implement the Comparable interface because you need to
// compare priorities here.