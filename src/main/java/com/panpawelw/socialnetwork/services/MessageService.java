package com.panpawelw.socialnetwork.services;

import com.panpawelw.socialnetwork.entities.Message;
import com.panpawelw.socialnetwork.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

  private final MessageRepository repository;

  @Autowired
  public MessageService(MessageRepository repository) {
    this.repository = repository;
  }

  public Message findById(long id) {
    return repository.findById(id);
  }

  public List<Message> findByReceiver(long id) {
    return repository.findAllByReceiverIdOrderByCreatedDesc(id);
  }

  public List<Message> findBySender(long id) {
    return repository.findAllBySenderIdOrderByCreatedDesc(id);
  }

  public long save(Message message) {
    return repository.saveAndFlush(message).getId();
  }
}
