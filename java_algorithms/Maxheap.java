import java.util.Arrays;

public class Maxheap {
// Attributes
    private int[] heapData;
    private int capacity;
    private int largest;
    private int next;

// Constructor
    public Maxheap(int[] data, int cap) {
        capacity = cap;
        heapData = new int[capacity];
        for (int i=0 ; i<capacity&&i<data.length ; i++) {
            heapData[i] = data[i];
        }
        next = data.length;
        largest = findLargest();
    }

// Get and Set Methods
// get left child node
    public int getLeftChild(int index) {
        int leftChildNode = 2*index + 1;
        if (leftChildNode < next) { return leftChildNode;}
        else {return -1;}
    }

// get right child node
    public int getRightChild(int index) {
        int rightChildNode = 2*index + 2;
        if (rightChildNode < next) { return rightChildNode;}
        else {return -1;}
    }

//get parent node
    public int getParentNode(int index) {
        return (int)(index-1)/2;
    }

// Finding Largest
    public int findLargest() {
        largest = 0;
        for (int i=0 ; i<next ; i++) {
            if (heapData[i] > heapData[largest]) {
                largest = i;
            }
        }
        return largest;
    }

// Get Maxheap
    public int[] getMaxheap() {
        System.out.println(Arrays.toString(heapData));
        return heapData;
    }

// Unique Methods
// Insert value
    public void insert(int value) {
        if (next<capacity) {
            heapData[next] = value;
                        
        }
        int current = next;
        while (current>0 && heapData[current]>heapData[getParentNode(current)]) {
            int temp = heapData[getParentNode(current)];
            heapData[getParentNode(current)] = heapData[current];
            heapData[current] = temp;
            current = getParentNode(current);
        }
        next ++ ;
    }

// 
    public int extractMax() {
        int max = heapData[largest];
        next -- ;
        heapData[largest] = heapData[next];
        heapData[next] = 0;
        maxHeapify(largest,heapData.length);
        return max;
    }

// HEAP SORT
    public void heapSort() {
        for (int i=(next / 2)-1 ; i >= 0 ; i--) {
            maxHeapify(i,next);
            //getMaxheap();
        }
        System.out.println(Arrays.toString(heapData));

        for (int i=next-1 ; i>0 ; i--) {
            int temp = heapData[0];
            heapData[0] = heapData[i];
            heapData[i] = temp;
            maxHeapify(0, i);
            System.out.println(Arrays.toString(heapData));
        }
        
    }

    public void maxHeapify(int index, int currentSize) {
        int left = getLeftChild(index);
        int right = getRightChild(index);
        int biggest = index;

        if (left != -1 && left < currentSize && heapData[left] > heapData[biggest]) {biggest = left;}
        if (right != -1 && right < currentSize && heapData[right] > heapData[biggest]) {biggest = right;}

        if (biggest != index) {
            int temp = heapData[index];
            heapData[index] = heapData[biggest];
            heapData[biggest] = temp;
            maxHeapify(biggest, currentSize);
        }
    }

// MAIN
    public static void main(String[] args) {
        Maxheap pQueue = new Maxheap(new int[]{3,2,1}, 8);
        pQueue.insert(4);
        pQueue.heapSort();
    }


}

// HEAP IMPLEMENTATION OBJECTIVES:
/* 3. You obviously need a constructor, but this may be overloaded so that it can accept an
      existing array of tasks. If you haven’t, you should try to add this now.

   4. You need to think about how the heap may be used. Are we only ever removing the
      largest element (the root of the heap)? Are we able to remove any index? This guides
      the methods that we are going to need.

   6. Extracting the max means we move the last element in the heap, up into the root
      position, and then sift it down.

   7. We also need to sift down when we are creating a max heap from a previously
      unordered array. This would also be used if the max is removed, as when this happens
      the last task in the list is moved to the root, then sifted down.

   8. While adding tasks one at a time will work, you should add a method that turns an
      existing array into a heap. Why is this better than just adding tasks one at a time?

   9. The lectures talk about a method that increases one of the task priorities, and suggests
      looking at decreasing a priority… implement one which changes priority (up or down).
      a. What is the time complexity of your method?
*/