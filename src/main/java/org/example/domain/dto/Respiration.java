package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Respiration extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -6189367076549488168L;
    private String id;
    private String userId;
    private DateTime timestamp;
    private Integer timestampMs;
    private Integer offsetInSec;
    private String source;
    private Integer value;
}
