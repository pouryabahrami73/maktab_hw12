package domains;

import base.domians.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role{

    @Column(name = "id", updatable = false, nullable = false)
    private long userId;
    @Column
    private String title;

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
