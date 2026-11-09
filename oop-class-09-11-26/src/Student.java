class Student {

    //data member
    String name;
    int id;
    byte age;
    char gender;
    boolean isMarried;
    static String uni_name = "AUCA";

    public Student(String name, int id, byte age, char gender, boolean isMarried) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.isMarried = isMarried;
    }
    public Student(){
        name = "unknown";
        id = 0;
        age = 0;
        gender = 'x';
        isMarried = false;
    }


}


class Exec {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.uni_name = "CMU";
        System.out.println(s1.uni_name);
    }
}