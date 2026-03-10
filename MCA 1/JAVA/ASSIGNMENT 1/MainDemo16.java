import org.gvp.dcs.ds.Stack;
import org.gvp.dcs.ds.Queue;
import org.gvp.dcs.shapes.Sphere;
import org.gvp.dcs.shapes.Cube;

public class MainDemo16 {
    public static void main(String[] args) {

        System.out.println("=== Stack Demo ===");
        Stack stack = new Stack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());

        System.out.println("\n=== Queue Demo ===");
        Queue queue = new Queue(3);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("\n=== Sphere Demo ===");
        Sphere sphere = new Sphere(5);
        System.out.println("Sphere Volume: " + sphere.volume());
        System.out.println("Sphere Surface Area: " + sphere.surfaceArea());

        System.out.println("\n=== Cube Demo ===");
        Cube cube = new Cube(4);
        System.out.println("Cube Volume: " + cube.volume());
        System.out.println("Cube Surface Area: " + cube.surfaceArea());
    }
}
