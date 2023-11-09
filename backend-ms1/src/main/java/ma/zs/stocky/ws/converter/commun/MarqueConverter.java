package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.Marque;
import ma.zs.stocky.ws.dto.commun.MarqueDto;

@Component
public class MarqueConverter extends AbstractConverter<Marque, MarqueDto> {


    public  MarqueConverter(){
        super(Marque.class, MarqueDto.class);
    }

    @Override
    public Marque toItem(MarqueDto dto) {
        if (dto == null) {
            return null;
        } else {
        Marque item = new Marque();
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
    public MarqueDto toDto(Marque item) {
        if (item == null) {
            return null;
        } else {
            MarqueDto dto = new MarqueDto();
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
