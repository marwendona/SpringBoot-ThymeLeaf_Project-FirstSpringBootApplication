package tn.iit.dto;

import lombok.*;
import lombok.EqualsAndHashCode.Include;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentDto {
    @Include
    private int id;
    private String name;
    private Character gender;
}
