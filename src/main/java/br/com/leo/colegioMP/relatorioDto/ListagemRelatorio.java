package br.com.leo.colegioMP.relatorioDto;
import br.com.leo.colegioMP.model.report.Relatorio;
import br.com.leo.colegioMP.model.teacher.Professor;
import java.time.LocalDate;

public record ListagemRelatorio(
        Long id,
        String titulo,
        String mensagem,
        String materia,
        Professor professor,
        LocalDate dataCriacao,
        LocalDate dataAlteracao
) {

    public ListagemRelatorio(Relatorio relatorio) {
        this(
                relatorio.getId(),
                relatorio.getTitulo(),
                relatorio.getMensagem(),
                relatorio.getMateria(),
                relatorio.getProfessor(),
                relatorio.getDataCriacao(),
                relatorio.getDataAlteracao()
        );
    }
}






