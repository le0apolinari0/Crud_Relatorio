package br.com.leo.colegioMP.service;

import br.com.leo.colegioMP.relatorioDto.AtualizarRelatorio;
import br.com.leo.colegioMP.relatorioDto.CadastroRelatorio;
import br.com.leo.colegioMP.model.report.Relatorio;
import br.com.leo.colegioMP.repository.RelatorioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class RelatorioService {

    private final RelatorioRepository repository;

    @Autowired
    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }

    public Relatorio buscarRelatorioPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Relatório não encontrado"));
    }
    public Relatorio cadastrarRelatorio(CadastroRelatorio dados) {
        Relatorio relatorio = new Relatorio(dados);
        return repository.save(relatorio);
    }
    @Transactional
    public Relatorio atualizarRelatorio(AtualizarRelatorio dados) {
        Relatorio relatorioExistente = repository.findById(dados.getId()).orElseThrow();
        relatorioExistente.atualizarRelatorio(dados);
        return repository.save(relatorioExistente);
    }

    public void excluirRelatorio(Long id) {
        verificarExistenciaRelatorio(id);
        repository.deleteById(id);
    }
    private void verificarExistenciaRelatorio(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Relatório não encontrado");
        }
    }
}


