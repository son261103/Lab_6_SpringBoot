package devmaster.vn.DTO;

import devmaster.vn.mapper.ClazzMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String name;
    private String address;
    private ClazzDTO clazz;
    List<SubjectDTO> subjectDTOS = new ArrayList<>();
}
