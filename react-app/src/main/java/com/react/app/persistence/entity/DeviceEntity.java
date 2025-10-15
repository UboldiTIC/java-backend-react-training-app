package com.react.app.persistence.entity;

import com.react.app.persistence.audit.AuditDeviceListener;
import com.react.app.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@Entity
@Table(name = "device")
@EntityListeners({AuditingEntityListener.class, AuditDeviceListener.class})
@Getter
@Setter
@NoArgsConstructor
public class DeviceEntity extends AuditableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device", nullable = false)
    private Integer idDevice;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(name= "status", nullable = false, columnDefinition = "TINYINT")
    private Boolean inUse;

    /*Auditoría personalizada*/

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "idDevice=" + idDevice +
                ", name='" + name + '\'' +
                ", inUse=" + inUse +
                '}';
    }
}
