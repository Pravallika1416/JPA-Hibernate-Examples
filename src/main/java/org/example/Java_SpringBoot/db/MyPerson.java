package org.example.Java_SpringBoot.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MyPerson
{
 @Id
 //@GeneratedValue(strategy = GenerationType.UUID)

 //@GeneratedValue(strategy = GenerationType.IDENTITY)
 @GeneratedValue(strategy = GenerationType.TABLE) //most imp....is maintained by springboot......it generates a sequence
 //@GenericGenerator(name = "sequency-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",parameters = )
 private Integer id; // primary key
    private String name;
    private int age;
    @Transient
    private String password;
    @Column(unique = true,nullable = false)
    private String email;
    private transient String temp2="temp2";
    @Column(name="lName")
    private String lname;
}
