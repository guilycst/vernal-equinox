package br.veq.autowiring.annotated.beans;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SaleDAO extends DAO {

	@Inject
	@Qualifier("saleDatasource")
	@Override
	public void setDatasource(Datasource datasource) {
		super.setDatasource(datasource);
	}

}
