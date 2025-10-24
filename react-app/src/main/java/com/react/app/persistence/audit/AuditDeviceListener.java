package com.react.app.persistence.audit;

import com.react.app.persistence.entity.DeviceEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.util.SerializationUtils;

public class AuditDeviceListener {

    private DeviceEntity currentValue;

    @PostLoad
    public void postLoad(DeviceEntity entity) {
        System.out.println("POST LOAD");
        this.currentValue = SerializationUtils.clone(entity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(DeviceEntity entity) {
        System.out.println("POST PERSIST OR UPDATE");
        //System.out.println("OLD VALUE: " + this.currentValue.toString());
        System.out.println("NEW VALUE: " + entity.toString());
    }

    @PostRemove
    public void onPreDelete(DeviceEntity entity) {
        System.out.println(entity.toString());
    }
}
