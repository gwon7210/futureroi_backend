package com.web.futureroi.domain.mindTest;


import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;


@Data
@Embeddable
public class MindTestEntryId implements Serializable {

    @Column
    private Long mindTestId;

    @Column
    private Long mindTestEntryId;
}
