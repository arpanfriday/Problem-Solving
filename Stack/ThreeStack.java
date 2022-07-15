class ThreeStackOperations {
    int leftTop;
    int midTop;
    int rightTop;
    int arr[];
    int capacity;

    ThreeStackOperations(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        leftTop = -1;
        midTop = -1;
        rightTop = capacity;
    }

    void leftPush(int element) {
        if (shiftMidToRight()) {
            leftTop++;
            arr[leftTop] = element;
        } else {
            System.out.println("No space for left :(");
        }
    }

    boolean shiftMidToRight() { // to check if mid can be shifted
        if (midTop < rightTop - 1) {
            for (int i = midTop; i > leftTop; i--) {
                arr[i + 1] = arr[i];
            }
            midTop++;
            return true;
        }
        return false;
    }

    int leftPop() {
        if (leftTop == -1)
            throw new RuntimeException("Left stack is empty :(");
        else {
            int element = arr[leftTop];
            leftTop--;
            shiftMidToLeft();
            return element;
        }

    }

    void shiftMidToLeft() {
        for (int i = leftTop + 2; i <= midTop; i++)
            arr[i - 1] = arr[i];
        midTop--;
    }

    int leftPeek() {
        if (leftTop != -1) {
            return arr[leftTop];
        } else
            throw new RuntimeException("Left stack is empty :(");
    }

    void midPush(int element) {
        if (midTop < rightTop - 1) {
            midTop++;
            arr[midTop] = element;
        } else {
            System.out.println("No space for mid :(");
            return;
        }
    }

    int midPop() {
        if (midTop == leftTop)
            throw new RuntimeException("Mid Stack empty :(");
        int element = arr[midTop];
        midTop--;
        return element;
    }

    int midPeek() {
        if (midTop == leftTop) {
            throw new RuntimeException("Mid stack empty :(");
        }
        return arr[midTop];
    }

    void rightPush(int element) {
        if (rightTop - 1 > midTop) {
            rightTop--;
            arr[rightTop] = element;
        } else {
            System.out.println("No space for right :(");
            return;
        }
    }

    int rightPop() {
        if (rightTop == capacity)
            throw new RuntimeException("Right Stack empty :(");
        int element = arr[rightTop];
        rightTop++;
        return element;
    }

    int rightPeek() {
        if (rightTop == capacity)
            throw new RuntimeException("Right stack empty :(");
        return arr[rightTop];
    }

    void printArr() {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}

public class ThreeStack {
    public static void main(String[] args) {
        ThreeStackOperations stack = new ThreeStackOperations(10);
        stack.midPush(10);
        // System.out.println(stack.rightPeek());
        stack.midPush(20);
        stack.midPush(30);
        stack.leftPush(1);
        System.out.println(stack.leftPeek());
        stack.leftPush(2);
        stack.leftPush(3);
        // System.out.println(stack.rightPeek());
        stack.midPush(40);
        stack.midPush(50);
        stack.rightPush(100);
        stack.rightPush(200);
        System.out.println(stack.rightPeek());

        stack.printArr();

        System.out.println(stack.leftPeek());
        System.out.println(stack.rightPeek());
        System.out.println(stack.midPeek());
        System.out.println("=======================");
        System.out.println(stack.leftPop());
        System.out.println(stack.midPop());
        System.out.println(stack.rightPop());

        System.out.println("=======================");
        stack.midPush(20);
        System.out.println(stack.midPeek());
    }
}
