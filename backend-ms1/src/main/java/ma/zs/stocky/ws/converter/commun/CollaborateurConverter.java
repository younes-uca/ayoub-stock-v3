package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.Collaborateur;
import ma.zs.stocky.ws.dto.commun.CollaborateurDto;

@Component
public class CollaborateurConverter extends AbstractConverter<Collaborateur, CollaborateurDto> {


    public  CollaborateurConverter(){
        super(Collaborateur.class, CollaborateurDto.class);
    }

    @Override
    public Collaborateur toItem(CollaborateurDto dto) {
        if (dto == null) {
            return null;
        } else {
        Collaborateur item = new Collaborateur();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());



        return item;
        }
    }

    @Override
    public CollaborateurDto toDto(Collaborateur item) {
        if (item == null) {
            return null;
        } else {
            CollaborateurDto dto = new CollaborateurDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
