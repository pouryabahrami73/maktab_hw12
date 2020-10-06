package base.domians;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
@MappedSuperclass
public class BaseEntity<PK extends Serializable> implements Serializable {
    @Id
    @Type(type = "PK")
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private PK id;

    public BaseEntity(PK id) {
        this.id = id;
    }

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
}
