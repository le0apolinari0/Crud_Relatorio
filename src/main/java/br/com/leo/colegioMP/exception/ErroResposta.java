package br.com.leo.colegioMP.exception;

import lombok.Getter;
@Getter
public class ErroResposta {

    private final String mensagem;
    private final String detalhe;

    public ErroResposta(
            String mensagem,
            String detalhe) {
        this.mensagem = mensagem;
        this.detalhe = detalhe;
    }

    public static class DadosErroValidacao {

        private final String campo;
        private final String mensagem;
        private final Object valorRejeitado;

        public DadosErroValidacao(
                String campo,
                String mensagem,
                Object valorRejeitado) {
            this.campo = campo;
            this.mensagem = mensagem;
            this.valorRejeitado = valorRejeitado;
        }
    }
}



