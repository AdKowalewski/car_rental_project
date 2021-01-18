package com.carrental.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
abstract class BaseEntity {

    @CreationTimestamp
    private LocalDate creationDate;

    @UpdateTimestamp
    private LocalDate modificationDate;

    @Version
    private long version;
}
