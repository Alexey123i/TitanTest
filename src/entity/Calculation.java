package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Calculation.FindAll",
                query = "SELECT c FROM Calculation c"),
        @NamedQuery(name = "Calculation.deleteCalculation",
                query = "DELETE FROM Calculation c WHERE c = :calculation")
})
public class Calculation {
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
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToMany(cascade= CascadeType.ALL, mappedBy = "calculation")
    private Collection<Expression> expressions;

    public Collection<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(Collection<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
