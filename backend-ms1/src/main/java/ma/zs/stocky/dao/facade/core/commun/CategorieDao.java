package ma.zs.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.commun.Categorie;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.commun.Categorie;
import java.util.List;


@Repository
public interface CategorieDao extends AbstractRepository<Categorie,Long>  {
    Categorie findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Categorie(item.id,item.libelle) FROM Categorie item")
    List<Categorie> findAllOptimized();

}
