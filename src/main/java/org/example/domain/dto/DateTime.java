package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class DateTime implements Serializable {
    @Serial
    private static final long serialVersionUID = -6276024722873943030L;
    BaseDateTime date;
    BaseDateTime time;
}
