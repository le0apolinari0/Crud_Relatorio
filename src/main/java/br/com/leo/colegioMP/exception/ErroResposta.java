package br.com.leo.colegioMP.exception;

import lombok.Getter;
@Getter
public class ErroResposta extends RuntimeException {
        private String codigo;
        private String detalhes;

        public ErroResposta(
                String mensagem,
                String codigo,
                String detalhes) {
            super(mensagem);
            this.codigo = codigo;
            this.detalhes = detalhes;
        }
}



