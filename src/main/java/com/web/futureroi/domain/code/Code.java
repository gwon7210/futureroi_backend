package com.web.futureroi.domain.code;


import com.web.futureroi.common.RegisterDateBaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@IdClass(CodeId.class)
public class Code extends RegisterDateBaseTimeEntity {

    @Id
    private String code;

    @Id
    private String codeGroup;

    private int codeId;

    private String codeName;

    private int codeOrderNo;

    private int isUse;

    private String codeDescription;

}
