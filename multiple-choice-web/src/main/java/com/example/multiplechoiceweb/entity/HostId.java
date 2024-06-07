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
public class HostId implements java.io.Serializable {
    private static final long serialVersionUID = -3615776701705819374L;
    @Column(name = "classID", nullable = false, length = 40)
    private String classID;

    @Column(name = "hostID", nullable = false, length = 40)
    private String hostID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HostId entity = (HostId) o;
        return Objects.equals(this.classID, entity.classID) &&
                Objects.equals(this.hostID, entity.hostID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classID, hostID);
    }

}