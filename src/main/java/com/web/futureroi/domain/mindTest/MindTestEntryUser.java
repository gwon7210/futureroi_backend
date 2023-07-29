package com.web.futureroi.domain.mindTest;


import com.web.futureroi.common.RegisterDateBaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@IdClass(MindTestEntryUserId.class)
public class MindTestEntryUser extends RegisterDateBaseTimeEntity {

    @Id
    private String uuid;

    @Id
    private Long mindTestId;

    @Id
    private Long mindTestEntryId;
}
