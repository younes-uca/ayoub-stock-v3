package ma.zs.stocky.dao.facade.core.depense;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.depense.Depense;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DepenseDao extends AbstractRepository<Depense,Long>  {



}
