package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.DepotConverter;
import ma.zs.stocky.ws.converter.stock.ProduitConverter;
import ma.zs.stocky.ws.converter.stock.AchatConverter;

import ma.zs.stocky.bean.core.stock.Produit;
import ma.zs.stocky.bean.core.stock.Achat;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.AchatItem;
import ma.zs.stocky.ws.dto.stock.AchatItemDto;

@Component
public class AchatItemConverter extends AbstractConverter<AchatItem, AchatItemDto> {

    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AchatConverter achatConverter ;
    private boolean produit;
    private boolean achat;
    private boolean depot;

    public  AchatItemConverter(){
        super(AchatItem.class, AchatItemDto.class);
    }

    @Override
    public AchatItem toItem(AchatItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        AchatItem item = new AchatItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getBarCode()))
                item.setBarCode(dto.getBarCode());
            if(StringUtil.isNotEmpty(dto.getFooterBarCode()))
                item.setFooterBarCode(dto.getFooterBarCode());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getQuantiteAvoir()))
                item.setQuantiteAvoir(dto.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(dto.getQuantiteDisponible()))
                item.setQuantiteDisponible(dto.getQuantiteDisponible());
            if(StringUtil.isNotEmpty(dto.getRemise()))
                item.setRemise(dto.getRemise());
            if(StringUtil.isNotEmpty(dto.getPrixUnitaireTtc()))
                item.setPrixUnitaireTtc(dto.getPrixUnitaireTtc());
            if(StringUtil.isNotEmpty(dto.getPrixUnitaireHt()))
                item.setPrixUnitaireHt(dto.getPrixUnitaireHt());
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setReference(dto.getProduit().getReference());
            }

            if(dto.getAchat() != null && dto.getAchat().getId() != null){
                item.setAchat(new Achat());
                item.getAchat().setId(dto.getAchat().getId());
                item.getAchat().setId(dto.getAchat().getId());
            }

            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;




        return item;
        }
    }

    @Override
    public AchatItemDto toDto(AchatItem item) {
        if (item == null) {
            return null;
        } else {
            AchatItemDto dto = new AchatItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getBarCode()))
                dto.setBarCode(item.getBarCode());
            if(StringUtil.isNotEmpty(item.getFooterBarCode()))
                dto.setFooterBarCode(item.getFooterBarCode());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getQuantiteAvoir()))
                dto.setQuantiteAvoir(item.getQuantiteAvoir());
            if(StringUtil.isNotEmpty(item.getQuantiteDisponible()))
                dto.setQuantiteDisponible(item.getQuantiteDisponible());
            if(StringUtil.isNotEmpty(item.getRemise()))
                dto.setRemise(item.getRemise());
            if(StringUtil.isNotEmpty(item.getPrixUnitaireTtc()))
                dto.setPrixUnitaireTtc(item.getPrixUnitaireTtc());
            if(StringUtil.isNotEmpty(item.getPrixUnitaireHt()))
                dto.setPrixUnitaireHt(item.getPrixUnitaireHt());
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.achat && item.getAchat()!=null) {
            dto.setAchat(achatConverter.toDto(item.getAchat())) ;
        }
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.achat = value;
        this.depot = value;
    }


    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AchatConverter getAchatConverter(){
        return this.achatConverter;
    }
    public void setAchatConverter(AchatConverter achatConverter ){
        this.achatConverter = achatConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
}
