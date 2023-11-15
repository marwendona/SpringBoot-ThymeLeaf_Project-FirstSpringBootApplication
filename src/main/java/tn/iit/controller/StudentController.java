package tn.iit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tn.iit.dto.StudentDto;
import tn.iit.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping({"/",""})
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", studentService.findAll());
        modelAndView.setViewName("students");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name, @RequestParam(name = "gender") Character gender){
        StudentDto studentDto = new StudentDto(id, name, gender);
        studentService.save(studentDto);

        return "redirect:/students/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        studentService.delete(id);
        return "redirect:/students/";
    }

    @ResponseBody //pour dire que la methode ne retourne pas du HTML
    @PostMapping("/delete-ajax")
    public void deleteAjax(@RequestParam(name = "id") int id) {
        studentService.delete(id);
    }

    @PostMapping("/edit")
    public String edit(@RequestParam(name = "id") int id, Model model) {
        StudentDto studentDto = studentService.findById(id);
        model.addAttribute("student", studentDto);

        return "edit-student";
    }

    @PostMapping("/update")
    public String update(@RequestParam(name = "id") int id, @ModelAttribute StudentDto studentDto) {
        studentService.update(studentDto);

        return "redirect:/students/";
    }

    @PostMapping({ "/search" })
    public ModelAndView findAllByName(@RequestParam(name = "name") String name) {
        ModelAndView modelAndView = new ModelAndView();
        if (!"".equals(name)) {
            modelAndView.addObject("students", studentService.findAllByName(name));
        } else {
            modelAndView.addObject("students", studentService.findAll());
        }
        modelAndView.setViewName("students");// va a la page students.html

        return modelAndView;
    }
}
