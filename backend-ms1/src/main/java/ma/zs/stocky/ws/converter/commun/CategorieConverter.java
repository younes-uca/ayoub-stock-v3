package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.Categorie;
import ma.zs.stocky.ws.dto.commun.CategorieDto;

@Component
public class CategorieConverter extends AbstractConverter<Categorie, CategorieDto> {


    public  CategorieConverter(){
        super(Categorie.class, CategorieDto.class);
    }

    @Override
    public Categorie toItem(CategorieDto dto) {
        if (dto == null) {
            return null;
        } else {
        Categorie item = new Categorie();
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
    public CategorieDto toDto(Categorie item) {
        if (item == null) {
            return null;
        } else {
            CategorieDto dto = new CategorieDto();
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
