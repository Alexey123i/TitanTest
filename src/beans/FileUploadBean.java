package beans;

import dao.CalculationDao;
import entity.Calculation;
import entity.Expression;
import entity.Result;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class FileUploadBean implements Serializable {

    @EJB
    CalculationDao calculationDao;

    private UploadedFile uploadedFile;

    private List<Expression> tmpExpressions = new ArrayList<>();

    public void saveCalculation() throws IOException {

        Calculation calculation = new Calculation();
        calculation.setDate(new Date());

        for (int j = 0; j < tmpExpressions.size(); j++) {
            tmpExpressions.get(j).setCalculation(calculation);
        }

        calculation.setExpressions(tmpExpressions);
        calculationDao.addCalculation(calculation);

        tmpExpressions.clear();
    }

    public void calculate() throws IOException {
        String str = IOUtils.toString(this.uploadedFile.getInputstream());
        String[] s = str.split("\n");
        Expression expression;
        Result result;
        for (int i = 0; i < s.length; i++) {
            expression = new Expression();
            expression.setExpression(s[i]);
            result = new Result();
            result.setResult(PPN.eval(s[i]));
            expression.setResult(result);
            tmpExpressions.add(expression);
        }
    }

    public List<Expression> getTmpExpressions() {
        return tmpExpressions;
    }

    public void setTmpExpressions(List<Expression> tmpExpressions) {
        this.tmpExpressions = tmpExpressions;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

}