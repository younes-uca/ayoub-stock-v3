package ma.zs.stocky.service.impl.admin.gestionchequeffet;


import ma.zs.stocky.bean.core.gestionchequeffet.Permutation;
import ma.zs.stocky.dao.criteria.core.gestionchequeffet.PermutationCriteria;
import ma.zs.stocky.dao.facade.core.gestionchequeffet.PermutationDao;
import ma.zs.stocky.dao.specification.core.gestionchequeffet.PermutationSpecification;
import ma.zs.stocky.service.facade.admin.gestionchequeffet.PermutationAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.admin.gestionchequeffet.PermutationItemAdminService ;
import ma.zs.stocky.bean.core.gestionchequeffet.PermutationItem ;

import java.util.List;
@Service
public class PermutationAdminServiceImpl extends AbstractServiceImpl<Permutation, PermutationCriteria, PermutationDao> implements PermutationAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Permutation create(Permutation t) {
        super.create(t);
        if (t.getPermutationItems() != null) {
                t.getPermutationItems().forEach(element-> {
                    element.setPermutation(t);
                    permutationItemService.create(element);
            });
        }
        return t;
    }

    public Permutation findWithAssociatedLists(Long id){
        Permutation result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPermutationItems(permutationItemService.findByPermutationId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        permutationItemService.deleteByPermutationId(id);
    }


    public void updateWithAssociatedLists(Permutation permutation){
    if(permutation !=null && permutation.getId() != null){
            List<List<PermutationItem>> resultPermutationItems= permutationItemService.getToBeSavedAndToBeDeleted(permutationItemService.findByPermutationId(permutation.getId()),permutation.getPermutationItems());
            permutationItemService.delete(resultPermutationItems.get(1));
            ListUtil.emptyIfNull(resultPermutationItems.get(0)).forEach(e -> e.setPermutation(permutation));
            permutationItemService.update(resultPermutationItems.get(0),true);
    }
    }










    public void configure() {
        super.configure(Permutation.class, PermutationSpecification.class);
    }


    @Autowired
    private PermutationItemAdminService permutationItemService ;

    public PermutationAdminServiceImpl(PermutationDao dao) {
        super(dao);
    }

}
