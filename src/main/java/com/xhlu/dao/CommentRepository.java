package com.xhlu.dao;

import com.xhlu.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 *   数据库操作
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/16 15:04
 */
public interface CommentRepository extends JpaRepository<Comment,Long>{
}
