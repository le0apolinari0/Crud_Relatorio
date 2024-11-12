package br.com.leo.colegioMP.relatorioDto;

import br.com.leo.colegioMP.model.teacher.Professor;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;



public record CadastroRelatorio(
        @NotBlank
        @NotEmpty(message = "Campo Titulo do Relatorio deve estar preenchido")
        @Valid
        String titulo,

        @NotBlank
        @NotEmpty(message = "Campo Materia deve estar preenchido")
        String materia,

        @NotBlank
        @NotEmpty (message = "Campo Mesagem deve estar preenchido")
        String mensagem ,

        @NotNull
        @NotEmpty(message = "Campo Status deve estar preenchido")
         StatusRelatorio status,

        @NotNull
        @NotEmpty(message = "Os Dados do professor são obrigatórios")
        @Valid
        Professor professor) {

}
