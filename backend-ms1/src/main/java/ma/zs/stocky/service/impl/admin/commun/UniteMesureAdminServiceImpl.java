package ma.zs.stocky.service.impl.admin.commun;


import ma.zs.stocky.bean.core.commun.UniteMesure;
import ma.zs.stocky.dao.criteria.core.commun.UniteMesureCriteria;
import ma.zs.stocky.dao.facade.core.commun.UniteMesureDao;
import ma.zs.stocky.dao.specification.core.commun.UniteMesureSpecification;
import ma.zs.stocky.service.facade.admin.commun.UniteMesureAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.service.Attribute;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.stocky.zynerator.util.VelocityPdf;
import ma.zs.stocky.ws.dto.commun.UniteMesureDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class UniteMesureAdminServiceImpl extends AbstractServiceImpl<UniteMesure, UniteMesureCriteria, UniteMesureDao> implements UniteMesureAdminService {
    public static final String TEMPLATE = "template/uniteMesure.vm";
    public static final String FILE_NAME = "uniteMesure.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("libelle"));

    ATTRIBUTES.add(new Attribute("code"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(UniteMesureDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public UniteMesure findByReferenceEntity(UniteMesure t){
        return  dao.findByCode(t.getCode());
    }


    public List<UniteMesure> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(UniteMesure.class, UniteMesureSpecification.class);
    }


    @Autowired
    private VelocityPdf velocityPdf;

    public UniteMesureAdminServiceImpl(UniteMesureDao dao) {
        super(dao);
    }

}
