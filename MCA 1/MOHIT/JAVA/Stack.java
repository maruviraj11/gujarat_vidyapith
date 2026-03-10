/* Practical : [8]
Create a class named Stack with the following specifications:
- Constructors:
- Define constructors to initialize the stack (e.g., default constructor, constructor to
specify the stack's size).

- Methods:
1. public void push(int value) Adds an integer value to the stack.
2. public int pop() Removes and returns the top value from the stack.
3. public void traverse() Traverses and prints all the elements in the stack.

*/

public class Stack {
    int[] arr;
    int top;
    int size;

    Stack() {
        size = 5;
        arr = new int[size];
        top = -1;
    }

    Stack(int s) {
        size = s;
        arr = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        int val = arr[top];
        top--;
        return val;
    }

    public void traverse() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        try {
            Stack s = new Stack(4);
            s.push(10);
            s.push(20);
            s.push(30);
            s.push(40);
            s.push(50); 

            s.traverse();

            System.out.println("Popped: " + s.pop());
            s.traverse();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }
}

