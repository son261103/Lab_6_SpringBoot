package devmaster.vn.repository;

import devmaster.vn.Entity.Student;
import devmaster.vn.ProjectTion.IAvgPoint;
import devmaster.vn.ProjectTion.IStudentPoint;
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


    @Query(value = "select   concat(s.last_name, '' , s.first_name) name,\n" +
            "s.address,\n" +
            "c.name,\n" +
            "s2.name,\n" +
            "ss.point\n" +
            "\n" +
            "from student s\n" +
            "left join clazz c on s.clazz_id = c.id\n" +
            "left join student_subject ss on s.id = ss.id_student\n" +
            "left join subject s2 on s2.id = ss.id_student\n" +
            "where s.id = 1;", nativeQuery = true )
    List<IStudentPoint> findStudentByAddress(@Param("id") int id);

    @Query(value = "SELECT\n" +
            "    s.id AS student_id,\n" +
            "    s.first_name AS first_name,\n" +
            "    s.last_name AS last_name,\n" +
            "    s.address AS address,\n" +
            "    AVG(ss.point) AS averagePoint\n" +
            "FROM\n" +
            "    student s\n" +
            "        LEFT JOIN\n" +
            "    student_subject ss ON s.id = ss.id_student\n" +
            "GROUP BY\n" +
            "    s.id, s.first_name, s.last_name;", nativeQuery = true)
    List<IAvgPoint> findavgPoint(@Param("id") int id);

}
