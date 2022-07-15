class KStackClass {
    int arr[]; // all elements stored here
    int top[]; // all top maintained here
    int next[]; // all the next index + previous store element index for pop
    int KSize;
    int capacity;
    int freeTop;

    KStackClass(int KSize, int n) {
        this.KSize = KSize;
        this.capacity = n;
        arr = new int[capacity];
        top = new int[KSize];
        next = new int[capacity];
        freeTop = 0;
        topFill();
        nextFill();
    }

    void topFill() {
        for (int i = 0; i < KSize; i++)
            top[i] = -1;
    }

    void nextFill() {
        for (int i = 0; i < capacity - 1; i++)
            next[i] = i + 1;
        next[capacity - 1] = -1;
    }

    void push(int element, int stackNumber) {
        int index = freeTop; // current top index (default on 0)
        freeTop = next[index]; // get the next index and store in freetop (freetop point to the next index)
        next[index] = top[stackNumber];
        top[stackNumber] = index;
        arr[index] = element;
    }

    int pop(int stackNumber) {
        int index = top[stackNumber]; // top element index to stack number
        top[stackNumber] = next[index];
        next[index] = freeTop; // free space fill with next index
        freeTop = index;
        return arr[index];
    }
}

public class KStack {
    public static void main(String[] args) {
        KStackClass kstack = new KStackClass(3, 10);
        kstack.push(10, 0);
        kstack.push(20, 0);
        kstack.push(30, 0);
        kstack.push(100, 1);
        kstack.push(200, 1);
        kstack.push(40, 0);
        kstack.push(1000, 2);

        System.out.println(kstack.pop(0));
        System.out.println(kstack.pop(0));
        System.out.println(kstack.pop(1));
        System.out.println(kstack.pop(2));

    }
}
