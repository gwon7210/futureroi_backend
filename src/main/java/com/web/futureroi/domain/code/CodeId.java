package com.web.futureroi.domain.code;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;


@Data
@Embeddable
public class CodeId implements Serializable {

    @Column
    private String code;

    @Column
    private String codeGroup;
}
