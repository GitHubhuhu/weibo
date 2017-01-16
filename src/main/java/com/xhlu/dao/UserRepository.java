package com.xhlu.dao;

import com.xhlu.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 *   数据库操作
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/16 15:04
 */
public interface UserRepository extends JpaRepository<User,Long>{
}
