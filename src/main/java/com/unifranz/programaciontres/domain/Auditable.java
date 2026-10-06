package com.unifranz.programaciontres.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class Auditable {

    @Column(name = "user_create", updatable = false)
    private String userCreate;

    @Column(name = "user_update")
    private String userUpdate;

    @Column(name = "time_create", updatable = false)
    private LocalDateTime timeCreate;

    @Column(name = "time_update")
    private LocalDateTime timeUpdate;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @PrePersist
    public void prePersist() {
        this.timeCreate = LocalDateTime.now();
        this.deleted = false;
        if (this.userCreate == null) {
            this.userCreate = "Sistema";
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.timeUpdate = LocalDateTime.now();
        if (this.userUpdate == null) {
            this.userUpdate = "Sistema";
        }
    }
}