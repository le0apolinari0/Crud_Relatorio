package br.com.leo.colegioMP.Controller;

import br.com.leo.colegioMP.relatorioDto.ListagemRelatorio;
import br.com.leo.colegioMP.repository.RelatorioRepository;
import br.com.leo.colegioMP.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listar")
public class LIstarRelatorioController {

    @Autowired
    private RelatorioRepository repository;

    @GetMapping
    public ResponseEntity<Page<ListagemRelatorio>> listarRelatorios(
            @PageableDefault(size = 10 , sort = {"dataCriacao"}) Pageable paginacao) {
        return ResponseEntity.ok(repository.findAllBy(paginacao).map(
                relatorio -> new ListagemRelatorio(relatorio)
        ));
    }
}
