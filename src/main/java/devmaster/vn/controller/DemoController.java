package devmaster.vn.controller;

import devmaster.vn.DTO.StudentDTO;
import devmaster.vn.Entity.Student;
import devmaster.vn.ProjectTion.IAvgPoint;
import devmaster.vn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/index")
    public String showIndex(Model model){
        model.addAttribute("student", "Sơn Phạm");
        return "index";
    }
    @GetMapping("/show_student")
    public String showStudent(Model model){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1);
        studentDTO.setName("Sơn");
        studentDTO.setAddress("Hải Dương");
        model.addAttribute("studentDTO", studentDTO);
        return "index";
    }
    @GetMapping("/show_student/avg/{id}")
    public String showStudentAVG(@PathVariable int id, Model model){
        List<IAvgPoint> avgPoints = studentService.finIAgvPoint(id);
        model.addAttribute("studentAVG" , avgPoints);
        return "index";
    }



    @GetMapping("/views/add_student")
    public  String showAddstudent(Model model){
        model.addAttribute("student" , new StudentDTO());
        return "/add_student";
    }
    @PostMapping("/student")
    public String addStudent(@ModelAttribute("student") StudentDTO studentDTO){
        studentService.save(studentDTO);
        return "redirec:/index";
    }

    @GetMapping("/views/edit_student/{id}")
    public String showEditStudent(@PathVariable int id, Model model) {
        Student studentDTO = studentService.findById(id);
        model.addAttribute("student", studentDTO);
        return "edit_student";
    }

    // Phương thức để cập nhật học sinh
    @PostMapping("/student/update/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") StudentDTO studentDTO) {
        studentService.update(studentDTO);
        return "redirect:/index";
    }

    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return "redirect:/index";
    }


}
