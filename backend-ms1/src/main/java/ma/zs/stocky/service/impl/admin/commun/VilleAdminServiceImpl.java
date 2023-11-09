package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.Ville;
import ma.zs.stocky.dao.criteria.core.commun.VilleCriteria;
import ma.zs.stocky.dao.facade.core.commun.VilleDao;
import ma.zs.stocky.dao.specification.core.commun.VilleSpecification;
import ma.zs.stocky.service.facade.admin.commun.VilleAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.service.Attribute;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.stocky.zynerator.util.VelocityPdf;
import ma.zs.stocky.ws.dto.commun.VilleDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class VilleAdminServiceImpl extends AbstractServiceImpl<Ville, VilleCriteria, VilleDao> implements VilleAdminService {
    public static final String TEMPLATE = "template/ville.vm";
    public static final String FILE_NAME = "ville.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(VilleDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }








    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(Ville.class, VilleSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public VilleAdminServiceImpl(VilleDao dao) {
        super(dao);
    }

}
