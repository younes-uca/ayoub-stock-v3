package ma.zs.stocky.service.impl.admin.paiement;


import ma.zs.stocky.bean.core.paiement.PaiementVente;
import ma.zs.stocky.dao.criteria.core.paiement.PaiementVenteCriteria;
import ma.zs.stocky.dao.facade.core.paiement.PaiementVenteDao;
import ma.zs.stocky.dao.specification.core.paiement.PaiementVenteSpecification;
import ma.zs.stocky.service.facade.admin.paiement.PaiementVenteAdminService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.service.Attribute;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;




import ma.zs.stocky.zynerator.util.VelocityPdf;
import ma.zs.stocky.ws.dto.paiement.PaiementVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.stocky.service.facade.admin.commun.ModePaiementAdminService ;
import ma.zs.stocky.bean.core.commun.ModePaiement ;
import ma.zs.stocky.service.facade.admin.stock.VenteAdminService ;
import ma.zs.stocky.bean.core.stock.Vente ;

import java.util.List;
@Service
public class PaiementVenteAdminServiceImpl extends AbstractServiceImpl<PaiementVente, PaiementVenteCriteria, PaiementVenteDao> implements PaiementVenteAdminService {
    public static final String TEMPLATE = "template/paiementVente.vm";
    public static final String FILE_NAME = "paiementVente.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList();
    static{


    ATTRIBUTES.add(new Attribute("reference"));


    ATTRIBUTES.add(new Attribute("montant","BigDecimal"));



    ATTRIBUTES.add(new Attribute("description"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(PaiementVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }




    public PaiementVente findByReferenceEntity(PaiementVente t){
        return  dao.findByReference(t.getReference());
    }

    public List<PaiementVente> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public long countByVenteId(Long id){
        return dao.countByVenteId(id);
    }
    public List<PaiementVente> findByModePaiementId(Long id){
        return dao.findByModePaiementId(id);
    }
    public int deleteByModePaiementId(Long id){
        return dao.deleteByModePaiementId(id);
    }
    public long countByModePaiementCode(String code){
        return dao.countByModePaiementCode(code);
    }

    public List<PaiementVente> findAllOptimized() {
        return dao.findAllOptimized();
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }



    public void configure() {
        super.configure(PaiementVente.class, PaiementVenteSpecification.class);
    }


    @Autowired
    private ModePaiementAdminService modePaiementService ;
    @Autowired
    private VenteAdminService venteService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PaiementVenteAdminServiceImpl(PaiementVenteDao dao) {
        super(dao);
    }

}
