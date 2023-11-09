package ma.zs.stocky.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.gestionchequeffet.Proprietaire;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.gestionchequeffet.Proprietaire;
import java.util.List;


@Repository
public interface ProprietaireDao extends AbstractRepository<Proprietaire,Long>  {
    Proprietaire findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Proprietaire(item.id,item.nom) FROM Proprietaire item")
    List<Proprietaire> findAllOptimized();

}
