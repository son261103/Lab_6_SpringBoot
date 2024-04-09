package devmaster.vn.service;

import devmaster.vn.DTO.StudentDTO;
import devmaster.vn.Entity.Clazz;
import devmaster.vn.Entity.Student;
import devmaster.vn.ProjectTion.IAvgPoint;
import devmaster.vn.ProjectTion.IStudentPoint;
import devmaster.vn.mapper.ClazzMapper;
import devmaster.vn.mapper.StudentMappper;
import devmaster.vn.repository.ClazzRepository;
import devmaster.vn.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMappper studentMapper;
    private final ClazzMapper clazzMapper;
    private final ClazzRepository clazzRepository;

    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public List<StudentDTO> findByAddress(String address) {
        List<Student> students = studentRepository.findByAddress(address);
        return studentMapper.toDto(students);
    }

    public Student findById(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            System.out.println("Không tìm thấy sinh viên");
            return null;
        }
        return optionalStudent.get();
    }

    @Transactional
    public String save(StudentDTO studentDTO) {

        Student student = studentMapper.toEntity(studentDTO);


        Clazz clazz = clazzMapper.toEntity(studentDTO.getClazz());


        clazz = clazzRepository.save(clazz);


        student.setClazz(clazz);
        studentRepository.save(student);

        return "Thêm thành công";
    }


    public String update(StudentDTO studentDTO) {
        boolean existsStudent = studentRepository.existsById(id);
//        Clazz clazz = clazzRepository.findById(studentDTO.getClazz().getId());

        if (!existsStudent) return "Không có sinh viên có id = " + id;
        Student student = new Student();
        student.setId(id);
        student.setAddress(studentDTO.getAddress());
        studentRepository.save(student);
        return "cập nhật thành công";

    }

    @Transactional
    public String delete(int id) {

        boolean existsStudent = studentRepository.existsById(id);

        if (!existsStudent) {
            return "Không có sinh viên có id = " + id;
        }


        studentRepository.deleteById(id);

        return "Xóa thành công";
    }

    public List<IStudentPoint> finIStudentId (int id){
        return studentRepository.findStudentByAddress(id);
    }
    public List<IAvgPoint> finIAgvPoint (int id){
        return studentRepository.findavgPoint(id);
    }

}
