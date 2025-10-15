package com.react.app.persistence.audit;

import com.react.app.persistence.entity.ReservationEntity;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class AuditReservationListener {

    @PostPersist
    @PostUpdate
    public void onPostPersist(ReservationEntity entity) {
        System.out.println(entity.toString());
    }

    @PreRemove
    public void onPreDelete(ReservationEntity entity) {
        System.out.println(entity.toString());
    }
}
