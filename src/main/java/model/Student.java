package model;

public class Student{
    private static int count;
    private int id;
    private int age;
    private String name;

    static{
        count = 0;
    }
    public Student(String name, int age){
        this.name = name;
        this.age = age;
        this.id =count;
        count++ ;
    }
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public String toString(){
        return this.name;
    }
    public boolean equals(Student other){
        return name.equals(other.name)& this.age == other.age ;
    }
    public int hashCode(){
        return name.hashCode();
    }
}
