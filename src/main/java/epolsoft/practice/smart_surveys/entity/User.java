package epolsoft.practice.smart_surveys.entity;

import epolsoft.practice.smart_surveys.enums.RoleType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 30, unique = true)
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "text")
    private String password;

    @Column(name = "role_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<AccessSurvey> accessSurveys = new ArrayList<>();
}
