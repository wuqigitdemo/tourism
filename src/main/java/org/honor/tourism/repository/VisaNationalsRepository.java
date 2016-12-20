package org.honor.tourism.repository;

import org.honor.tourism.entity.VisaNationals;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 签证国家Repository
 * @author 刘海
 *
 */
public interface VisaNationalsRepository  extends JpaRepository<VisaNationals, String>{

}
