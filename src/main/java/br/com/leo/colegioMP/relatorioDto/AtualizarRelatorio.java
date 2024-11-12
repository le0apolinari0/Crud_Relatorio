package br.com.leo.colegioMP.relatorioDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;


@Getter
public class AtualizarRelatorio {
                @NotNull
                Long id;
                @NotNull
                String titulo;
                @NotNull
                String mensagem;
                StatusRelatorio statusRelatorio;
}


