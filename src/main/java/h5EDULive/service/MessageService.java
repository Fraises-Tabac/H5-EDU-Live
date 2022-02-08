package h5EDULive.service;

import h5EDULive.dao.domain.Message;

import java.util.List;

public interface MessageService {
    String sendMessage(Message message);
    List<Message> receiveMessages();
    String removeMessage(int messageId);
}
