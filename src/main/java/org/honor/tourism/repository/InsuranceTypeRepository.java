package org.honor.tourism.repository;

import org.honor.tourism.entity.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 保险种类Repository
 * @author 刘海
 *
 */
public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, String> {

}
