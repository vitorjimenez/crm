package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Item;
import com.gotech.sboot_crm.model.ItemOrcamento;
import com.gotech.sboot_crm.model.Orcamento;
import com.gotech.sboot_crm.repository.ItemOrcamentoRepository;
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
    private final ItemOrcamentoRepository itemOrcamentoRepository;

    public OrcamentoService (OrcamentoRepository orcamentoRepository, ItemRepository itemRepository, ItemOrcamentoRepository itemOrcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
        this.itemRepository = itemRepository;
        this.itemOrcamentoRepository = itemOrcamentoRepository;
    }

    public void saveOrcamento (Orcamento orcamento) {
        try {
            ItemOrcamento itemOrcamento = new ItemOrcamento();
            itemOrcamento.setOrcamento(orcamento);
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
            ItemOrcamento itemOrcamento = new ItemOrcamento();
            itemOrcamento.setItemList(payload.getItens());
            itemOrcamento.setOrcamento(payload);
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
            itemOrcamentoRepository.save(itemOrcamento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String criarNomeOrcamento (Orcamento orcamento){
        return ORC.toString()+orcamento.getId();
    }

}
