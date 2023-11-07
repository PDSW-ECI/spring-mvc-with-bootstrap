package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.ToDoItem;
import co.edu.escuelaing.cvds.lab7.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    public void addToDoItem(ToDoItem toDoItem) {
        toDoItemRepository.save(toDoItem);
    }

    public Integer getCompleted() {
        return toDoItemRepository.findByCompleted(true).size();
    }

    public Integer getNotCompleted() {
        return toDoItemRepository.findByCompleted(false).size();
    }
}
