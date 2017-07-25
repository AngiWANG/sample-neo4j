package orders.db;

import java.util.List;
import java.util.Map;

import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.support.Neo4jTemplate;

import orders.Order;

//混合自定义
public class OrderRepositoryImpl implements OrderRepositoryCustom {
	@Autowired
	private Neo4jTemplate neo4jTemplate;

	@Override
	public List<Order> findSiAOrders() {
		Result<Map<String, Object>> result = neo4jTemplate
				.query("match (o:Order)-[:HAS_ITEMS]->(i:Item) " + "where i.product='Spring in Action' return o", null);
		Result<Order> endResult = result.to(Order.class);
		return IteratorUtil.asList(endResult);
	}

}
