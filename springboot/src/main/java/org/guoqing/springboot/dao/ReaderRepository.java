package org.guoqing.springboot.dao;

import org.guoqing.springboot.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018-10-21
 */
public interface ReaderRepository extends JpaRepository<Reader,String> {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return Reader
     */
    Reader findByUsername(String username);
}
