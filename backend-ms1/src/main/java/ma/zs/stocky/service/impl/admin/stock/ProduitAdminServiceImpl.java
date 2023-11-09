package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.Produit;
import ma.zs.stocky.dao.criteria.core.stock.ProduitCriteria;
import ma.zs.stocky.dao.facade.core.stock.ProduitDao;
import ma.zs.stocky.dao.specification.core.stock.ProduitSpecification;
import ma.zs.stocky.service.facade.admin.stock.ProduitAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.commun.MarqueAdminService ;
import ma.zs.stocky.bean.core.commun.Marque ;
import ma.zs.stocky.service.facade.admin.commun.CategorieAdminService ;
import ma.zs.stocky.bean.core.commun.Categorie ;
import ma.zs.stocky.service.facade.admin.stock.StockAdminService ;
import ma.zs.stocky.bean.core.stock.Stock ;
import ma.zs.stocky.service.facade.admin.commun.UniteMesureAdminService ;
import ma.zs.stocky.bean.core.commun.UniteMesure ;
import ma.zs.stocky.service.facade.admin.commun.EntrepriseSocieteAdminService ;
import ma.zs.stocky.bean.core.commun.EntrepriseSociete ;

import java.util.List;
@Service
public class ProduitAdminServiceImpl extends AbstractServiceImpl<Produit, ProduitCriteria, ProduitDao> implements ProduitAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Produit create(Produit t) {
        super.create(t);
        if (t.getStocks() != null) {
                t.getStocks().forEach(element-> {
                    element.setProduit(t);
                    stockService.create(element);
            });
        }
        return t;
    }

    public Produit findWithAssociatedLists(Long id){
        Produit result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setStocks(stockService.findByProduitId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        stockService.deleteByProduitId(id);
    }


    public void updateWithAssociatedLists(Produit produit){
    if(produit !=null && produit.getId() != null){
            List<List<Stock>> resultStocks= stockService.getToBeSavedAndToBeDeleted(stockService.findByProduitId(produit.getId()),produit.getStocks());
            stockService.delete(resultStocks.get(1));
            ListUtil.emptyIfNull(resultStocks.get(0)).forEach(e -> e.setProduit(produit));
            stockService.update(resultStocks.get(0),true);
    }
    }




    public List<Produit> findByEntrepriseSocieteId(Long id){
        return dao.findByEntrepriseSocieteId(id);
    }
    public int deleteByEntrepriseSocieteId(Long id){
        return dao.deleteByEntrepriseSocieteId(id);
    }
    public long countByEntrepriseSocieteId(Long id){
        return dao.countByEntrepriseSocieteId(id);
    }
    public List<Produit> findByCategorieId(Long id){
        return dao.findByCategorieId(id);
    }
    public int deleteByCategorieId(Long id){
        return dao.deleteByCategorieId(id);
    }
    public long countByCategorieCode(String code){
        return dao.countByCategorieCode(code);
    }
    public List<Produit> findByMarqueId(Long id){
        return dao.findByMarqueId(id);
    }
    public int deleteByMarqueId(Long id){
        return dao.deleteByMarqueId(id);
    }
    public long countByMarqueCode(String code){
        return dao.countByMarqueCode(code);
    }
    public List<Produit> findByUniteMesureId(Long id){
        return dao.findByUniteMesureId(id);
    }
    public int deleteByUniteMesureId(Long id){
        return dao.deleteByUniteMesureId(id);
    }
    public long countByUniteMesureCode(String code){
        return dao.countByUniteMesureCode(code);
    }

    public List<Produit> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Produit.class, ProduitSpecification.class);
    }


    @Autowired
    private MarqueAdminService marqueService ;
    @Autowired
    private CategorieAdminService categorieService ;
    @Autowired
    private StockAdminService stockService ;
    @Autowired
    private UniteMesureAdminService uniteMesureService ;
    @Autowired
    private EntrepriseSocieteAdminService entrepriseSocieteService ;

    public ProduitAdminServiceImpl(ProduitDao dao) {
        super(dao);
    }

}
