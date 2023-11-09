package ma.zs.stocky.service.impl.admin.paiement;


import ma.zs.stocky.bean.core.paiement.PaiementAvoirAchat;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementAvoirAchatCriteria;
import ma.zs.stocky.dao.facade.core.paiement.PaiementAvoirAchatDao;
import ma.zs.stocky.dao.specification.core.paiement.PaiementAvoirAchatSpecification;
import ma.zs.stocky.service.facade.admin.paiement.PaiementAvoirAchatAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.service.Attribute;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.stocky.zynerator.util.VelocityPdf;
import ma.zs.stocky.ws.dto.paiement.PaiementAvoirAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commun.ModePaiementAdminService ;
import ma.zs.stocky.bean.core.commun.ModePaiement ;
import ma.zs.stocky.service.facade.admin.stock.AchatAdminService ;
import ma.zs.stocky.bean.core.stock.Achat ;
import ma.zs.stocky.service.facade.admin.stock.AvoirAchatAdminService ;
import ma.zs.stocky.bean.core.stock.AvoirAchat ;

import java.util.List;
@Service
public class PaiementAvoirAchatAdminServiceImpl extends AbstractServiceImpl<PaiementAvoirAchat, PaiementAvoirAchatCriteria, PaiementAvoirAchatDao> implements PaiementAvoirAchatAdminService {
    public static final String TEMPLATE = "template/paiementAvoirAchat.vm";
    public static final String FILE_NAME = "paiementAvoirAchat.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));


    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));



    ATTRIBUTES.add(new Attribute("description"));

    }

    @Override
    public HttpEntity<byte[]> createPdf(PaiementAvoirAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public PaiementAvoirAchat findByReferenceEntity(PaiementAvoirAchat t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementAvoirAchat> findByAchatId(Long id){
        return dao.findByAchatId(id);
    }
    public int deleteByAchatId(Long id){
        return dao.deleteByAchatId(id);
    }
    public long countByAchatId(Long id){
        return dao.countByAchatId(id);
    }
    public List<PaiementAvoirAchat> findByModePaiementId(Long id){
        return dao.findByModePaiementId(id);
    }
    public int deleteByModePaiementId(Long id){
        return dao.deleteByModePaiementId(id);
    }
    public long countByModePaiementCode(String code){
        return dao.countByModePaiementCode(code);
    }
    public List<PaiementAvoirAchat> findByAvoirAchatId(Long id){
        return dao.findByAvoirAchatId(id);
    }
    public int deleteByAvoirAchatId(Long id){
        return dao.deleteByAvoirAchatId(id);
    }
    public long countByAvoirAchatId(Long id){
        return dao.countByAvoirAchatId(id);
    }

    public List<PaiementAvoirAchat> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(PaiementAvoirAchat.class, PaiementAvoirAchatSpecification.class);
    }


    @Autowired
    private ModePaiementAdminService modePaiementService ;
    @Autowired
    private AchatAdminService achatService ;
    @Autowired
    private AvoirAchatAdminService avoirAchatService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaiementAvoirAchatAdminServiceImpl(PaiementAvoirAchatDao dao) {
        super(dao);
    }

}
