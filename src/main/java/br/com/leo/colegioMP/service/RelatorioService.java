package br.com.leo.colegioMP.service;

import br.com.leo.colegioMP.relatorioDto.AtualizarRelatorio;
import br.com.leo.colegioMP.relatorioDto.CadastroRelatorio;
import br.com.leo.colegioMP.model.report.Relatorio;
import br.com.leo.colegioMP.repository.RelatorioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;




@Service
@CacheConfig(cacheNames = "relatorios")
public class RelatorioService {

    private final RelatorioRepository repository;

    @Autowired
    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }
    @Cacheable(value = "relatorios", key = "#id")
    public Relatorio buscarRelatorioPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Relatório não encontrado"));
    }
    public Relatorio cadastrarRelatorio(CadastroRelatorio dados) {
        Relatorio relatorio = new Relatorio(dados);
        return repository.save(relatorio);
    }
    @Transactional
    @CacheEvict(value = "relatorios", key = "#dados.getId")
    @CachePut(value = "relatorios", key = "#result.getId")
    public Relatorio atualizarRelatorio(Long id, AtualizarRelatorio dados) {
        Relatorio relatorioExistente = repository.findById(id).orElseThrow();
        relatorioExistente.atualizarRelatorio(dados);
        return repository.save(relatorioExistente);
    }


    @Transactional
    @CacheEvict(value = "relatorios", key = "#id")
    public ResponseEntity<String> excluirRelatorio(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Relatório não encontrado! Digite um ID válido");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Relatório excluído com sucesso. ID: " + id);
    }

}


