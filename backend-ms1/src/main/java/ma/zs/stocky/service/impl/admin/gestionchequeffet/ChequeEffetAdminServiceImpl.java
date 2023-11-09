package ma.zs.stocky.service.impl.admin.gestionchequeffet;


import ma.zs.stocky.bean.core.gestionchequeffet.ChequeEffet;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.ChequeEffetCriteria;
import ma.zs.stocky.dao.facade.core.gestionchequeffet.ChequeEffetDao;
import ma.zs.stocky.dao.specification.core.gestionchequeffet.ChequeEffetSpecification;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.ChequeEffetAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commun.FournisseurAdminService ;
import ma.zs.stocky.bean.core.commun.Fournisseur ;

import java.util.List;
@Service
public class ChequeEffetAdminServiceImpl extends AbstractServiceImpl<ChequeEffet, ChequeEffetCriteria, ChequeEffetDao> implements ChequeEffetAdminService {






    public List<ChequeEffet> findByBeneficiaireId(Long id){
        return dao.findByBeneficiaireId(id);
    }
    public int deleteByBeneficiaireId(Long id){
        return dao.deleteByBeneficiaireId(id);
    }
    public long countByBeneficiaireId(Long id){
        return dao.countByBeneficiaireId(id);
    }






    public void configure() {
        super.configure(ChequeEffet.class, ChequeEffetSpecification.class);
    }


    @Autowired
    private FournisseurAdminService fournisseurService ;

    public ChequeEffetAdminServiceImpl(ChequeEffetDao dao) {
        super(dao);
    }

}
