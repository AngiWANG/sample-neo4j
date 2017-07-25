package orders.db;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import orders.Order;

//混合自定义
public interface OrderRepositoryCustom {

	@Transactional
	List<Order> findSiAOrders();

}