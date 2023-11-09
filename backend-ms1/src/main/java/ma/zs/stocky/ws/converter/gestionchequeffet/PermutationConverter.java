package  ma.zs.stocky.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.commun.DepotConverter;
import ma.zs.stocky.ws.converter.stock.ProduitConverter;
import ma.zs.stocky.ws.converter.gestionchequeffet.PermutationItemConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.gestionchequeffet.Permutation;
import ma.zs.stocky.ws.dto.gestionchequeffet.PermutationDto;

@Component
public class PermutationConverter extends AbstractConverter<Permutation, PermutationDto> {

    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private PermutationItemConverter permutationItemConverter ;
    private boolean permutationItems;

    public  PermutationConverter(){
        super(Permutation.class, PermutationDto.class);
        init(true);
    }

    @Override
    public Permutation toItem(PermutationDto dto) {
        if (dto == null) {
            return null;
        } else {
        Permutation item = new Permutation();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDatePermutation()))
                item.setDatePermutation(DateUtil.stringEnToDate(dto.getDatePermutation()));
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());

            if(this.permutationItems && ListUtil.isNotEmpty(dto.getPermutationItems()))
                item.setPermutationItems(permutationItemConverter.toItem(dto.getPermutationItems()));


        return item;
        }
    }

    @Override
    public PermutationDto toDto(Permutation item) {
        if (item == null) {
            return null;
        } else {
            PermutationDto dto = new PermutationDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDatePermutation()!=null)
                dto.setDatePermutation(DateUtil.dateTimeToString(item.getDatePermutation()));
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.permutationItems && ListUtil.isNotEmpty(item.getPermutationItems())){
            permutationItemConverter.init(true);
            permutationItemConverter.setPermutation(false);
            dto.setPermutationItems(permutationItemConverter.toDto(item.getPermutationItems()));
            permutationItemConverter.setPermutation(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.permutationItems = value;
    }

    public void initObject(boolean value) {
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
    public PermutationItemConverter getPermutationItemConverter(){
        return this.permutationItemConverter;
    }
    public void setPermutationItemConverter(PermutationItemConverter permutationItemConverter ){
        this.permutationItemConverter = permutationItemConverter;
    }
    public boolean  isPermutationItems(){
        return this.permutationItems ;
    }
    public void  setPermutationItems(boolean permutationItems ){
        this.permutationItems  = permutationItems ;
    }
}
