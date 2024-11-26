package br.com.leo.colegioMP.Controller;

import br.com.leo.colegioMP.model.report.Relatorio;
import br.com.leo.colegioMP.relatorioDto.*;
import br.com.leo.colegioMP.repository.RelatorioRepository;
import br.com.leo.colegioMP.service.RelatorioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioRepository repository;
    @Autowired
    private RelatorioService service;


    @GetMapping("/{id}")
    public ResponseEntity<Relatorio> buscarRelatorioPorId(@PathVariable Long id) {
        Relatorio relatorio = service.buscarRelatorioPorId(id);
        return ResponseEntity.ok(relatorio);
    }

    @PostMapping
    public ResponseEntity<Relatorio> cadastrar(@RequestBody @Valid CadastroRelatorio dados) {
        Relatorio salvo = service.cadastrarRelatorio(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Relatorio> atualizarRelatorio(@PathVariable Long id, @RequestBody AtualizarRelatorio dados) {
        Relatorio relatorioAtualizado = service.atualizarRelatorio(id, dados);
        return ResponseEntity.ok(relatorioAtualizado);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluirRelatorio(id);
        return ResponseEntity.noContent().build();
    }
}



