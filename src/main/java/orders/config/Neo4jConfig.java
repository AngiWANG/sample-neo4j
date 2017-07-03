package orders.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
// 扫描Repository所在包
@EnableNeo4jRepositories(basePackages = "orders.db")
public class Neo4jConfig extends Neo4jConfiguration {

	public Neo4jConfig() {
		// 扫描模型所在包
		setBasePackage("orders");
	}

	@Bean(destroyMethod = "shutdown")
	public GraphDatabaseService graphDatabaseService() {
		// 内嵌式
		return new GraphDatabaseFactory().newEmbeddedDatabase("/tmp/graphdb");
	}
}