package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Intraday extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1894191799298862872L;
    private String id;
    private String userId;
    private DateTime startTime;
    private DateTime endTime;
    private Integer startTimeInSeconds;
    private Integer startTimeOffsetInSeconds;
    private Integer durationInSeconds;
    private Integer activeCalories;
    private Integer distance;
    private Integer activeSeconds;
    private String intensity;
    private Integer motionIntensity;
    private Integer meanMotionIntensity;
    private Integer maxMotionIntensity;
    private Integer averageStressLevel;
    private Integer maxStressLevel;
    private Integer minHeartRateInBeatsPerMinute;
    private Integer avgHeartRateInBeatsPerMinute;
    private Integer maxHeartRateInBeatsPerMinute;
    private String summaryId;
    private String activityType;
    private String calendarDate;
    private Integer steps;
}
