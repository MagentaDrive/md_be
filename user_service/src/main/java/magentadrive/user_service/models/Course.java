package magentadrive.user_service.models;


import lombok.Getter;
import lombok.Setter;
import magentadrive.user_service.models.enums.ECourse;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "course")

public class Course {

    @Getter
    @Setter
    @Id
    @Column(name = "course_id", nullable = false)
    private int id;

    @Getter
    @Setter
    @NotNull
    @Enumerated(value = EnumType.STRING)
    ECourse name;

    @Getter
    @Setter
    @NotNull
    private int course_begin;


}
