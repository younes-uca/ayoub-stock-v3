package ma.zs.stocky.dao.facade.core.gestionchequeffet;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.gestionchequeffet.TypeInstrument;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.gestionchequeffet.TypeInstrument;
import java.util.List;


@Repository
public interface TypeInstrumentDao extends AbstractRepository<TypeInstrument,Long>  {
    TypeInstrument findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeInstrument(item.id,item.libelle) FROM TypeInstrument item")
    List<TypeInstrument> findAllOptimized();

}
