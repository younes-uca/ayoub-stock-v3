package ma.zs.stocky.service.impl.admin.gestionchequeffet;


import ma.zs.stocky.bean.core.gestionchequeffet.Compte;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.CompteCriteria;
import ma.zs.stocky.dao.facade.core.gestionchequeffet.CompteDao;
import ma.zs.stocky.dao.specification.core.gestionchequeffet.CompteSpecification;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.CompteAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.gestionchequeffet.BanqueAdminService ;
import ma.zs.stocky.bean.core.gestionchequeffet.Banque ;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.ProprietaireAdminService ;
import ma.zs.stocky.bean.core.gestionchequeffet.Proprietaire ;

import java.util.List;
@Service
public class CompteAdminServiceImpl extends AbstractServiceImpl<Compte, CompteCriteria, CompteDao> implements CompteAdminService {






    public List<Compte> findByBanqueId(Long id){
        return dao.findByBanqueId(id);
    }
    public int deleteByBanqueId(Long id){
        return dao.deleteByBanqueId(id);
    }
    public long countByBanqueCode(String code){
        return dao.countByBanqueCode(code);
    }
    public List<Compte> findByProprietaireId(Long id){
        return dao.findByProprietaireId(id);
    }
    public int deleteByProprietaireId(Long id){
        return dao.deleteByProprietaireId(id);
    }
    public long countByProprietaireCode(String code){
        return dao.countByProprietaireCode(code);
    }

    public List<Compte> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Compte.class, CompteSpecification.class);
    }


    @Autowired
    private BanqueAdminService banqueService ;
    @Autowired
    private ProprietaireAdminService proprietaireService ;

    public CompteAdminServiceImpl(CompteDao dao) {
        super(dao);
    }

}
