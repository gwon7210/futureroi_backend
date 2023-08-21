package com.web.futureroi.domain.consultationTicket;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ConsultationTicket {

    @Id
    private String uuid;

    private Long  ticketCount;
}
