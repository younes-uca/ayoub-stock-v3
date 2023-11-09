package  ma.zs.stocky.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.gestionchequeffet.Banque;
import ma.zs.stocky.ws.dto.gestionchequeffet.BanqueDto;

@Component
public class BanqueConverter extends AbstractConverter<Banque, BanqueDto> {


    public  BanqueConverter(){
        super(Banque.class, BanqueDto.class);
    }

    @Override
    public Banque toItem(BanqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        Banque item = new Banque();
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
    public BanqueDto toDto(Banque item) {
        if (item == null) {
            return null;
        } else {
            BanqueDto dto = new BanqueDto();
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
