package br.com.zupacademy.guilherme.transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class Consumer {

    private final Logger logger;
    @PersistenceContext
    private final EntityManager entityManager;

    public Consumer(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.logger = LoggerFactory.getLogger(Consumer.class);
    }

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transacoes}", groupId = "${spring.kafka.consumer.group-id}")
    public void processarMensagem(TransacaoListenerDto dto) {
        logger.info("Convertendo para domain");
        Transacao novaTransacao = dto.toModel();
        logger.info("Tentando persistir");
        entityManager.persist(novaTransacao);
    }
}
