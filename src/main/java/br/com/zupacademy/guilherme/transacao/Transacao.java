package br.com.zupacademy.guilherme.transacao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "tbl_transactions")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idClient;
    private Double valor;
    @ManyToOne
    private Estabelecimento estabelecimento;
    @ManyToOne
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
        this.idClient = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return idClient;
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
