package uk.ac.uwl.procrado.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Positive;
import jdk.jfr.Timestamp;

import java.time.LocalDateTime;

// It doesn't create a table in the database
@MappedSuperclass
public abstract class BaseEntity {
    // Table ID
    @Id
    // Increment ID on new entry
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Positive(message = "Cannot be negative")
    private Long id;
    @Timestamp
    private final LocalDateTime createdAt = LocalDateTime.now();

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
