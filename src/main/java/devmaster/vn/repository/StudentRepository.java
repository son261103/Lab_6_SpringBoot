package devmaster.vn.repository;

import devmaster.vn.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student where address like concat('%', :address, '%')", nativeQuery = true)
    List<Student> findByAddress(@Param("address") String address);

    // Thêm mới sinh viên
    @Modifying
    @Query(value = "INSERT INTO Student (first_name, last_name, address, clazz_id) VALUES (:firstName, :lastName, :address, :clazzId)", nativeQuery = true)
    void insertStudent(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("address") String address, @Param("clazzId") int clazzId);

    // Sửa thông tin sinh viên
    @Modifying
    @Query(value = "UPDATE Student SET first_name = :firstName, last_name = :lastName, address = :address WHERE id = :id", nativeQuery = true)
    void updateStudent(@Param("id") int id, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("address") String address);

    // Xóa sinh viên theo id
    @Modifying
    @Query(value = "DELETE FROM Student WHERE id = :id", nativeQuery = true)
    void deleteStudent(@Param("id") int id);

}
