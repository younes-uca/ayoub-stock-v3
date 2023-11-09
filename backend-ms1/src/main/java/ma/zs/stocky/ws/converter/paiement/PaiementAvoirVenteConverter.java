package  ma.zs.stocky.ws.converter.paiement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.ModePaiementConverter;
import ma.zs.stocky.ws.converter.stock.VenteConverter;
import ma.zs.stocky.ws.converter.stock.AvoirVenteConverter;

import ma.zs.stocky.bean.core.stock.Vente;
import ma.zs.stocky.bean.core.stock.AvoirVente;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.paiement.PaiementAvoirVente;
import ma.zs.stocky.ws.dto.paiement.PaiementAvoirVenteDto;

@Component
public class PaiementAvoirVenteConverter extends AbstractConverter<PaiementAvoirVente, PaiementAvoirVenteDto> {

    @Autowired
    private ModePaiementConverter modePaiementConverter ;
    @Autowired
    private VenteConverter venteConverter ;
    @Autowired
    private AvoirVenteConverter avoirVenteConverter ;
    private boolean vente;
    private boolean modePaiement;
    private boolean avoirVente;

    public  PaiementAvoirVenteConverter(){
        super(PaiementAvoirVente.class, PaiementAvoirVenteDto.class);
    }

    @Override
    public PaiementAvoirVente toItem(PaiementAvoirVenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaiementAvoirVente item = new PaiementAvoirVente();
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
            if(dto.getVente() != null && dto.getVente().getId() != null){
                item.setVente(new Vente());
                item.getVente().setId(dto.getVente().getId());
                item.getVente().setId(dto.getVente().getId());
            }

            if(this.modePaiement && dto.getModePaiement()!=null &&  dto.getModePaiement().getId() != null)
                item.setModePaiement(modePaiementConverter.toItem(dto.getModePaiement())) ;

            if(dto.getAvoirVente() != null && dto.getAvoirVente().getId() != null){
                item.setAvoirVente(new AvoirVente());
                item.getAvoirVente().setId(dto.getAvoirVente().getId());
                item.getAvoirVente().setId(dto.getAvoirVente().getId());
            }




        return item;
        }
    }

    @Override
    public PaiementAvoirVenteDto toDto(PaiementAvoirVente item) {
        if (item == null) {
            return null;
        } else {
            PaiementAvoirVenteDto dto = new PaiementAvoirVenteDto();
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
        if(this.vente && item.getVente()!=null) {
            dto.setVente(venteConverter.toDto(item.getVente())) ;
        }
        if(this.modePaiement && item.getModePaiement()!=null) {
            dto.setModePaiement(modePaiementConverter.toDto(item.getModePaiement())) ;
        }
        if(this.avoirVente && item.getAvoirVente()!=null) {
            dto.setAvoirVente(avoirVenteConverter.toDto(item.getAvoirVente())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.vente = value;
        this.modePaiement = value;
        this.avoirVente = value;
    }


    public ModePaiementConverter getModePaiementConverter(){
        return this.modePaiementConverter;
    }
    public void setModePaiementConverter(ModePaiementConverter modePaiementConverter ){
        this.modePaiementConverter = modePaiementConverter;
    }
    public VenteConverter getVenteConverter(){
        return this.venteConverter;
    }
    public void setVenteConverter(VenteConverter venteConverter ){
        this.venteConverter = venteConverter;
    }
    public AvoirVenteConverter getAvoirVenteConverter(){
        return this.avoirVenteConverter;
    }
    public void setAvoirVenteConverter(AvoirVenteConverter avoirVenteConverter ){
        this.avoirVenteConverter = avoirVenteConverter;
    }
    public boolean  isVente(){
        return this.vente;
    }
    public void  setVente(boolean vente){
        this.vente = vente;
    }
    public boolean  isModePaiement(){
        return this.modePaiement;
    }
    public void  setModePaiement(boolean modePaiement){
        this.modePaiement = modePaiement;
    }
    public boolean  isAvoirVente(){
        return this.avoirVente;
    }
    public void  setAvoirVente(boolean avoirVente){
        this.avoirVente = avoirVente;
    }
}
