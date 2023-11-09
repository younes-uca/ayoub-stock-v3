package ma.zs.stocky.dao.facade.core.chequeffet;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.chequeffet.Instrument;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface InstrumentDao extends AbstractRepository<Instrument,Long>  {

    List<Instrument> findByTypeInstrumentId(Long id);
    int deleteByTypeInstrumentId(Long id);
    long countByTypeInstrumentCode(String code);
    List<Instrument> findByChequeEffetId(Long id);
    int deleteByChequeEffetId(Long id);
    long countByChequeEffetId(Long id);


}
