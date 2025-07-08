package com.data.demo_springboot_student.repo;

import com.data.demo_springboot_student.entity.Student;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    @Getter
    private static List<Student> listStudents = new ArrayList<>();

    static {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            listStudents.add(new Student("1", "Nguyen Van A", true, sdf.parse("01/01/2000"), "Ha Noi", "CNTT"));
            listStudents.add(new Student("2", "Nguyen Van B", true, sdf.parse("15/02/2001"), "Ha Noi", "CNTT"));
            listStudents.add(new Student("3", "Nguyen Van C", true, sdf.parse("20/03/2002"), "Ha Noi", "CNTT"));
            listStudents.add(new Student("4", "Nguyen Van D", true, sdf.parse("05/04/2000"), "Ha Noi", "CNTT"));
            listStudents.add(new Student("5", "Nguyen Van E", true, sdf.parse("10/05/2001"), "Ha Noi", "CNTT"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addStudent(Student student) {
        return listStudents.add(student);
    }

    public static boolean updateStudent(Student student){
        boolean b = listStudents.stream().anyMatch(s -> s.getId().equals(student.getId()));
        if(!b)
            return false;
        for(Student s: listStudents){
            if(s.getId().equals(student.getId())){
                listStudents.remove(s);
                listStudents.add(student);
                break;
            }
        }
        return true;
    }
    public static boolean deleteStudent(String id){
        return getListStudents().removeIf(s -> s.getId().equals(id));
    }
}