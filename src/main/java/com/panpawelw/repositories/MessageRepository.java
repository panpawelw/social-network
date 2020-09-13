package com.panpawelw.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panpawelw.entities.Message;

@Transactional
public interface MessageRepository extends JpaRepository<Message, Long>{

    List<Message> findAllByReceiverIdOrderByCreatedDesc(long id);

    List<Message> findAllBySenderIdOrderByCreatedDesc(long id);

    Message findById(long id);
}