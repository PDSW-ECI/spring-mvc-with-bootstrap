package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.ToDoItem;
import co.edu.escuelaing.cvds.lab7.service.ToDoService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {
    @Autowired
    ToDoService toDoService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/to-do-item/{id}")
    public String getToDoItem(@PathVariable Integer id, Model model) {
        ArrayList<ToDoItem> falsos = new ArrayList<>(); 
            
        List<ToDoItem> verdaderos= new ArrayList<>();
        for(int i =0; i<=200 ; i++){
            ToDoItem toDoItem = toDoService.getItem(id);
             if(toDoItem.getCompleted()){
                verdaderos.add(toDoItem);
             }else{ falsos.add(toDoItem);}  
        }
        ToDoItem toDoItem = toDoService.getItem(id);

        model.addAttribute("toDoItem", toDoItem);
        model.addAttribute("arrayV", verdaderos.size());
        model.addAttribute("arrayF", falsos.size());
        return "to-do-item";
    }
}
