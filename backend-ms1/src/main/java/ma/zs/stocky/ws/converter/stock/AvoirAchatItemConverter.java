package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.DepotConverter;
import ma.zs.stocky.ws.converter.stock.ProduitConverter;
import ma.zs.stocky.ws.converter.stock.AvoirAchatConverter;

import ma.zs.stocky.bean.core.stock.Produit;
import ma.zs.stocky.bean.core.stock.AvoirAchat;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.AvoirAchatItem;
import ma.zs.stocky.ws.dto.stock.AvoirAchatItemDto;

@Component
public class AvoirAchatItemConverter extends AbstractConverter<AvoirAchatItem, AvoirAchatItemDto> {

    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AvoirAchatConverter avoirAchatConverter ;
    private boolean produit;
    private boolean depot;
    private boolean avoirAchat;

    public  AvoirAchatItemConverter(){
        super(AvoirAchatItem.class, AvoirAchatItemDto.class);
    }

    @Override
    public AvoirAchatItem toItem(AvoirAchatItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        AvoirAchatItem item = new AvoirAchatItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMontantAvoir()))
                item.setMontantAvoir(dto.getMontantAvoir());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setReference(dto.getProduit().getReference());
            }

            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;

            if(dto.getAvoirAchat() != null && dto.getAvoirAchat().getId() != null){
                item.setAvoirAchat(new AvoirAchat());
                item.getAvoirAchat().setId(dto.getAvoirAchat().getId());
                item.getAvoirAchat().setId(dto.getAvoirAchat().getId());
            }




        return item;
        }
    }

    @Override
    public AvoirAchatItemDto toDto(AvoirAchatItem item) {
        if (item == null) {
            return null;
        } else {
            AvoirAchatItemDto dto = new AvoirAchatItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getMontantAvoir()))
                dto.setMontantAvoir(item.getMontantAvoir());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }
        if(this.avoirAchat && item.getAvoirAchat()!=null) {
            dto.setAvoirAchat(avoirAchatConverter.toDto(item.getAvoirAchat())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.depot = value;
        this.avoirAchat = value;
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
    public AvoirAchatConverter getAvoirAchatConverter(){
        return this.avoirAchatConverter;
    }
    public void setAvoirAchatConverter(AvoirAchatConverter avoirAchatConverter ){
        this.avoirAchatConverter = avoirAchatConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isDepot(){
        return this.depot;
    }
    public void  setDepot(boolean depot){
        this.depot = depot;
    }
    public boolean  isAvoirAchat(){
        return this.avoirAchat;
    }
    public void  setAvoirAchat(boolean avoirAchat){
        this.avoirAchat = avoirAchat;
    }
}
