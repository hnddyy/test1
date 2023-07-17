package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Sleep extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 6598664187167655092L;
    private String id;
    private String userId;
    private List<String> tags; // day sleep, night sleep, nap or rem sleep
    private Boolean outdated;
    private DateTime sleepDay;
    private String summaryId;
    private String calendarDate;
    private DateTime processingDateTime;
    private DateTime startTime;
    private DateTime endTime;
    private Integer durationInSeconds;
    private Integer startTimeInSeconds;
    private Integer startTimeOffsetInSeconds;
    private Integer deepSleepDurationInSeconds;
    private Integer lightSleepDurationInSeconds;
    private Integer awakeDurationInSeconds;
    private Integer remSleepSeconds;
    private Integer unmeasurableSeconds;
    private Integer sleepSeconds;
    private Integer sleepEfficiency;
    private String source;
    private SleepLevelsMap SleepLevelsMap;
    private String validation;
}
