package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrcamentoService {

    @Autowired
    OrcamentoRepository orcamentoRepository;

    @Autowired
    ItensOrcamentoService service;

    public void criarOrcamento(){}


}
