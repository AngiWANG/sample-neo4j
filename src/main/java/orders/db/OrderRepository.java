package orders.db;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import orders.Order;

/**
 * 订单Repository
 * 
 * @author angi
 *
 */
public interface OrderRepository extends GraphRepository<Order>, OrderRepositoryCustom {

	// begin 自定义查询方法
	List<Order> findByCustomer(String customer);

	List<Order> findByCustomerLike(String customer);

	List<Order> findByCustomerAndType(String customer, String type);

	List<Order> getByType(String type);
	// end 自定义查询方法

	// begin 声明自定义查询
	@Query("match (a:Order {customer:{0}}) return a")
	List<Order> findChucksOrders(String customer);
	// end 声明自定义查询
}
