package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.Inventaire;
import ma.zs.stocky.dao.criteria.core.stock.InventaireCriteria;
import ma.zs.stocky.dao.facade.core.stock.InventaireDao;
import ma.zs.stocky.dao.specification.core.stock.InventaireSpecification;
import ma.zs.stocky.service.facade.admin.stock.InventaireAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.stock.InventaireItemAdminService ;
import ma.zs.stocky.bean.core.stock.InventaireItem ;
import ma.zs.stocky.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.stocky.bean.core.commun.EntrepriseSociete ;

import java.util.List;
@Service
public class InventaireAdminServiceImpl extends AbstractServiceImpl<Inventaire, InventaireCriteria, InventaireDao> implements InventaireAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Inventaire create(Inventaire t) {
        super.create(t);
        if (t.getInventaireItems() != null) {
                t.getInventaireItems().forEach(element-> {
                    element.setInventaire(t);
                    inventaireItemService.create(element);
            });
        }
        return t;
    }

    public Inventaire findWithAssociatedLists(Long id){
        Inventaire result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setInventaireItems(inventaireItemService.findByInventaireId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        inventaireItemService.deleteByInventaireId(id);
    }


    public void updateWithAssociatedLists(Inventaire inventaire){
    if(inventaire !=null && inventaire.getId() != null){
            List<List<InventaireItem>> resultInventaireItems= inventaireItemService.getToBeSavedAndToBeDeleted(inventaireItemService.findByInventaireId(inventaire.getId()),inventaire.getInventaireItems());
            inventaireItemService.delete(resultInventaireItems.get(1));
            ListUtil.emptyIfNull(resultInventaireItems.get(0)).forEach(e -> e.setInventaire(inventaire));
            inventaireItemService.update(resultInventaireItems.get(0),true);
    }
    }



    public Inventaire findByReferenceEntity(Inventaire t){
        return  dao.findByReference(t.getReference());
    }

    public List<Inventaire> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }

    public List<Inventaire> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Inventaire.class, InventaireSpecification.class);
    }


    @Autowired
    private InventaireItemAdminService inventaireItemService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;

    public InventaireAdminServiceImpl(InventaireDao dao) {
        super(dao);
    }

}
