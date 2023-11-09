package ma.zs.stocky.service.impl.admin.chequeffet;


import ma.zs.stocky.bean.core.chequeffet.Instrument;
import ma.zs.stocky.dao.criteria.core.chequeffet.InstrumentCriteria;
import ma.zs.stocky.dao.facade.core.chequeffet.InstrumentDao;
import ma.zs.stocky.dao.specification.core.chequeffet.InstrumentSpecification;
import ma.zs.stocky.service.facade.admin.chequeffet.InstrumentAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.gestionchequeffet.ChequeEffetAdminService ;
import ma.zs.stocky.bean.core.gestionchequeffet.ChequeEffet ;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.TypeInstrumentAdminService ;
import ma.zs.stocky.bean.core.gestionchequeffet.TypeInstrument ;

import java.util.List;
@Service
public class InstrumentAdminServiceImpl extends AbstractServiceImpl<Instrument, InstrumentCriteria, InstrumentDao> implements InstrumentAdminService {






    public List<Instrument> findByTypeInstrumentId(Long id){
        return dao.findByTypeInstrumentId(id);
    }
    public int deleteByTypeInstrumentId(Long id){
        return dao.deleteByTypeInstrumentId(id);
    }
    public long countByTypeInstrumentCode(String code){
        return dao.countByTypeInstrumentCode(code);
    }
    public List<Instrument> findByChequeEffetId(Long id){
        return dao.findByChequeEffetId(id);
    }
    public int deleteByChequeEffetId(Long id){
        return dao.deleteByChequeEffetId(id);
    }
    public long countByChequeEffetId(Long id){
        return dao.countByChequeEffetId(id);
    }






    public void configure() {
        super.configure(Instrument.class, InstrumentSpecification.class);
    }


    @Autowired
    private ChequeEffetAdminService chequeEffetService ;
    @Autowired
    private TypeInstrumentAdminService typeInstrumentService ;

    public InstrumentAdminServiceImpl(InstrumentDao dao) {
        super(dao);
    }

}
