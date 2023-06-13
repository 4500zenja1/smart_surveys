package epolsoft.practice.smart_surveys.entity;

import epolsoft.practice.smart_surveys.enums.RoleType;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name",nullable = false,length = 50)
    private String name;
    @Column(name = "email",nullable = false,length = 30,unique = true)
    private String email;
    @Column(name = "password",nullable = false,columnDefinition = "text")
    private String password;
    @Column(name = "role_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role ;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    private List<Survey> surveys = new ArrayList<>();

    public void addSurvey(Survey survey) {
        surveys.add(survey);
    }
}
