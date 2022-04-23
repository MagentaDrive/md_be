package magentadrive.post_service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tag")
public class Tag {

    @Getter
    @Setter
    @Id
    private String name;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    @Getter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "post_tag",
            joinColumns = @JoinColumn(name = "name"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private Set<Post> post = new HashSet<>();
}
