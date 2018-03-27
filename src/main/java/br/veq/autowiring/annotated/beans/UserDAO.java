package br.veq.autowiring.annotated.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class UserDAO extends DAO {

}
