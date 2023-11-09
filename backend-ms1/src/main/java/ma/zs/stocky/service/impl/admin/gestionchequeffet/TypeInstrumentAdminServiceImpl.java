package ma.zs.stocky.service.impl.admin.gestionchequeffet;


import ma.zs.stocky.bean.core.gestionchequeffet.TypeInstrument;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.TypeInstrumentCriteria;
import ma.zs.stocky.dao.facade.core.gestionchequeffet.TypeInstrumentDao;
import ma.zs.stocky.dao.specification.core.gestionchequeffet.TypeInstrumentSpecification;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.TypeInstrumentAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TypeInstrumentAdminServiceImpl extends AbstractServiceImpl<TypeInstrument, TypeInstrumentCriteria, TypeInstrumentDao> implements TypeInstrumentAdminService {





    public TypeInstrument findByReferenceEntity(TypeInstrument t){
        return  dao.findByCode(t.getCode());
    }


    public List<TypeInstrument> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(TypeInstrument.class, TypeInstrumentSpecification.class);
    }



    public TypeInstrumentAdminServiceImpl(TypeInstrumentDao dao) {
        super(dao);
    }

}
