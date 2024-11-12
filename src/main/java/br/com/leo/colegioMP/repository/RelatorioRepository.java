package br.com.leo.colegioMP.repository;


import br.com.leo.colegioMP.model.report.Relatorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {

    Page<Relatorio> findAllBy(Pageable paginacao);

}

