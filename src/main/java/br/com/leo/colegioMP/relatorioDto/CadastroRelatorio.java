package br.com.leo.colegioMP.relatorioDto;

import br.com.leo.colegioMP.model.teacher.Professor;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;



public record CadastroRelatorio(
        @NotBlank(message = "Campo Titulo do Relatorio deve estar preenchido")
        String titulo,

        @NotBlank(message = "Campo Materia deve estar preenchido")
        String materia,

        @NotBlank (message = "Campo Mesagem deve estar preenchido")
        String mensagem ,

        @NotNull(message = "Campo Status deve estar preenchido")
        StatusRelatorio status,

        @NotNull
        @Valid
        Professor professor) {

}
