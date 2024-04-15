package co.edu.escuelaing.cvds.lab7.controller;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/toList")
    public String toList(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        for (Employee e : employees){
            System.out.println(e.toString());
        }
        return "toIndex";
    }

    @GetMapping("/create")
    public String createEmployee(Model model){
        model.addAttribute("employees",new Employee());
        return "create";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/toList";
    }

    @GetMapping("/api/employees")
    @ResponseBody
    public List<Employee> exampleApiEmployees() {
        return employeeService.getAllEmployees();
    }


    @PostMapping("/api/employees")
    @ResponseBody
    public List<Employee> exampleApiEmployees(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employeeService.getAllEmployees();
    }

    @PostMapping("/save")
    public String save(String idEmployee, String firstName, String lastName, String role, double salary) {
        employeeService.addEmployee(new Employee(idEmployee, firstName, lastName, role, salary));
        return "redirect:/employee/toList";
    }
}
