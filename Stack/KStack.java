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
        for (int i = 0; i < KSize; i++) {
            top[i] = -1;
        }
    }

    void nextFill() {
        for (int i = 0; i < capacity - 1; i++) {
            next[i] = i + 1;
        }
        next[capacity - 1] = -1;
    }

    void push(int element, int stackNumber) {

    }
}

public class KStack {
    public static void main(String[] args) {

    }
}
