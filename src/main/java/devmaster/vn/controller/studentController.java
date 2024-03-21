package devmaster.vn.controller;

import devmaster.vn.DTO.StudentDTO;
import devmaster.vn.Entity.Student;
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


    @GetMapping("")
    List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/find-by-address")
    List<StudentDTO> findByAddress(@RequestParam("address") String address) {
        return studentService.findByAddress(address);
    }

    // Endpoint để thêm mới sinh viên
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO) {
        String result = studentService.save(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // Endpoint để cập nhật thông tin sinh viên
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        String result = studentService.update(id, studentDTO);
        return ResponseEntity.ok(result);
    }

    // Endpoint để xóa sinh viên
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        String result = studentService.delete(id);
        return ResponseEntity.ok(result);
    }
}
