package ma.zs.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.commun.Collaborateur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CollaborateurDao extends AbstractRepository<Collaborateur,Long>  {


    @Query("SELECT NEW Collaborateur(item.id,item.nom) FROM Collaborateur item")
    List<Collaborateur> findAllOptimized();

}
