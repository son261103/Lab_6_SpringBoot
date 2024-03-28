package devmaster.vn.mapper;

import devmaster.vn.DTO.SubjectDTO;
import devmaster.vn.Entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectMapper implements EntityMapper<Subject , SubjectDTO>{

    @Override
    public Subject toEntity(SubjectDTO dto) {
        return null;
    }

    @Override
    public SubjectDTO toDto(Subject entity) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(entity.getId());
        subjectDTO.setName(entity.getName());
        return subjectDTO;
    }

    @Override
    public List<Subject> toEntity(List<SubjectDTO> Dto) {

        return null;
    }

    @Override
    public List<SubjectDTO> toDto(List<Subject> entity) {
        List<SubjectDTO> dtos = new ArrayList<>();
        entity.forEach(item ->{
            SubjectDTO subjectDTO = toDto(item);
            dtos.add(subjectDTO);
        });
        return dtos;
    }
}
