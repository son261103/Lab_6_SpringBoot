package devmaster.vn.controller;

import devmaster.vn.DTO.StudentDTO;
import devmaster.vn.Entity.Student;
import devmaster.vn.ProjectTion.IAvgPoint;
import devmaster.vn.ProjectTion.IStudentPoint;
import devmaster.vn.repository.StudentRepository;
import devmaster.vn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/v1")
public class studentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("")
    List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/find-by-address")
    List<StudentDTO> findByAddress(@RequestParam("address") String address) {
        return studentService.findByAddress(address);
    }

    // Endpoint để thêm mới sinh viên
    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        String result = studentService.save(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // Endpoint để cập nhật thông tin sinh viên
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        String result = studentService.update(studentDTO);
        return ResponseEntity.ok(result);
    }

    // Endpoint để xóa sinh viên
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        String result = studentService.delete(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    List<IStudentPoint> getStudentPoints (@PathVariable int id){
        return studentService.finIStudentId(id);
    }

    @GetMapping("/avg/tb/{id}")
    List<IAvgPoint> getAvgPoint(@PathVariable int id){
        return studentService.finIAgvPoint(id);
    }
}
