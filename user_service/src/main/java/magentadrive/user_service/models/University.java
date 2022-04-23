package magentadrive.user_service.models;


import lombok.Getter;
import magentadrive.user_service.models.enums.EUniversity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "university")

public class University {

    @Getter
    @Id
    @Column(name = "university_Id", nullable = false)
    private int id;

    @NotNull
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "university_Name")
    EUniversity name;

    @Getter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "university_course",
            joinColumns = @JoinColumn(name = "university_Id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();
}
