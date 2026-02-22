package com.gotech.sboot_crm.service;

import com.gotech.sboot_crm.model.Item;
import com.gotech.sboot_crm.model.ItemOrcamento;
import com.gotech.sboot_crm.model.Orcamento;
import com.gotech.sboot_crm.repository.ItemOrcamentoRepository;
import com.gotech.sboot_crm.repository.ItemRepository;
import com.gotech.sboot_crm.repository.OrcamentoRepository;
import com.gotech.sboot_crm.service.type.DocType;
import com.gotech.sboot_crm.service.type.Status;

import javax.swing.text.DateFormatter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.gotech.sboot_crm.service.type.DocType.ORC;

public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;
    private final ItemRepository itemRepository;
    private final ItemOrcamentoRepository itemOrcamentoRepository;
    private final ItemService itemService;
    private String response;

    public OrcamentoService (OrcamentoRepository orcamentoRepository, ItemRepository itemRepository, ItemOrcamentoRepository itemOrcamentoRepository, ItemService itemService) {
        this.orcamentoRepository = orcamentoRepository;
        this.itemRepository = itemRepository;
        this.itemOrcamentoRepository = itemOrcamentoRepository;
        this.itemService = itemService;
    }

    public String getOrcamento(Long id) {
        try {
            response = orcamentoRepository.findById(id).toString();
        } catch (Exception e) {
            response = "Falha ao encontrar orçamento: " + e.getMessage();
        }
        return response;
    }

    public String criarOrcamento(Orcamento orcamento) {
        if(!orcamento.isValid(orcamento)) return "Falha no formulário de orçamento.";
        try {
            double soma = 0;
            verificarItens(orcamento.getItemOrcamento().getItemList());
            itemOrcamentoRepository.save(orcamento.getItemOrcamento());
            orcamento.setNomeOrcamento(criarNomeOrcamento(orcamento));
            orcamento.setCreatedDate(Date.from(Instant.now()));
            orcamento.setStatusOrcamento(Status.EM_ANALISE);
            orcamento.setPreco(soma(orcamento.getItemOrcamento().getItemList()));
            orcamentoRepository.save(orcamento);
            response = "Sucesso ao salvar orçamento.";
        } catch (Exception e) {
            response = "Falha ao salvar orçamento: " + e.getMessage();
        }
        return response;
    }

    public String excluirOrcamento(Orcamento orcamento) {
        if(!orcamento.isValid(orcamento)) return "Orçamento inválido";
        try {
            orcamentoRepository.delete(orcamento);
            response = "Orçamento excluido com sucesso.";
        } catch (Exception e) {
            response = "Houve uma falha em excluir o orçamento. Mensagem de erro: " + e.getMessage();
        }
        return response;
    }

    public void verificarItens(List<Item> item) {
        item.forEach(i -> {
            Optional<Item> j = itemRepository.findById(i.getId());
            if(j.isEmpty()) {
                itemService.saveItems(item);
            }
        });
    }

    public double soma(List<Item> item) {
        double soma = 0;
        for(Item i: item) {
            soma = soma + i.getPreco();
        }
        return soma;
    }

    public String criarNomeOrcamento (Orcamento orcamento){
        return ORC.toString()+orcamento.getId();
    }

    public String alterarStatusOrcamento (Orcamento orcamento, String nome) {
        try {
            Optional<Orcamento> toChange = orcamentoRepository.findById(orcamento.getId());
            toChange.ifPresent(value -> value.setStatusOrcamento(Status.valueOf(nome)));
            response = "Sucesso ao alterar status do orçamento";
        } catch (Exception e) {
            response = "Falha ao alterar status do orçamento: " + e.getMessage();
        }
        return response;
    }
}
