package dao;

import entity.Calculation;
import entity.Expression;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ExpressionDao {
    @PersistenceContext
    EntityManager em;

    public void addExpression (Expression expression) {
        em.persist(expression);
    }

}
