public class student implements prototype {

    private int id;
    private String name;
    private String course;
    private String department;

    public student(int id, String name, String course, String department) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.department = department;
    }

    @Override
    public prototype clone() {
        return new student(this.id, this.name, this.course, this.department);
    }

    @Override
    public void display() {
        System.out.println("id: " + id +
                " name: " + name +
                " course: " + course +
                " department: " + department);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}