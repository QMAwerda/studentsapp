package ru.kors.springstudents.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import ru.kors.springstudents.model.Student;
import ru.kors.springstudents.service.StudentService;

@RestController // наследник Controller и ResponseBody, т.е. автосериализация в json всех
                // возвращаемых объектов
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService service; // инициализируем его через @AllArgsConstructor отдав контроль за жизненным
    // циклом
    // объекта нашему фреймворку spring
    // final - делает поле константой

    @GetMapping // возьмет наш адрес для пути
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }

    @PostMapping("save_student")
    // Сериализует параметр student в json
    public String saveStudent(@RequestBody Student student) {
        service.saveStudent(student);
        return "Student successfully saved";
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable("email") String email) {
        return service.findByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email) {
        service.deleteStudent(email);
    }
}
