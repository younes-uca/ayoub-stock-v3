package  ma.zs.stocky.ws.converter.paiement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.ModePaiementConverter;
import ma.zs.stocky.ws.converter.stock.AchatConverter;

import ma.zs.stocky.bean.core.stock.Achat;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.paiement.PaiementAchat;
import ma.zs.stocky.ws.dto.paiement.PaiementAchatDto;

@Component
public class PaiementAchatConverter extends AbstractConverter<PaiementAchat, PaiementAchatDto> {

    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    @Autowired
    private AchatConverter achatConverter ;
    private boolean achat;
    private boolean modePaiement;

    public  PaiementAchatConverter(){
        super(PaiementAchat.class, PaiementAchatDto.class);
    }

    @Override
    public PaiementAchat toItem(PaiementAchatDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementAchat item = new PaiementAchat();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(StringUtil.isNotEmpty(dto.getMontant()))
                item.setMontant(dto.getMontant());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getAchat() != null && dto.getAchat().getId() != null){
                item.setAchat(new Achat());
                item.getAchat().setId(dto.getAchat().getId());
                item.getAchat().setId(dto.getAchat().getId());
            }

            if(this.modePaiement && dto.getModePaiement()!=null &&  dto.getModePaiement().getId() != null)
                item.setModePaiement(modePaiementConverter.toItem(dto.getModePaiement())) ;




        return item;
        }
    }

    @Override
    public PaiementAchatDto toDto(PaiementAchat item) {
        if (item == null) {
            return null;
        } else {
            PaiementAchatDto dto = new PaiementAchatDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
            if(StringUtil.isNotEmpty(item.getMontant()))
                dto.setMontant(item.getMontant());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.achat && item.getAchat()!=null) {
            dto.setAchat(achatConverter.toDto(item.getAchat())) ;
        }
        if(this.modePaiement && item.getModePaiement()!=null) {
            dto.setModePaiement(modePaiementConverter.toDto(item.getModePaiement())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.achat = value;
        this.modePaiement = value;
    }


    public ModePaiementConverter getModePaiementConverter(){
        return this.modePaiementConverter;
    }
    public void setModePaiementConverter(ModePaiementConverter modePaiementConverter ){
        this.modePaiementConverter = modePaiementConverter;
    }
    public AchatConverter getAchatConverter(){
        return this.achatConverter;
    }
    public void setAchatConverter(AchatConverter achatConverter ){
        this.achatConverter = achatConverter;
    }
    public boolean  isAchat(){
        return this.achat;
    }
    public void  setAchat(boolean achat){
        this.achat = achat;
    }
    public boolean  isModePaiement(){
        return this.modePaiement;
    }
    public void  setModePaiement(boolean modePaiement){
        this.modePaiement = modePaiement;
    }
}
