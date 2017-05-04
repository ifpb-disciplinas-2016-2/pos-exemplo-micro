package ifpb.ads.exemplo.micro;

import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 03/05/2017, 14:24:19
 */
@DataSourceDefinition(
        name = "java:app/jdbc/banco",
        className="org.postgresql.xa.PGXADataSource",
        url = "jdbc:postgresql://host-banco:5432/banco",
        user = "postgres",
        password = "12345")
@Stateless
public class CadastroPessoa {

    @PersistenceContext
    private EntityManager em;

    public String salvar(Pessoa pessoa) {
        em.persist(pessoa);
        return "salvando";
    }
    public List<Pessoa> pessoas(){
        return em.createQuery("FROM Pessoa p", Pessoa.class).getResultList();
    }

}
