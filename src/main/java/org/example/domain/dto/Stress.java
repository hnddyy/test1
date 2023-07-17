package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Stress extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3860663534707024514L;
    private String id;
    private String userId;
    private DateTime startTime;
    private Integer startTimeInSeconds;
    private Integer startTimeOffsetInSeconds;
    private String source;
    private Integer stressLevelValue;
    private Integer averageIntensity;
    private Integer bodyBattery;
    private Integer bodyBatteryStatus;
    private String calendarDate;
}
