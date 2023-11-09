package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.AvoirVente;
import ma.zs.stocky.dao.criteria.core.stock.AvoirVenteCriteria;
import ma.zs.stocky.dao.facade.core.stock.AvoirVenteDao;
import ma.zs.stocky.dao.specification.core.stock.AvoirVenteSpecification;
import ma.zs.stocky.service.facade.admin.stock.AvoirVenteAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.stocky.bean.core.commun.EntrepriseSociete ;
import ma.zs.stocky.service.facade.admin.stock.AvoirVenteItemAdminService ;
import ma.zs.stocky.bean.core.stock.AvoirVenteItem ;
import ma.zs.stocky.service.facade.admin.stock.VenteAdminService ;
import ma.zs.stocky.bean.core.stock.Vente ;

import java.util.List;
@Service
public class AvoirVenteAdminServiceImpl extends AbstractServiceImpl<AvoirVente, AvoirVenteCriteria, AvoirVenteDao> implements AvoirVenteAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public AvoirVente create(AvoirVente t) {
        super.create(t);
        if (t.getAvoirVenteItems() != null) {
                t.getAvoirVenteItems().forEach(element-> {
                    element.setAvoirVente(t);
                    avoirVenteItemService.create(element);
            });
        }
        return t;
    }

    public AvoirVente findWithAssociatedLists(Long id){
        AvoirVente result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setAvoirVenteItems(avoirVenteItemService.findByAvoirVenteId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        avoirVenteItemService.deleteByAvoirVenteId(id);
    }


    public void updateWithAssociatedLists(AvoirVente avoirVente){
    if(avoirVente !=null && avoirVente.getId() != null){
            List<List<AvoirVenteItem>> resultAvoirVenteItems= avoirVenteItemService.getToBeSavedAndToBeDeleted(avoirVenteItemService.findByAvoirVenteId(avoirVente.getId()),avoirVente.getAvoirVenteItems());
            avoirVenteItemService.delete(resultAvoirVenteItems.get(1));
            ListUtil.emptyIfNull(resultAvoirVenteItems.get(0)).forEach(e -> e.setAvoirVente(avoirVente));
            avoirVenteItemService.update(resultAvoirVenteItems.get(0),true);
    }
    }




    public List<AvoirVente> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<AvoirVente> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteId(Long id){
        return dao.countByVenteId(id);
    }






    public void configure() {
        super.configure(AvoirVente.class, AvoirVenteSpecification.class);
    }


    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private AvoirVenteItemAdminService avoirVenteItemService ;
    @Autowired
    private VenteAdminService venteService ;

    public AvoirVenteAdminServiceImpl(AvoirVenteDao dao) {
        super(dao);
    }

}
