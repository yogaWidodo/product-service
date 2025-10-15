package com.batch15.springboot.product.consumer

import com.batch15.springboot.product.constant.TopicKafka
import com.batch15.springboot.product.service.ProductService
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.JsonParser
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.KafkaHandler
import org.springframework.kafka.annotation.KafkaListener

@Configuration
class OrderManagementConsumer(
    private val productService: ProductService
) {
val log = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(
        containerFactory = "kafkaListenerContainerFactory",
        id = "UPDATE_QUANTITY_PRODUCT",
        topics = [TopicKafka.UPDATE_QUANTITY_PRODUCT]
    )
    @KafkaHandler
    fun updateQuantityProductHandler(message: String){
        log.info("Received message: $message from topic ${TopicKafka.UPDATE_QUANTITY_PRODUCT}")

        try {
            val mapper = jacksonObjectMapper()
            var json = mapper.readTree(message)

            // Kalau ternyata isinya masih string JSON (ter-escape), parse lagi
            if (json.isTextual) {
                json = mapper.readTree(json.asText())
            }

            val productId = json["productId"].asInt()
            val quantity = json["quantity"].asInt()

            productService.updateQuantityProduct(productId, quantity)
        } catch (ex: Exception) {
            log.error("Error processing message: $message", ex)
        }
    }

}