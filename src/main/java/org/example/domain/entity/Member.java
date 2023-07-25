package org.example.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "member", schema = "public")
@DynamicInsert
@DynamicUpdate
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Member implements Serializable {

    @Serial
    private static final long serialVersionUID = 8598899065152405773L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    private Integer age;
    @Column(name = "group_id")
    private String groupId;
}
