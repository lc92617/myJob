package org.example.consumer;

import com.alibaba.fastjson.JSON;
import org.example.domain.book.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * 批量的并发消费者
 * 1、手动提交offset保证消息被确实的消费
 * 2、业务逻辑保证幂等性
 */
@Slf4j
@Component
public class ConcurrentConsumer {

    /**
     * containerFactory: ${配置文件中消费者名字}ListenerContainerFactory
     * groupId: 建议${spring.application.name} 或 ${spring.application.name}_${配置文件中消费者名字}
     */
    @KafkaListener(topics = "createBookTopic", groupId = "${spring.application.name}_concurrentConsumer", containerFactory = "concurrentConsumerListenerContainerFactory")
    public void consume(ConsumerRecords<String, String> records, Acknowledgment ack, Consumer consumer) {
        try {
            for (ConsumerRecord<String, String> record : records) {
                // 业务逻辑需要保证消息处理的幂等性
                Book book = JSON.parseObject(record.value(), Book.class);
                log.info("handle message succeed. topic:{} key:{} value:{} partition:{} offset:{} msg:{}", record.topic(), record.key(), record.value(), record.partition(), record.offset(), book);
            }
        } finally {
            ack.acknowledge();
        }
    }

}
