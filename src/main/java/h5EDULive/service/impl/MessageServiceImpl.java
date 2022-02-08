package h5EDULive.service.impl;

import h5EDULive.dao.MessageRepository;
import h5EDULive.dao.domain.Message;
import h5EDULive.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageRepository messageRepository;

    @Override
    public String sendMessage(Message message) {
        try {
            messageRepository.save(message);
        }
        catch (Exception e) {
            return "";
        }
        return "SUCCESS";
    }

    @Override
    public List<Message> receiveMessages() {
        return messageRepository.findAll();
    }

    @Override
    public String removeMessage(int messageId) {
        try {
            messageRepository.deleteById(messageId);
        }
        catch (Exception e) {
            return "";
        }
        return "SUCCESS";
    }
}
