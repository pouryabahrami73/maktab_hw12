package domains;

import base.domians.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role extends BaseEntity{

    @Column(name = "id", updatable = false, nullable = false)
    private long userId;
    @Column
    private String title;

    public Role(Serializable id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long id) {
        this.userId = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
