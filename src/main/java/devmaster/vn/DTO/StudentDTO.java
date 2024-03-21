package devmaster.vn.DTO;

import devmaster.vn.mapper.ClazzMapper;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentDTO {
    private Integer id;
    private String name;
    private String address;
    private ClazzDTO clazz;

}
