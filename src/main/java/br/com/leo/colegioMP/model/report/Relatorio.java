package br.com.leo.colegioMP.model.report;
import org.hibernate.annotations.Cascade;
import org.springframework.http.ResponseEntity;
import br.com.leo.colegioMP.model.teacher.Professor;
import br.com.leo.colegioMP.relatorioDto.AtualizarRelatorio;
import br.com.leo.colegioMP.relatorioDto.CadastroRelatorio;
import br.com.leo.colegioMP.relatorioDto.StatusRelatorio;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Entity(name = "Relatorio")
@Table(name = "relatorios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String materia;
    private String mensagem;
    private LocalDate dataCriacao = LocalDate.now();
    private LocalDate dataAlteracao;
    @ManyToOne
    @JoinColumn(name = "id_professor")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Professor professor;

    @Enumerated(EnumType.STRING)
    private StatusRelatorio statusRelatorio;


    public Relatorio(CadastroRelatorio dados) {
        this.titulo = dados.titulo();
        this.materia = dados.materia();
        this.mensagem = dados.mensagem();
        this.professor = dados.professor();
        this.statusRelatorio = dados.status();

    }

    public ResponseEntity<Relatorio> atualizarRelatorio(AtualizarRelatorio dados) {
        if (dados.getTitulo() != null && !dados.getTitulo().isEmpty()) {
            this.titulo = dados.getTitulo();
        }
        if (dados.getMensagem() != null && !dados.getMensagem().isEmpty()) {
            this.mensagem = dados.getMensagem();
        }
        this.dataAlteracao = LocalDate.now();
        return ResponseEntity.ok().body(this);
    }
}
