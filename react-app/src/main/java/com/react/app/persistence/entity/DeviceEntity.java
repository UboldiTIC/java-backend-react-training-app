package com.react.app.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "device")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public class DeviceEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_device", nullable = false)
    private Integer idDevice;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(name= "status", nullable = false, columnDefinition = "TINYINT")
    private Boolean inUse;

}
