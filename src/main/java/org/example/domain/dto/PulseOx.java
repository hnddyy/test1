package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class PulseOx extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 3917964214432592780L;
    private String id;
    private DateTime startTime;
    private String calendarDate;
    private Integer value;
}
