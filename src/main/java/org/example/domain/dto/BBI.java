package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class BBI extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -6093446429928087446L;
    private String id;
    private String userId;
    private DateTime startTime;
    private Integer timestamp;
    private Integer value;
}
