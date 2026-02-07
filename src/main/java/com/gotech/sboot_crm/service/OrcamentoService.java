package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Item;
import com.gotech.sboot_crm.model.Orcamento;
import com.gotech.sboot_crm.repository.ItemRepository;
import com.gotech.sboot_crm.repository.OrcamentoRepository;
import com.gotech.sboot_crm.service.type.DocType;
import com.gotech.sboot_crm.service.type.Status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gotech.sboot_crm.service.type.DocType.ORC;

public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;
    private final ItemRepository itemRepository;

    public OrcamentoService (OrcamentoRepository orcamentoRepository, ItemRepository itemRepository) {
        this.orcamentoRepository = orcamentoRepository;
        this.itemRepository = itemRepository;
    }

    public void saveOrcamento (Orcamento orcamento) {
        try {
            orcamento.setStatusOrcamento(Status.EM_CRIACAO);
            orcamento.setNomeOrcamento(criarNomeOrcamento(orcamento));
            orcamento.setCriadoPor(orcamento.getCriadoPor());
            orcamentoRepository.save(orcamento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void criarOrcamento(Orcamento payload){
        try {
            Orcamento orcamento = orcamentoRepository.findById(payload);
            List<Item> itemList = new ArrayList<>();
            payload.getItens().forEach( i -> {
                itemRepository.findById(i);
                itemList.add(i);
            });
            double soma = 0;
            for (Item item : itemList) {
                soma = soma + item.getPreco();
            }
            orcamento.setNomeOrcamento(criarNomeOrcamento(orcamento));
            orcamento.setStatusOrcamento(Status.EM_ANALISE);
            orcamento.setPreco(soma);
            orcamento.setCreatedDate(Date.from(Instant.now()));
            orcamentoRepository.save(orcamento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String criarNomeOrcamento (Orcamento orcamento){
        return ORC.toString()+orcamento.getId();
    }

}
