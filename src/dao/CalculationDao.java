package dao;

import entity.Calculation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CalculationDao {
    @PersistenceContext
    EntityManager em;

    public List<Calculation> findAll() {
        return em.createNamedQuery("Calculation.FindAll").getResultList();
    }

    public void addCalculation (Calculation calculation) {
        em.persist(calculation);
    }

    public void deleteCalculation(Calculation calculation) {
        if (!em.contains(calculation)) {
            calculation = em.merge(calculation);
        }
        em.remove(calculation);

//        System.out.println(calculation.getId());
//        em.createNamedQuery("Calculation.deleteCalculation")
//                .setParameter("calculation",calculation).getResultList();
    }
}
