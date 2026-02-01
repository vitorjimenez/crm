package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Orcamento;
import com.gotech.sboot_crm.repository.OrcamentoRepository;
import com.gotech.sboot_crm.service.type.DocType;

public class OrcamentoService {

    private final OrcamentoRepository repository;
    private final ItensOrcamentoService service;
    private final DocType docType;

    public OrcamentoService (OrcamentoRepository repo, ItensOrcamentoService itemService, DocType doc) {
        this.repository = repo;
        this.service = itemService;
        this.docType = doc;
    }

    public void criarOrcamento(){}

    public String criarNomeOrcamento (Orcamento orcamento){

        return "ORC"+;
    }

}
