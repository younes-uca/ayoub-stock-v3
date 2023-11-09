package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.VilleConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.Fournisseur;
import ma.zs.stocky.ws.dto.commun.FournisseurDto;

@Component
public class FournisseurConverter extends AbstractConverter<Fournisseur, FournisseurDto> {

    @Autowired
    private VilleConverter villeConverter ;
    private boolean ville;

    public  FournisseurConverter(){
        super(Fournisseur.class, FournisseurDto.class);
    }

    @Override
    public Fournisseur toItem(FournisseurDto dto) {
        if (dto == null) {
            return null;
        } else {
        Fournisseur item = new Fournisseur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());
            if(StringUtil.isNotEmpty(dto.getTelephone()))
                item.setTelephone(dto.getTelephone());
            if(StringUtil.isNotEmpty(dto.getInfoBancaire()))
                item.setInfoBancaire(dto.getInfoBancaire());
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());
            if(StringUtil.isNotEmpty(dto.getCreance()))
                item.setCreance(dto.getCreance());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.ville && dto.getVille()!=null &&  dto.getVille().getId() != null)
                item.setVille(villeConverter.toItem(dto.getVille())) ;




        return item;
        }
    }

    @Override
    public FournisseurDto toDto(Fournisseur item) {
        if (item == null) {
            return null;
        } else {
            FournisseurDto dto = new FournisseurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
            if(StringUtil.isNotEmpty(item.getTelephone()))
                dto.setTelephone(item.getTelephone());
            if(StringUtil.isNotEmpty(item.getInfoBancaire()))
                dto.setInfoBancaire(item.getInfoBancaire());
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());
            if(StringUtil.isNotEmpty(item.getCreance()))
                dto.setCreance(item.getCreance());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.ville && item.getVille()!=null) {
            dto.setVille(villeConverter.toDto(item.getVille())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.ville = value;
    }


    public VilleConverter getVilleConverter(){
        return this.villeConverter;
    }
    public void setVilleConverter(VilleConverter villeConverter ){
        this.villeConverter = villeConverter;
    }
    public boolean  isVille(){
        return this.ville;
    }
    public void  setVille(boolean ville){
        this.ville = ville;
    }
}
