package orders.db;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import orders.Order;

//混合自定义
public interface OrderRepository extends GraphRepository<Order>, OrderRepositoryCustom {

	// begin 自定义查询方法
	List<Order> findByCustomer(String customer);

	List<Order> findByCustomerLike(String customer);

	List<Order> findByCustomerAndType(String customer, String type);

	List<Order> getByType(String type);
	// end 自定义查询方法

	// begin 声明自定义查询
	// @Query("{customer:'Chuck Wagon'}")
	// List<Order> findChucksOrders();
	// end 声明自定义查询
}
