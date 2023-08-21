package com.web.futureroi.repository;

import com.web.futureroi.domain.consultationTicket.ConsultationTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationTicketRepository extends JpaRepository<ConsultationTicket, Long> {
}
