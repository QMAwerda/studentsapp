package ru.kors.springstudents.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

// @Getter // чтобы не писать геттеры для каждого поля, мы генерируем их автоматически
//         // через lombock
// @Setter
// @NoArgsConstructor // конструктор по умолчанию
// @AllArgsConstructor // включает в себя все поля
// @RequiredArgsConstructor
@Data // берет в себя все аннотации выше + хеш код и equals(не знаю, зачем они)
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Column(unique = true)
    private String email;
    @Transient // должна генерировать возраст на основе даты рождения
    private int age;
}
