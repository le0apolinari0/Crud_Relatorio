package br.com.leo.colegioMP.model.teacher;


import br.com.leo.colegioMP.model.report.Relatorio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Professor")
@Table(name = "professores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Professor {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String telefone;
        @OneToMany(mappedBy = "professor")
        @JsonIgnore
        private List<Relatorio> relatorios;

}