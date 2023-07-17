package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Activities extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 7332472072158677378L;
    private String id;
    private String userId;
    private String externalId; //optional
    private String source;
    private DateTime startDate;
    private DateTime endDate;
    private String type;
    private Integer duration;
    private Integer amount;
    private String unit;
    private Integer calories;
    private Integer distance;
    private Integer steps;
}
