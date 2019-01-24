package com.onechurch.process.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.dom4j.tree.AbstractEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

/**
 * Created by dc-user on 4/20/2017.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {

    @Id
    @SequenceGenerator(sequenceName = "MY_CONFIG_SEQ", name = "MyConfSeq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MyConfSeq")
    private Long id;

    @NotEmpty
    @Column
    private String name;

    @NotEmpty
    @Column
    private String username;

    @NotEmpty
    @JsonIgnore
    @Column
    private String password;

    @NotNull
    private boolean admin;

}
