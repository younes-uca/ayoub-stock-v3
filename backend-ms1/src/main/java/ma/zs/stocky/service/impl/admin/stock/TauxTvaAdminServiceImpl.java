package ma.zs.stocky.service.impl.admin.stock;


import ma.zs.stocky.bean.core.stock.TauxTva;
import ma.zs.stocky.dao.criteria.core.stock.TauxTvaCriteria;
import ma.zs.stocky.dao.facade.core.stock.TauxTvaDao;
import ma.zs.stocky.dao.specification.core.stock.TauxTvaSpecification;
import ma.zs.stocky.service.facade.admin.stock.TauxTvaAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.service.Attribute;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.stocky.zynerator.util.VelocityPdf;
import ma.zs.stocky.ws.dto.stock.TauxTvaDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class TauxTvaAdminServiceImpl extends AbstractServiceImpl<TauxTva, TauxTvaCriteria, TauxTvaDao> implements TauxTvaAdminService {
    public static final String TEMPLATE = "template/tauxTva.vm";
    public static final String FILE_NAME = "tauxTva.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));

    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));

    ATTRIBUTES.add(new Attribute("code"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(TauxTvaDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public TauxTva findByReferenceEntity(TauxTva t){
        return  dao.findByCode(t.getCode());
    }


    public List<TauxTva> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(TauxTva.class, TauxTvaSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public TauxTvaAdminServiceImpl(TauxTvaDao dao) {
        super(dao);
    }

}
