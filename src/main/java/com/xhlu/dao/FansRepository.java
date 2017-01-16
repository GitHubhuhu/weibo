package com.xhlu.dao;

import com.xhlu.model.Fans;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 *   数据库操作
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/16 15:04
 */
public interface FansRepository extends JpaRepository<Fans,Long>{
}
