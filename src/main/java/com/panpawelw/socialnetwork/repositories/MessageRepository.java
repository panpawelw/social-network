package com.panpawelw.socialnetwork.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.panpawelw.socialnetwork.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface MessageRepository extends JpaRepository<Message, Long>{

    List<Message> findAllByReceiverIdOrderByCreatedDesc(long id);

    List<Message> findAllBySenderIdOrderByCreatedDesc(long id);

    Message findById(long id);
}