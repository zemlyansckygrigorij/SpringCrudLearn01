package controller;

import java.util.*;
import java.util.stream.Collectors;

import model.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/api")
public class WebController{
/*
    private Map<Integer, Student> students = new HashMap<Integer, Student>(){

        {
            put(1, new Student( "Mary",  24));
            put(2, new Student( "Peter",  18));
            put(3, new Student( "Lauren",  31));
            put(4, new Student( "Thomac", 11));
        }
    };

    @GetMapping(value="/student")
    public List<Student> getAll(){
        List<Student> results = students.entrySet().stream()
                .map(entry ->entry.getValue())
                .collect(Collectors.toList());
        return results;
    }

    @GetMapping(value="/student/{id}")
    public Student getStudent(@PathVariable int id){
        return students.get(id);
    }

    @PostMapping(value="/student")
    public Student postStudent(@RequestBody Student student){
        int id = students.size() + 1;

        students.put(id, student);
        return student;
    }

    @PutMapping(value="/student/{id}")
    public void putStudent(@RequestBody Student student, @PathVariable int id){
        students.replace(id, student);
    }

    @DeleteMapping(value="/student/{id}")
    public void deleteStudent(@PathVariable int id){
        students.remove(id);
    }
*/


    private SortedSet<Student> students = new TreeSet<Student>(){
        {
            students.add(new Student("Mary", 18));
            students.add(new Student("Peter", 34));
            students.add(new Student("Lauren", 21));
            students.add(new Student("Thomac", 23));
            students.add(new Student("David", 20));
        }
    };
    @GetMapping(value="/student")
    public List<Student> getAll(){
        List<Student> results = new ArrayList<>();
        results.addAll(students);
        return results;
    }

    @GetMapping(value="/student/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = students.stream().filter(s -> s.getId()==id).collect(Collectors.toList()).get(0);
        return student;
    }

    @PostMapping(value="/student")
    public Student postStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    @PutMapping(value="/student/{id}")
    public void putStudent(@RequestBody Student student, @PathVariable int id){
        Student _student = students.stream().filter(s -> s.getId()==id).collect(Collectors.toList()).get(0);
        _student.setName(student.getName());
        _student.setAge(student.getAge());

    }

    @DeleteMapping(value="/student/{id}")
    public void deleteStudent(@PathVariable int id){
        Student student = students.stream().filter( s -> s.getId() == id).collect(Collectors.toList()).get(0);
        students.remove(student);
    }

}
