package com.react.app.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationEntityId implements Serializable {

    private Integer idUser;
    private Integer idDevice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationEntityId that)) return false;
        return Objects.equals(idUser, that.idUser) && Objects.equals(idDevice, that.idDevice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idDevice);
    }
}
