package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.ToDoItem;
import co.edu.escuelaing.cvds.lab7.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReportController {
    @Autowired
    ToDoService toDoService;

    @RequestMapping("/report")
    public String getToDoItem(Model model) {
        Integer completed = toDoService.getCompleted();
        Integer notCompleted = toDoService.getNotCompleted();
        model.addAttribute("completed", completed);
        model.addAttribute("notCompleted", notCompleted);
        return "report";
    }
}
