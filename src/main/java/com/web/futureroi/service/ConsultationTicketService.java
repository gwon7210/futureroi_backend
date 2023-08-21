package com.web.futureroi.service;

import com.web.futureroi.repository.ConsultationTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultationTicketService {

    private final ConsultationTicketRepository consultationTicketRepository;


}
