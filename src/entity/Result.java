package entity;

import javax.persistence.*;

@Entity
public class Result {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    private double result;

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @OneToOne(mappedBy = "result", optional = false)
    private Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
