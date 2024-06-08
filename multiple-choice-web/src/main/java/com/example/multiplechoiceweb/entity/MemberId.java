package com.example.multiplechoiceweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class MemberId implements java.io.Serializable {
    private static final long serialVersionUID = -5995456754741118837L;
    @Column(name = "classID", nullable = false, length = 40)
    private String classID;

    @Column(name = "userID", nullable = false, length = 40)
    private String userID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MemberId entity = (MemberId) o;
        return Objects.equals(this.classID, entity.classID) &&
                Objects.equals(this.userID, entity.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classID, userID);
    }

}