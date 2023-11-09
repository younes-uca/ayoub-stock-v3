package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.EtatAchat;
import ma.zs.stocky.ws.dto.commun.EtatAchatDto;

@Component
public class EtatAchatConverter extends AbstractConverter<EtatAchat, EtatAchatDto> {


    public  EtatAchatConverter(){
        super(EtatAchat.class, EtatAchatDto.class);
    }

    @Override
    public EtatAchat toItem(EtatAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatAchat item = new EtatAchat();
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
    public EtatAchatDto toDto(EtatAchat item) {
        if (item == null) {
            return null;
        } else {
            EtatAchatDto dto = new EtatAchatDto();
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
