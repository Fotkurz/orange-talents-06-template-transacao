package br.com.zupacademy.guilherme.transacao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class TransacaoListenerDto {

    private String id;
    private Double valor;
    private Map<String, String> estabelecimento;
    private Map<String, String> cartao;
    private String efetivadaEm;

    @Deprecated
    public TransacaoListenerDto(){}

    @JsonCreator
    public TransacaoListenerDto(@JsonProperty("id") String id,
                                @JsonProperty("valor") Double valor,
                                @JsonProperty("estabelecimento") Map<String, String> estabelecimento,
                                @JsonProperty("cartao") Map<String, String> cartao,
                                @JsonProperty("efetivadaEm") String efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public Map<String, String> getEstabelecimento() {
        return estabelecimento;
    }

    public Map<String, String> getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "TransacaoListenerDto{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm='" + efetivadaEm + '\'' +
                '}';
    }

    public Transacao toModel() {
        Map<String, String> estabelecimentoMap = getEstabelecimento();
        Estabelecimento estabelecimento = new Estabelecimento(
                estabelecimentoMap.get("nome"),
                estabelecimentoMap.get("cidade"),
                estabelecimentoMap.get("endereco")
                );

        Cartao cartao = new Cartao(getCartao().get("id"), getCartao().get("email"));

        return new Transacao(this.id, this.valor, estabelecimento, cartao, this.efetivadaEm);
    }
}
