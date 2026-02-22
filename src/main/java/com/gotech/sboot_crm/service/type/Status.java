package com.gotech.sboot_crm.service.type;


public enum Status {
    EM_CRIACAO("Em criação"),
    EM_ANALISE("Em análise"),
    APROVADO("Aprovado"),
    EM_ANDAMENTO("Em andamento"),
    PRONTO("Pronto");

    Status(String descricao) {
    }
}
