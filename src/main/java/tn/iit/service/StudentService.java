package tn.iit.service;

import org.springframework.stereotype.Service;
import tn.iit.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private List<StudentDto> students = new ArrayList<>();

    public StudentService() {
        students.add(new StudentDto(1, "Imed", 'M'));
        students.add(new StudentDto(2, "Sici", 'F'));
    }

    public List<StudentDto> findAll() {
        return students;
    }

    public void save(StudentDto studentDto) {
        students.add(studentDto);
    }

    public void delete(int id) {
        students.remove(new StudentDto(id, null, null));
    }

    public StudentDto findById(int id) {
        return students.stream().filter(std -> std.getId() == id).findAny().orElse(null);
    }

//    public void update(int id, StudentDto studentDto) {
//        StudentDto studentDtoFromDb = findById(id);
//
//        studentDtoFromDb.setName(studentDto.getName());
//        studentDtoFromDb.setGender(studentDto.getGender());
//    }

    //2eme methode
    public void update(StudentDto studentDto) {
        students.set(students.indexOf(studentDto), studentDto);
    }

    public List<StudentDto> findAllByName(String name) {
        return students.stream().filter(std -> std.getName().startsWith(name)).collect(Collectors.toList());
    }
}
