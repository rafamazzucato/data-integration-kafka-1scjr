package br.com.fiap.dataintegration.kafkaconsumer.consumer

import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Slf4j
@RequiredArgsConstructor
@Service
class TopicConsumer {
    @Value("\${topic.name.consumer}")
    private val topicName: String = ""

    @KafkaListener(topics = ["\${topic.name.consumer}"], groupId = "group_id")
    fun consume(payLoad : ConsumerRecord<String, String>){
        println("Tópico: $topicName")
        println("Key: ${payLoad.key()}")
        println("Headers: ${payLoad.headers()}")
        println("Partition: ${payLoad.partition()}")
        println("Message: ${payLoad.value()}")
    }
}