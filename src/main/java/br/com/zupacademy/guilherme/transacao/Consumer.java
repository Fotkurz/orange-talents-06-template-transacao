package br.com.zupacademy.guilherme.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private final Logger logger;

    public Consumer() {
        this.logger = LoggerFactory.getLogger(Consumer.class);
    }

    @KafkaListener(topics = "${spring.kafka.topic.transacoes}", groupId = "${spring.kafka.consumer.group-id}")
    public void processarMensagem(Transacao transacao) {
        logger.info("Consumindo mensagem {}", transacao);
    }
}
