package com.springbootlab.service;

import com.solacesystems.jcsmp.*;
import com.springbootlab.model.Client;
import org.springframework.stereotype.Service;

@Service
public class SolaceService {

    public void sendMessage(String topic, String message) throws JCSMPException {

        final JCSMPSession session = getSolaceSession();

        XMLMessageProducer prod = session.getMessageProducer(new JCSMPStreamingPublishEventHandler() {
            @Override
            public void responseReceived(String messageID) {
                System.out.println("Producer received response for msg: " + messageID);
            }

            @Override
            public void handleError(String messageID, JCSMPException e, long timestamp) {
                System.out.printf("Producer received error for msg: %s@%s - %s%n",
                        messageID,timestamp,e);
            }
        });

        final Topic topicJCSMP = JCSMPFactory.onlyInstance().createTopic(topic);
        TextMessage msg = JCSMPFactory.onlyInstance().createMessage(TextMessage.class);

        final String text = message;
        msg.setText(text);
        prod.send(msg,topicJCSMP);


    }

    private JCSMPSession getSolaceSession() throws JCSMPException {
        final JCSMPProperties properties = new JCSMPProperties();
        properties.setProperty(JCSMPProperties.HOST, "tcp://mr6m7sc2dxjxl.messaging.solace.cloud:20192");
        properties.setProperty(JCSMPProperties.USERNAME, "solace-cloud-client");
        properties.setProperty(JCSMPProperties.PASSWORD, "q020sgdvvm1i5168u9o0fgeqfp");
        properties.setProperty(JCSMPProperties.VPN_NAME, "msgvpn-9xboqh9m7ot");
        final JCSMPSession session = JCSMPFactory.onlyInstance().createSession(properties);
        session.connect();
        return session;
    }


}
