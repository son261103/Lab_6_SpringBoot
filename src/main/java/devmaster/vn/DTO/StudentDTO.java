package devmaster.vn.DTO;

import devmaster.vn.mapper.ClazzMapper;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class StudentDTO {
    private Integer id;
    private String name;
    private String address;
    private ClazzDTO clazz;
    List<SubjectDTO> subjectDTOS = new ArrayList<>();
}
