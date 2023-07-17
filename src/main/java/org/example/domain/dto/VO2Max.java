package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class VO2Max extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 2919700054123431050L;
    private String id;
    private String userId;
    private Integer timestamp;
    private Integer offsetInSec;
    private Integer vo2Max;
    private Integer fitnessAge;
}
