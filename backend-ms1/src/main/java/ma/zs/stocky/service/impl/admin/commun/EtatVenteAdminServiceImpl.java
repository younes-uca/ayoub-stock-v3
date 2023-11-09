package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.EtatVente;
import ma.zs.stocky.dao.criteria.core.commun.EtatVenteCriteria;
import ma.zs.stocky.dao.facade.core.commun.EtatVenteDao;
import ma.zs.stocky.dao.specification.core.commun.EtatVenteSpecification;
import ma.zs.stocky.service.facade.admin.commun.EtatVenteAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.service.Attribute;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.stocky.zynerator.util.VelocityPdf;
import ma.zs.stocky.ws.dto.commun.EtatVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class EtatVenteAdminServiceImpl extends AbstractServiceImpl<EtatVente, EtatVenteCriteria, EtatVenteDao> implements EtatVenteAdminService {
    public static final String TEMPLATE = "template/etatVente.vm";
    public static final String FILE_NAME = "etatVente.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));

    ATTRIBUTES.add(new Attribute("code"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(EtatVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public EtatVente findByReferenceEntity(EtatVente t){
        return  dao.findByCode(t.getCode());
    }


    public List<EtatVente> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(EtatVente.class, EtatVenteSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public EtatVenteAdminServiceImpl(EtatVenteDao dao) {
        super(dao);
    }

}
