package  ma.zs.stocky.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.DepotConverter;
import ma.zs.stocky.ws.converter.gestionchequeffet.PermutationConverter;
import ma.zs.stocky.ws.converter.stock.ProduitConverter;

import ma.zs.stocky.bean.core.stock.Produit;
import ma.zs.stocky.bean.core.gestionchequeffet.Permutation;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.gestionchequeffet.PermutationItem;
import ma.zs.stocky.ws.dto.gestionchequeffet.PermutationItemDto;

@Component
public class PermutationItemConverter extends AbstractConverter<PermutationItem, PermutationItemDto> {

    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private PermutationConverter permutationConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    private boolean produit;
    private boolean depot;
    private boolean permutation;

    public  PermutationItemConverter(){
        super(PermutationItem.class, PermutationItemDto.class);
    }

    @Override
    public PermutationItem toItem(PermutationItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        PermutationItem item = new PermutationItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getQuantite()))
                item.setQuantite(dto.getQuantite());
            if(dto.getProduit() != null && dto.getProduit().getId() != null){
                item.setProduit(new Produit());
                item.getProduit().setId(dto.getProduit().getId());
                item.getProduit().setReference(dto.getProduit().getReference());
            }

            if(this.depot && dto.getDepot()!=null &&  dto.getDepot().getId() != null)
                item.setDepot(depotConverter.toItem(dto.getDepot())) ;

            if(dto.getPermutation() != null && dto.getPermutation().getId() != null){
                item.setPermutation(new Permutation());
                item.getPermutation().setId(dto.getPermutation().getId());
                item.getPermutation().setId(dto.getPermutation().getId());
            }




        return item;
        }
    }

    @Override
    public PermutationItemDto toDto(PermutationItem item) {
        if (item == null) {
            return null;
        } else {
            PermutationItemDto dto = new PermutationItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getQuantite()))
                dto.setQuantite(item.getQuantite());
        if(this.produit && item.getProduit()!=null) {
            dto.setProduit(produitConverter.toDto(item.getProduit())) ;
        }
        if(this.depot && item.getDepot()!=null) {
            dto.setDepot(depotConverter.toDto(item.getDepot())) ;
        }
        if(this.permutation && item.getPermutation()!=null) {
            dto.setPermutation(permutationConverter.toDto(item.getPermutation())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.produit = value;
        this.depot = value;
        this.permutation = value;
    }


    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public PermutationConverter getPermutationConverter(){
        return this.permutationConverter;
    }
    public void setPermutationConverter(PermutationConverter permutationConverter ){
        this.permutationConverter = permutationConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
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
    public boolean  isPermutation(){
        return this.permutation;
    }
    public void  setPermutation(boolean permutation){
        this.permutation = permutation;
    }
}
