package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class StepLog extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -8857801671364362177L;
    private String id;
    private String userId;
    private DateTime timestamp;
    private Integer timestampMs;
    private Integer offsetInSec;
    private Integer stepCount;
    private Integer totalCount;
}
