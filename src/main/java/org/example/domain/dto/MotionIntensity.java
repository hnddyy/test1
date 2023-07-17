package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class MotionIntensity extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3182857495356346899L;
    private String id;
    private String userId;
    private String activityType;
    private Integer durationInSeconds;
    private Integer startTimeInSeconds;
    private Integer startTimeOffsetInSeconds;
    private DateTime startTime;
    private Double motionIntensity;
}
