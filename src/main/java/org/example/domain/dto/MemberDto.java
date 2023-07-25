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
public class MemberDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 9073655881199093631L;

    private String searchResearchGroupId;
    private String searchUserId;
    private String searchUserName;
    private String id;
    private String name;
    private Integer age;
    private String groupId;
}
