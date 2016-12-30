package org.honor.tourism.repository;

import org.honor.tourism.entity.InventoryDate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 作者:修罗大人
 * 日期:Dec 29, 2016
 * 时间:3:09:34 PM
 * 库存价格中的日期Repository
 */

public interface InventoryDateRepository extends JpaRepository<InventoryDate, String> {

}
