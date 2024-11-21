package org.example.Java_SpringBoot.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DBController {

    @Autowired
    private DbService dbService;

    @GetMapping("/getPersons")
    public List<Person> getPersonData() {
        return dbService.getPersonData();
    }

    @PostMapping("/addPerson")
    public int addPersonData(@RequestBody Person person) {
        return dbService.addPersonData(person);
    }
}
