package com.web.futureroi.domain.mindTest;


import com.web.futureroi.common.RegisterDateBaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@IdClass(MindTestEntryId.class)
public class MindTestEntry extends RegisterDateBaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mindTestId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mindTestEntryId;

    private Long mindTestEntryOrder;

    private String question;

    private String isUse;

    @ManyToOne
    @JoinColumn(name="mindTestId")
    private MindTest mindTest;


}
