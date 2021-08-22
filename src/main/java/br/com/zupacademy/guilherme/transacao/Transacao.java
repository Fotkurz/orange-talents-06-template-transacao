package br.com.zupacademy.guilherme.transacao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Transacao {

    /**
     *
     * {
     *    "id":"c63fd0e0-eccb-4af3-9d49-39cde0ffdaf1",
     *    "valor":1.4874248222626738,
     *    "estabelecimento":{
     *       "nome":"B. A. Ware",
     *       "cidade":"North Winstonbury",
     *       "endereco":"18327 Mills Groves, West Marquita, SD 31244"
     *    },
     *    "cartao":{
     *       "id":"b0012b90-42c8-40e6-903b-64acb3aa649b",
     *       "email":"luram.archanjo@zup.com.br"
     *    },
     *    "efetivadaEm":"2020-08-10T13:16:56"
     * }
     *
     */

    private String id;
    private Double valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    private String efetivadaEm;

    @Deprecated
    public Transacao(){}

    @JsonCreator
    public Transacao(@JsonProperty("id") String id,
                     @JsonProperty("valor") Double valor,
                     @JsonProperty("estabelecimento") Estabelecimento estabelecimento,
                     @JsonProperty("cartao") Cartao cartao,
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

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm='" + efetivadaEm + '\'' +
                '}';
    }
}
