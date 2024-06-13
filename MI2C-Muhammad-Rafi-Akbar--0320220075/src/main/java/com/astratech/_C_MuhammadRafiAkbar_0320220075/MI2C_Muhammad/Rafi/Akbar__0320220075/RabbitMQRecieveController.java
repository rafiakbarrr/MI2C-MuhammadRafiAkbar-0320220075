package com.astratech._C_MuhammadRafiAkbar_0320220075.MI2C_Muhammad.Rafi.Akbar__0320220075;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMQRecieveController {
    private static final String queue = "AkbarQueue";
    private static final String queue2 = "RizkyQueue";

    @RabbitListener(queues = queue)
    public void processMessage(String message) {
        System.out.println("Pesan dari Akbar: " + message);
    }
    @RabbitListener(queues = queue2)
    public void processMessage2(String message) {
        System.out.println("Pesan dari Rizky: " + message);
    }
}
