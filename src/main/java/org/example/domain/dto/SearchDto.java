package org.example.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 7991624458665817541L;

    private String searchResearchGroupId;
    private String searchUserId;
    private String searchStartDate;
    private String searchEndDate;
}
