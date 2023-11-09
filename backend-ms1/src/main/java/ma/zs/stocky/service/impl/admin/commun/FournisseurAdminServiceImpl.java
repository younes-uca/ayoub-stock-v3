package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.Fournisseur;
import ma.zs.stocky.dao.criteria.core.commun.FournisseurCriteria;
import ma.zs.stocky.dao.facade.core.commun.FournisseurDao;
import ma.zs.stocky.dao.specification.core.commun.FournisseurSpecification;
import ma.zs.stocky.service.facade.admin.commun.FournisseurAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.service.Attribute;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.stocky.zynerator.util.VelocityPdf;
import ma.zs.stocky.ws.dto.commun.FournisseurDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commun.VilleAdminService ;
import ma.zs.stocky.bean.core.commun.Ville ;

import java.util.List;
@Service
public class FournisseurAdminServiceImpl extends AbstractServiceImpl<Fournisseur, FournisseurCriteria, FournisseurDao> implements FournisseurAdminService {
    public static final String TEMPLATE = "template/fournisseur.vm";
    public static final String FILE_NAME = "fournisseur.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("nom"));

    ATTRIBUTES.add(new Attribute("ice"));

    ATTRIBUTES.add(new Attribute("telephone"));

    ATTRIBUTES.add(new Attribute("infoBancaire"));


    ATTRIBUTES.add(new Attribute("adresse"));

    ATTRIBUTES.add(new Attribute("creance","BigDecimal"));

    ATTRIBUTES.add(new Attribute("description"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(FournisseurDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }





    public List<Fournisseur> findByVilleId(Long id){
        return dao.findByVilleId(id);
    }
    public int deleteByVilleId(Long id){
        return dao.deleteByVilleId(id);
    }
    public long countByVilleId(Long id){
        return dao.countByVilleId(id);
    }

    public List<Fournisseur> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Fournisseur.class, FournisseurSpecification.class);
    }


    @Autowired
    private VilleAdminService villeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public FournisseurAdminServiceImpl(FournisseurDao dao) {
        super(dao);
    }

}
