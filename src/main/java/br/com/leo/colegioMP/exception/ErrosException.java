package br.com.leo.colegioMP.exception;

import br.com.leo.colegioMP.repository.RelatorioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestControllerAdvice
public class ErrosException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroResposta> tratarErro404(EntityNotFoundException e) {
        ErroResposta erro = new ErroResposta("Registro não encontrado", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResposta> tratarErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        List<ErroResposta.DadosErroValidacao> erroRespostas = erros.stream()
                .map(erro -> new ErroResposta.DadosErroValidacao(erro.getField(), erro.getDefaultMessage(), erro.getRejectedValue()))
                .toList();
        ErroResposta resposta = new ErroResposta("Erro de validação, ID pode esta Incorreto !", erroRespostas.toString());

        return ResponseEntity.badRequest().body(resposta);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResposta> tratarErro400(HttpMessageNotReadableException ex) {
        ErroResposta erro = new ErroResposta("Erro de digitação verifique a forma de preenchimento ", ex.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> tratarErro500(Exception ex) {
        ErroResposta erro = new ErroResposta(
                "Erro interno do servidor,Verifique seu Endereço Web Digitado por Exemplo !",
                ex.getLocalizedMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}



