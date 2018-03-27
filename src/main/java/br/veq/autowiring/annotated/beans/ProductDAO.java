package br.veq.autowiring.annotated.beans;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.PostConstruct; // JSR-250
import javax.annotation.PreDestroy; // JSR-250
import javax.inject.Inject;
import javax.inject.Named; //JSR-330

//Use JSR stuff if you like a less intrusive approach
@Named
public class ProductDAO extends DAO {

	private final AtomicBoolean POST_CONSTRUCT = new AtomicBoolean();
	private static final AtomicBoolean PRE_DESTROY = new AtomicBoolean();

	// Use JSR stuff if you like a less intrusive approach
	@PostConstruct
	public void init() {
		POST_CONSTRUCT.set(true);
	}

	// Use JSR stuff if you like a less intrusive approach
	@PreDestroy
	public void destroy() {
		PRE_DESTROY.set(true);
	}

	public boolean hasBeenPostConstruct() {
		return POST_CONSTRUCT.get();
	}

	public static boolean hasBeenPreDestroy() {
		return PRE_DESTROY.get();
	}

	@Override
	@Inject
	public void setDatasource(@DatasourceType(value = "productDatasource") Datasource datasource) {
		// TODO Auto-generated method stub
		super.setDatasource(datasource);
	}

}
