package com.web.futureroi.domain.mindTest;


import com.web.futureroi.common.RegisterDateBaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MindTest extends RegisterDateBaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mindTestId;

    private String type;

    private int mindTestOrder;

    private String isUse;

    @OneToMany(mappedBy = "mindTest")
    private List<MindTestEntry> mindTestEntries = new ArrayList<>();
}
