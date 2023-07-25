package org.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class FitrockrBodyId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1208027012565468825L;

    private String userId;
    private LocalDateTime startDateTime;

}
