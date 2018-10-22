package org.guoqing.springboot.dao;

import org.guoqing.springboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 书籍查询
 *
 * @author dengguoqing
 * @date 2018-10-21
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    /**
     * 根据读者查询书籍列表
     * @param reader
     * @return
     */
    List<Book> findByReader(String reader);
}
