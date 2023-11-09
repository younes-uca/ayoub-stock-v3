package ma.zs.stocky.dao.facade.core.stock;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stock.TauxTva;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.stock.TauxTva;
import java.util.List;


@Repository
public interface TauxTvaDao extends AbstractRepository<TauxTva,Long>  {
    TauxTva findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TauxTva(item.id,item.libelle) FROM TauxTva item")
    List<TauxTva> findAllOptimized();

}
