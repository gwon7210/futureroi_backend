package com.web.futureroi.domain.mindTest;


import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;


@Data
@Embeddable
public class MindTestEntryUserId implements Serializable {

    @Column
    private String uuid;

    @Column
    private Long mindTestEntryId;
}
