package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.Depot;
import ma.zs.stocky.dao.criteria.core.commun.DepotCriteria;
import ma.zs.stocky.dao.facade.core.commun.DepotDao;
import ma.zs.stocky.dao.specification.core.commun.DepotSpecification;
import ma.zs.stocky.service.facade.admin.commun.DepotAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.service.Attribute;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.stocky.zynerator.util.VelocityPdf;
import ma.zs.stocky.ws.dto.commun.DepotDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class DepotAdminServiceImpl extends AbstractServiceImpl<Depot, DepotCriteria, DepotDao> implements DepotAdminService {
    public static final String TEMPLATE = "template/depot.vm";
    public static final String FILE_NAME = "depot.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));

    ATTRIBUTES.add(new Attribute("code"));

    ATTRIBUTES.add(new Attribute("adresse"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(DepotDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public Depot findByReferenceEntity(Depot t){
        return  dao.findByCode(t.getCode());
    }


    public List<Depot> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Depot.class, DepotSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public DepotAdminServiceImpl(DepotDao dao) {
        super(dao);
    }

}
