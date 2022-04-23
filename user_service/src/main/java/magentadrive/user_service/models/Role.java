package magentadrive.user_service.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import magentadrive.user_service.models.enums.ERole;
import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;


@Entity
@Table(name = "rolee")
@SQLInsert(sql = "../../../resources/data.sql")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @Getter
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role_name")
    ERole roleName;


}