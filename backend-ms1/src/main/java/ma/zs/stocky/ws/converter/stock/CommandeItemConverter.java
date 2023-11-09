package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.stock.ProduitConverter;
import ma.zs.stocky.ws.converter.stock.CommandeConverter;

import ma.zs.stocky.bean.core.stock.Produit;
import ma.zs.stocky.bean.core.stock.Commande;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.CommandeItem;
import ma.zs.stocky.ws.dto.stock.CommandeItemDto;

@Component
public class CommandeItemConverter extends AbstractConverter<CommandeItem, CommandeItemDto> {

    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private CommandeConverter commandeConverter ;
    private boolean produit;
    private boolean commande;

    public  CommandeItemConverter(){
        super(CommandeItem.class, CommandeItemDto.class);
    }

    @Override
    public CommandeItem toItem(CommandeItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        CommandeItem item = new CommandeItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setReference(dto.getProduit().getReference());
            }

            if(dto.getCommande() != null && dto.getCommande().getId() != null){
                item.setCommande(new Commande());
                item.getCommande().setId(dto.getCommande().getId());
                item.getCommande().setId(dto.getCommande().getId());
            }




        return item;
        }
    }

    @Override
    public CommandeItemDto toDto(CommandeItem item) {
        if (item == null) {
            return null;
        } else {
            CommandeItemDto dto = new CommandeItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.commande && item.getCommande()!=null) {
            dto.setCommande(commandeConverter.toDto(item.getCommande())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.commande = value;
    }


    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public CommandeConverter getCommandeConverter(){
        return this.commandeConverter;
    }
    public void setCommandeConverter(CommandeConverter commandeConverter ){
        this.commandeConverter = commandeConverter;
    }
    public boolean  isProduit(){
        return this.produit;
    }
    public void  setProduit(boolean produit){
        this.produit = produit;
    }
    public boolean  isCommande(){
        return this.commande;
    }
    public void  setCommande(boolean commande){
        this.commande = commande;
    }
}
