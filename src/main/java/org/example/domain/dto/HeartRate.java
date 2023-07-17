package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

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
}
