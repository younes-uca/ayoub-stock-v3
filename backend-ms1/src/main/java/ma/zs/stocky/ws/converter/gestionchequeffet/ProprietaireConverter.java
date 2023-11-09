package  ma.zs.stocky.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.gestionchequeffet.Proprietaire;
import ma.zs.stocky.ws.dto.gestionchequeffet.ProprietaireDto;

@Component
public class ProprietaireConverter extends AbstractConverter<Proprietaire, ProprietaireDto> {


    public  ProprietaireConverter(){
        super(Proprietaire.class, ProprietaireDto.class);
    }

    @Override
    public Proprietaire toItem(ProprietaireDto dto) {
        if (dto == null) {
            return null;
        } else {
        Proprietaire item = new Proprietaire();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public ProprietaireDto toDto(Proprietaire item) {
        if (item == null) {
            return null;
        } else {
            ProprietaireDto dto = new ProprietaireDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
