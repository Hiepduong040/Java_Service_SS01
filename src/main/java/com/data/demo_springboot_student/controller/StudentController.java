package com.data.demo_springboot_student.controller;

import com.data.demo_springboot_student.entity.Student;
import com.data.demo_springboot_student.repo.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    // Hiển thị danh sách
    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", StudentRepository.getListStudents());
        return "listStudent";
    }

    // Show form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        Student student = new Student();
        student.setGender(null);
        model.addAttribute("student", student);
        return "studentForm";
    }

    // Xử lý thêm mới
    @PostMapping("/add")
    public String add(@ModelAttribute Student student) {
        StudentRepository.addStudent(student);
        return "redirect:/student";
    }

    // Show form sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Student s = StudentRepository.getListStudents().stream()
                .filter(st -> st.getId().equals(id))
                .findFirst().orElse(null);
        model.addAttribute("student", s);
        return "studentForm";
    }

    // Xử lý sửa
    @PostMapping("/edit")
    public String edit(@ModelAttribute Student student) {
        StudentRepository.updateStudent(student);
        return "redirect:/student";
    }

    // Xử lý xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        StudentRepository.deleteStudent(id);
        return "redirect:/student";
    }
}
