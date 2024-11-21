package org.example.Java_SpringBoot.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DbService {
    @Autowired
    @Qualifier("springJDBC")
    DBREpo dbRepository;
    @Autowired
    MyPersonJPaRepo myPersonJPaRepo;

    public List<Person> getPersonData() {
        return dbRepository.getPersonData();
    }

    public int addPersonData(Person person) {
        //convert person into myPerson........
        //service class...........business logicx
        MyPerson myPerson = MyPerson.builder().
                name(person.getName()).

                email(person.getName()+"@gmail.com").
                    age(10) .
                password("password").

                build();
        MyPerson p1=myPersonJPaRepo.save(myPerson);
        if(p1==null) return 0;
        else return 1;

    }
}
