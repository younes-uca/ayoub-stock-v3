package ma.zs.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.commun.UniteMesure;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.commun.UniteMesure;
import java.util.List;


@Repository
public interface UniteMesureDao extends AbstractRepository<UniteMesure,Long>  {
    UniteMesure findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW UniteMesure(item.id,item.libelle) FROM UniteMesure item")
    List<UniteMesure> findAllOptimized();

}
