package MyAggrigation;
public class Actor {
    private String name;
    private int age;

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void showActor() {
        System.out.println("Actor Name: " + name);
        System.out.println("Age: " + age);
    }
}