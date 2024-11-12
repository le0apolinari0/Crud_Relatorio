package br.com.leo.colegioMP.Controller;

import br.com.leo.colegioMP.model.report.Relatorio;
import br.com.leo.colegioMP.relatorioDto.*;
import br.com.leo.colegioMP.repository.RelatorioRepository;
import br.com.leo.colegioMP.service.RelatorioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping
    public ResponseEntity<Page<ListagemRelatorio>> listarRelatorios(
            @PageableDefault(size = 10 , sort = {"dataCriacao"}) Pageable paginacao) {
        return ResponseEntity.ok(repository.findAllBy(paginacao).map(
                relatorio -> new ListagemRelatorio(relatorio)
        ));
    }

    @PostMapping
    public ResponseEntity<Relatorio> cadastrar(@RequestBody @Valid CadastroRelatorio dados) {
        Relatorio salvo = service.cadastrarRelatorio(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping
    public ResponseEntity<Relatorio> atualizar(@RequestBody @Valid AtualizarRelatorio dados) {
        Relatorio relatorio = service.atualizarRelatorio(dados);
        return ResponseEntity.ok(relatorio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        service.excluirRelatorio(id);
        return ResponseEntity.noContent().build();
    }
}



