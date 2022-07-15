import java.util.Scanner;

class TwoStack {
    int arr[];
    int ltop, rtop;
    int capacity;

    TwoStack(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        ltop = -1;
        rtop = capacity;
    }

    void leftPush(int element) {
        if (ltop <= rtop - 1) {
            ltop++;
            arr[ltop] = element;
        } else {
            System.out.println("No space for left :(");
            return;
        }
    }

    void rightPush(int element) {
        if (rtop - 1 > ltop) {
            rtop--;
            arr[rtop] = element;
        } else {
            System.out.println("No space for right :(");
            return;
        }
    }

    int leftPop() {
        if (ltop == -1) {
            System.out.println("Left Stack empty :(");
            return -1;
        }
        int element = arr[ltop];
        ltop--;
        return element;
    }

    int rightPop() {
        if (rtop == capacity) {
            System.out.println("Right Stack empty :(");
            return -1;
        }
        int element = arr[rtop];
        rtop++;
        return element;
    }

    int leftPeek() {
        return arr[ltop];
    }

    int rightPeek() {
        return arr[rtop];
    }

    void printArr() {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}

public class TwoInOneStack {
    public static void main(String[] args) {
        TwoStack stack = new TwoStack(10);
        stack.leftPush(10);
        stack.leftPush(20);
        stack.leftPush(30);
        stack.leftPush(40);
        stack.leftPush(50);
        stack.printArr();
        stack.rightPush(100);
        stack.rightPush(200);
        stack.rightPush(300);
        stack.rightPush(400);
        stack.rightPush(500);
        stack.printArr();
        stack.rightPush(600);

        System.out.println(stack.leftPeek());
        System.out.println(stack.rightPeek());
        // stack.leftPush(50);
        // stack.leftPush(60);
    }
}
