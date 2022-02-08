package h5EDULive.dao;

import h5EDULive.dao.domain.Course;
import h5EDULive.dao.domain.Message;
import h5EDULive.dao.domain.Post;
import h5EDULive.dao.domain.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created on 2019-7-4.
 */
public interface MessageRepository extends JpaRepository<Message, Integer>, JpaSpecificationExecutor<Message> {

    Page<Message> findAllByReceiverId(int receiverId, Pageable pageable);

    Page<Message> findAllBySenderId(int senderId, Pageable pageable);

    Post findBySenderId(int senderId);

    void deleteByReceiverId(int receiverId);

}
