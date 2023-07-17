package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class BaseDateTime implements Serializable {
    @Serial
    private static final long serialVersionUID = -7394227481254609651L;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private Integer second;
    private Integer startTimeInSeconds;
    private Integer startTimeOffsetInSeconds;
    private Integer endTimeInSeconds;
    private Integer duration;
}
