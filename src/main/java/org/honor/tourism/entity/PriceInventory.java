package org.honor.tourism.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 价格/库存
 * @author keiwu
 *
 */
@Entity
@Table(name = "t_price_inventory")
public class PriceInventory {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Length(min = 32, max = 32, message = "id需要32位字符")
	private String id;
	/**库存日期*/
	@OneToMany
	private List<InventoryDate> inventoryDateList;

}
