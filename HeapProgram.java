import java.util.Scanner;
class Heap{
    int[] heap;
    int size;
    int capacity;
    boolean isMinHeap;
   Heap(int capacity,boolean isMinHeap){
    this.capacity=capacity;
    this.isMinHeap=isMinHeap;
    heap=new int[capacity];
    size=0;
   }
    int parent(int i){
        return (i-1)/2;
    }
    int left(int i){
        return 2*i+1;
    }
    int right(int i){
        return 2*i+2;
    }
     void swap(int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
     }
     void insert(int value){
        if(size==capacity){
            System.out.println("Heap is full");
            return;
            
        }
        heap[size]=value;
        int current=size;
        size++;
        while(current>0 && compare(heap[current],heap[parent(current)])){
            swap(current,parent(current));
            current=parent(current);
        }
     }
     boolean compare(int child ,int parent){
        if(isMinHeap){
            return child<parent;
        }
        else{
            return child>parent;
        }
        }
        void delete (int value){
            int index=-1;
            for(int i=0;i<size;i++){
                if(heap[i]==value){
                    index=i;
                    break;
                }
            }
            if(index==-1){
                System.out.println("value not found in heap") ;
            return;           }
            heap[index]=heap[size-1];
            size--;
            heapifyDown(index);
        }
        void heapifyDown(int index){
            int left=left(index);
            int right=right(index);
            int extreme=index;
            if(left<size && compare(heap[left],heap[extreme])){
                extreme=left;
            }
            if(right<size && compare(heap[right],heap[extreme])){
                extreme=right;
            }
            if(extreme!=index){
                swap(index,extreme);
                heapifyDown(extreme);
            }
        }
        void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

}
public class HeapProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Min Heap");
        System.out.println("2. Max Heap");
        System.out.print("Choose Heap Type: ");
        int choice = sc.nextInt();

        System.out.print("Enter capacity: ");
        int capacity = sc.nextInt();

        Heap heap = new Heap(capacity, choice == 1);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            heap.insert(sc.nextInt());
        }

        System.out.println("Heap Elements:");
        heap.display();

        System.out.print("Enter element to delete: ");
        int del = sc.nextInt();
        heap.delete(del);

        System.out.println("Heap After Deletion:");
        heap.display();

        sc.close();
    }
}


