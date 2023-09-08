package com.kuba.shooting.range.management.model.dto;

import com.kuba.shooting.range.management.model.Gun;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GunDTO {

    private Long id;
    private String commonName;
    private String gauge;
    private boolean available;
    private boolean action = false;

    public GunDTO(Gun gun) {
        this.id = gun.getId();
        this.commonName = gun.getCommonName();
        this.gauge = gun.getGauge();
        this.available = gun.isAvailable();
    }
}
