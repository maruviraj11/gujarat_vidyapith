// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Scanner;

public class stack {
   int[] arr;
   int top;
   int size;

   stack() {
      this.size = 5;
      this.arr = new int[this.size];
      this.top = -1;
   }

   stack(int var1) {
      this.size = var1;
      this.arr = new int[this.size];
      this.top = -1;
   }

   public void push(int var1) {
      if (this.top == this.size - 1) {
         System.out.println("Stack is full");
      } else {
         ++this.top;
         this.arr[this.top] = var1;
         System.out.println("" + var1 + " pushed into stack");
      }
   }

   public int pop() {
      if (this.top == -1) {
         System.out.println("Stack is empty");
         return -1;
      } else {
         int var1 = this.arr[this.top];
         --this.top;
         return var1;
      }
   }

   public int peek() {
      if (this.top == -1) {
         System.out.println("Stack is empty");
         return -1;
      } else {
         return this.arr[this.top];
      }
   }

   public void traverse() {
      if (this.top == -1) {
         System.out.println("Stack is empty");
      } else {
         System.out.println("Stack elements are:");

         for(int var1 = this.top; var1 >= 0; --var1) {
            System.out.println(this.arr[var1]);
         }

      }
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.print("Enter stack size: ");
      int var2 = var1.nextInt();
      stack var3 = new stack(var2);

      int var4;
      do {
         System.out.println("\n--- Stack Menu ---");
         System.out.println("1. Push");
         System.out.println("2. Pop");
         System.out.println("3. Peek");
         System.out.println("4. Traverse");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         var4 = var1.nextInt();
         switch (var4) {
            case 1:
               System.out.print("Enter value to push: ");
               int var5 = var1.nextInt();
               var3.push(var5);
               break;
            case 2:
               int var6 = var3.pop();
               if (var6 != -1) {
                  System.out.println("Popped: " + var6);
               }
               break;
            case 3:
               int var7 = var3.peek();
               if (var7 != -1) {
                  System.out.println("Top element: " + var7);
               }
               break;
            case 4:
               var3.traverse();
               break;
            case 5:
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Invalid choice, try again!");
         }
      } while(var4 != 5);

      var1.close();
   }
}
