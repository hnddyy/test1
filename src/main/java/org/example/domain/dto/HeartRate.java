package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class HeartRate extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 4665890037955834955L;
    private String userId;
    private DateTime startTime;
    private Integer startTimeInSeconds;
    private Integer startTimeOffsetInSeconds;
    private String calendarDate;
    private Integer value;
    private LocalDateTime startDateTime;

    public LocalDateTime getStartDateTime() {
        BaseDateTime date = startTime.getDate();
        BaseDateTime time = startTime.getTime();
        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), time.getHour(), time.getMinute(), 0);
    }
}
