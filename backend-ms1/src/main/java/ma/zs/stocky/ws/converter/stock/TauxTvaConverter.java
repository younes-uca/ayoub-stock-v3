package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.TauxTva;
import ma.zs.stocky.ws.dto.stock.TauxTvaDto;

@Component
public class TauxTvaConverter extends AbstractConverter<TauxTva, TauxTvaDto> {


    public  TauxTvaConverter(){
        super(TauxTva.class, TauxTvaDto.class);
    }

    @Override
    public TauxTva toItem(TauxTvaDto dto) {
        if (dto == null) {
            return null;
        } else {
        TauxTva item = new TauxTva();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public TauxTvaDto toDto(TauxTva item) {
        if (item == null) {
            return null;
        } else {
            TauxTvaDto dto = new TauxTvaDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}
