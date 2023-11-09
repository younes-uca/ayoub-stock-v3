package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.ModePaiement;
import ma.zs.stocky.ws.dto.commun.ModePaiementDto;

@Component
public class ModePaiementConverter extends AbstractConverter<ModePaiement, ModePaiementDto> {


    public  ModePaiementConverter(){
        super(ModePaiement.class, ModePaiementDto.class);
    }

    @Override
    public ModePaiement toItem(ModePaiementDto dto) {
        if (dto == null) {
            return null;
        } else {
        ModePaiement item = new ModePaiement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public ModePaiementDto toDto(ModePaiement item) {
        if (item == null) {
            return null;
        } else {
            ModePaiementDto dto = new ModePaiementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
