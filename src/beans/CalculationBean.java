package beans;

import dao.CalculationDao;
import entity.Calculation;
import entity.Expression;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class CalculationBean {
    @EJB
    private
    CalculationDao calculationDao;

    private Calculation tmpCalculetion;

    private List<Calculation> calculations;

    public List<Calculation> getCalculations() {
        return calculationDao.findAll();
    }

    public void setCalculations(List<Calculation> calculations) {
        this.calculations = calculations;
    }

    public void showExpressions (Calculation calculation) {
        this.tmpCalculetion = calculation;
    }

    public void deleteCalculation () {
        calculationDao.deleteCalculation(tmpCalculetion);
        tmpCalculetion = null;
    }

    public Calculation getTmpCalculetion() {
        return tmpCalculetion;
    }

    public void setTmpCalculetion(Calculation tmpCalculetion) {
        this.tmpCalculetion = tmpCalculetion;
    }

    public void cancel () {
        tmpCalculetion=null;
    }
}
