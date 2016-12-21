package org.honor.tourism.repository;

import org.honor.tourism.entity.DiningType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用餐类型Repository
 * @author 刘海
 *
 */
public interface DiningTypeRepository extends JpaRepository< DiningType, String> {

}
