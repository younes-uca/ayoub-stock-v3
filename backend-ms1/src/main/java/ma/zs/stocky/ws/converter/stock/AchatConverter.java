package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.commun.EtatAchatConverter;
import ma.zs.stocky.ws.converter.stock.AvoirAchatConverter;
import ma.zs.stocky.ws.converter.commun.FournisseurConverter;
import ma.zs.stocky.ws.converter.commun.DepotConverter;
import ma.zs.stocky.ws.converter.stock.AchatItemConverter;
import ma.zs.stocky.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.stocky.ws.converter.stock.ProduitConverter;
import ma.zs.stocky.ws.converter.stock.AvoirAchatItemConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.Achat;
import ma.zs.stocky.ws.dto.stock.AchatDto;

@Component
public class AchatConverter extends AbstractConverter<Achat, AchatDto> {

    @Autowired
    private EtatAchatConverter etatAchatConverter ;
    @Autowired
    private AvoirAchatConverter avoirAchatConverter ;
    @Autowired
    private FournisseurConverter fournisseurConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private AchatItemConverter achatItemConverter ;
    @Autowired
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AvoirAchatItemConverter avoirAchatItemConverter ;
    private boolean entrepriseSociete;
    private boolean fournisseur;
    private boolean etatAchat;
    private boolean achatItems;
    private boolean avoirs;

    public  AchatConverter(){
        super(Achat.class, AchatDto.class);
        init(true);
    }

    @Override
    public Achat toItem(AchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        Achat item = new Achat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDateFacture()))
                item.setDateFacture(DateUtil.stringEnToDate(dto.getDateFacture()));
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.entrepriseSociete && dto.getEntrepriseSociete()!=null &&  dto.getEntrepriseSociete().getId() != null)
                item.setEntrepriseSociete(entrepriseSocieteConverter.toItem(dto.getEntrepriseSociete())) ;

            if(this.fournisseur && dto.getFournisseur()!=null &&  dto.getFournisseur().getId() != null)
                item.setFournisseur(fournisseurConverter.toItem(dto.getFournisseur())) ;

            if(this.etatAchat && dto.getEtatAchat()!=null &&  dto.getEtatAchat().getId() != null)
                item.setEtatAchat(etatAchatConverter.toItem(dto.getEtatAchat())) ;


            if(this.achatItems && ListUtil.isNotEmpty(dto.getAchatItems()))
                item.setAchatItems(achatItemConverter.toItem(dto.getAchatItems()));
            if(this.avoirs && ListUtil.isNotEmpty(dto.getAvoirs()))
                item.setAvoirs(avoirAchatConverter.toItem(dto.getAvoirs()));


        return item;
        }
    }

    @Override
    public AchatDto toDto(Achat item) {
        if (item == null) {
            return null;
        } else {
            AchatDto dto = new AchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDateFacture()!=null)
                dto.setDateFacture(DateUtil.dateTimeToString(item.getDateFacture()));
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.entrepriseSociete && item.getEntrepriseSociete()!=null) {
            dto.setEntrepriseSociete(entrepriseSocieteConverter.toDto(item.getEntrepriseSociete())) ;
        }
        if(this.fournisseur && item.getFournisseur()!=null) {
            dto.setFournisseur(fournisseurConverter.toDto(item.getFournisseur())) ;
        }
        if(this.etatAchat && item.getEtatAchat()!=null) {
            dto.setEtatAchat(etatAchatConverter.toDto(item.getEtatAchat())) ;
        }
        if(this.achatItems && ListUtil.isNotEmpty(item.getAchatItems())){
            achatItemConverter.init(true);
            achatItemConverter.setAchat(false);
            dto.setAchatItems(achatItemConverter.toDto(item.getAchatItems()));
            achatItemConverter.setAchat(true);

        }
        if(this.avoirs && ListUtil.isNotEmpty(item.getAvoirs())){
            avoirAchatConverter.init(true);
            avoirAchatConverter.setAchat(false);
            dto.setAvoirs(avoirAchatConverter.toDto(item.getAvoirs()));
            avoirAchatConverter.setAchat(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.achatItems = value;
        this.avoirs = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.fournisseur = value;
        this.etatAchat = value;
    }


    public EtatAchatConverter getEtatAchatConverter(){
        return this.etatAchatConverter;
    }
    public void setEtatAchatConverter(EtatAchatConverter etatAchatConverter ){
        this.etatAchatConverter = etatAchatConverter;
    }
    public AvoirAchatConverter getAvoirAchatConverter(){
        return this.avoirAchatConverter;
    }
    public void setAvoirAchatConverter(AvoirAchatConverter avoirAchatConverter ){
        this.avoirAchatConverter = avoirAchatConverter;
    }
    public FournisseurConverter getFournisseurConverter(){
        return this.fournisseurConverter;
    }
    public void setFournisseurConverter(FournisseurConverter fournisseurConverter ){
        this.fournisseurConverter = fournisseurConverter;
    }
    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public AchatItemConverter getAchatItemConverter(){
        return this.achatItemConverter;
    }
    public void setAchatItemConverter(AchatItemConverter achatItemConverter ){
        this.achatItemConverter = achatItemConverter;
    }
    public EntrepriseSocieteConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteConverter(EntrepriseSocieteConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AvoirAchatItemConverter getAvoirAchatItemConverter(){
        return this.avoirAchatItemConverter;
    }
    public void setAvoirAchatItemConverter(AvoirAchatItemConverter avoirAchatItemConverter ){
        this.avoirAchatItemConverter = avoirAchatItemConverter;
    }
    public boolean  isEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void  setEntrepriseSociete(boolean entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public boolean  isFournisseur(){
        return this.fournisseur;
    }
    public void  setFournisseur(boolean fournisseur){
        this.fournisseur = fournisseur;
    }
    public boolean  isEtatAchat(){
        return this.etatAchat;
    }
    public void  setEtatAchat(boolean etatAchat){
        this.etatAchat = etatAchat;
    }
    public boolean  isAchatItems(){
        return this.achatItems ;
    }
    public void  setAchatItems(boolean achatItems ){
        this.achatItems  = achatItems ;
    }
    public boolean  isAvoirs(){
        return this.avoirs ;
    }
    public void  setAvoirs(boolean avoirs ){
        this.avoirs  = avoirs ;
    }
}
