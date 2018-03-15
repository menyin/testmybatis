package mode;

public class Student {
    public Student() {
    }
    public Student(String id, String name, int age, Class aClass) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.aClass = aClass;
    }


    private String id;
    private String name;
    private int age;
    private Class aClass;

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
