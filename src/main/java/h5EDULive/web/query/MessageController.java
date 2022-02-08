package h5EDULive.web.query;

import h5EDULive.dao.domain.Message;
import h5EDULive.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;

    @RequestMapping("/homepage-message")
    public String message(){
        return "/message";
    }

    @RequestMapping("/homepage-message/send")
    @ResponseBody
    public String sendMessage(Message message){
        return messageService.sendMessage(message);
    }

    @RequestMapping("/homepage-message/receive")
    @ResponseBody
    public List<Message> receiveMessages(){
        return messageService.receiveMessages();
    }

    @RequestMapping("/homepage-message/remove")
    @ResponseBody
    public String removeMessage(int messageId){
        return messageService.removeMessage(messageId);
    }
}
