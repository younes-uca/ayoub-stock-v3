package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.Vente;
import ma.zs.stocky.dao.criteria.core.stock.VenteCriteria;
import ma.zs.stocky.dao.facade.core.stock.VenteDao;
import ma.zs.stocky.dao.specification.core.stock.VenteSpecification;
import ma.zs.stocky.service.facade.admin.stock.VenteAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.stock.VenteItemAdminService ;
import ma.zs.stocky.bean.core.stock.VenteItem ;
import ma.zs.stocky.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.stocky.bean.core.commun.EntrepriseSociete ;
import ma.zs.stocky.service.facade.admin.commun.EtatVenteAdminService ;
import ma.zs.stocky.bean.core.commun.EtatVente ;
import ma.zs.stocky.service.facade.admin.commun.ClientAdminService ;
import ma.zs.stocky.bean.core.commun.Client ;
import ma.zs.stocky.service.facade.admin.stock.AvoirVenteAdminService ;
import ma.zs.stocky.bean.core.stock.AvoirVente ;

import java.util.List;
@Service
public class VenteAdminServiceImpl extends AbstractServiceImpl<Vente, VenteCriteria, VenteDao> implements VenteAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Vente create(Vente t) {
        super.create(t);
        if (t.getVenteItems() != null) {
                t.getVenteItems().forEach(element-> {
                    element.setVente(t);
                    venteItemService.create(element);
            });
        }
        if (t.getAvoirs() != null) {
                t.getAvoirs().forEach(element-> {
                    element.setVente(t);
                    avoirVenteService.create(element);
            });
        }
        return t;
    }

    public Vente findWithAssociatedLists(Long id){
        Vente result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setVenteItems(venteItemService.findByVenteId(id));
            result.setAvoirs(avoirVenteService.findByVenteId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        venteItemService.deleteByVenteId(id);
        avoirVenteService.deleteByVenteId(id);
    }


    public void updateWithAssociatedLists(Vente vente){
    if(vente !=null && vente.getId() != null){
            List<List<VenteItem>> resultVenteItems= venteItemService.getToBeSavedAndToBeDeleted(venteItemService.findByVenteId(vente.getId()),vente.getVenteItems());
            venteItemService.delete(resultVenteItems.get(1));
            ListUtil.emptyIfNull(resultVenteItems.get(0)).forEach(e -> e.setVente(vente));
            venteItemService.update(resultVenteItems.get(0),true);
            List<List<AvoirVente>> resultAvoirs= avoirVenteService.getToBeSavedAndToBeDeleted(avoirVenteService.findByVenteId(vente.getId()),vente.getAvoirs());
            avoirVenteService.delete(resultAvoirs.get(1));
            ListUtil.emptyIfNull(resultAvoirs.get(0)).forEach(e -> e.setVente(vente));
            avoirVenteService.update(resultAvoirs.get(0),true);
    }
    }




    public List<Vente> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Vente> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public long countByClientId(Long id){
        return dao.countByClientId(id);
    }
    public List<Vente> findByEtatVenteId(Long id){
        return dao.findByEtatVenteId(id);
    }
    public int deleteByEtatVenteId(Long id){
        return dao.deleteByEtatVenteId(id);
    }
    public long countByEtatVenteCode(String code){
        return dao.countByEtatVenteCode(code);
    }






    public void configure() {
        super.configure(Vente.class, VenteSpecification.class);
    }


    @Autowired
    private VenteItemAdminService venteItemService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;
    @Autowired
    private EtatVenteAdminService etatVenteService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private AvoirVenteAdminService avoirVenteService ;

    public VenteAdminServiceImpl(VenteDao dao) {
        super(dao);
    }

}
