package com.gotech.sboot_crm.controller;

import com.gotech.sboot_crm.model.Orcamento;
import com.gotech.sboot_crm.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {

    @Autowired
    OrcamentoService orcamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrcamento(@PathVariable Long id) {
        return ResponseEntity.ok(orcamentoService.getOrcamento(id));
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarOrcamento(@RequestBody Orcamento orcamento) {
        return ResponseEntity.ok(orcamentoService.criarOrcamento(orcamento));
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<String> excluirOrcamento(@RequestBody Orcamento orcamento) {
        return ResponseEntity.ok(orcamentoService.excluirOrcamento(orcamento));
    }

    @PutMapping("/alterar")
    public ResponseEntity<String> alterarOrcamento(@RequestBody Orcamento orcamento) {
        return ResponseEntity.ok(orcamentoService.criarOrcamento(orcamento));
    }
}
