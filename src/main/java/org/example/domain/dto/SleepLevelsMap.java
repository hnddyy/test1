package org.example.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class SleepLevelsMap extends SearchDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -7158899076278679972L;
    private BaseDateTime light;
    private BaseDateTime deep;
    private BaseDateTime rem;
}
