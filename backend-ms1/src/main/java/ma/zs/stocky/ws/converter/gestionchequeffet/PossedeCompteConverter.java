package  ma.zs.stocky.ws.converter.gestionchequeffet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.gestionchequeffet.BanqueConverter;
import ma.zs.stocky.ws.converter.gestionchequeffet.ProprietaireConverter;
import ma.zs.stocky.ws.converter.gestionchequeffet.CompteConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.gestionchequeffet.PossedeCompte;
import ma.zs.stocky.ws.dto.gestionchequeffet.PossedeCompteDto;

@Component
public class PossedeCompteConverter extends AbstractConverter<PossedeCompte, PossedeCompteDto> {

    @Autowired
    private BanqueConverter banqueConverter ;
    @Autowired
    private ProprietaireConverter proprietaireConverter ;
    @Autowired
    private CompteConverter compteConverter ;
    private boolean proprietaire;
    private boolean banque;
    private boolean compte;

    public  PossedeCompteConverter(){
        super(PossedeCompte.class, PossedeCompteDto.class);
    }

    @Override
    public PossedeCompte toItem(PossedeCompteDto dto) {
        if (dto == null) {
            return null;
        } else {
        PossedeCompte item = new PossedeCompte();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(this.proprietaire && dto.getProprietaire()!=null &&  dto.getProprietaire().getId() != null)
                item.setProprietaire(proprietaireConverter.toItem(dto.getProprietaire())) ;

            if(this.banque && dto.getBanque()!=null &&  dto.getBanque().getId() != null)
                item.setBanque(banqueConverter.toItem(dto.getBanque())) ;

            if(this.compte && dto.getCompte()!=null &&  dto.getCompte().getId() != null)
                item.setCompte(compteConverter.toItem(dto.getCompte())) ;




        return item;
        }
    }

    @Override
    public PossedeCompteDto toDto(PossedeCompte item) {
        if (item == null) {
            return null;
        } else {
            PossedeCompteDto dto = new PossedeCompteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
        if(this.proprietaire && item.getProprietaire()!=null) {
            dto.setProprietaire(proprietaireConverter.toDto(item.getProprietaire())) ;
        }
        if(this.banque && item.getBanque()!=null) {
            dto.setBanque(banqueConverter.toDto(item.getBanque())) ;
        }
        if(this.compte && item.getCompte()!=null) {
            dto.setCompte(compteConverter.toDto(item.getCompte())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.proprietaire = value;
        this.banque = value;
        this.compte = value;
    }


    public BanqueConverter getBanqueConverter(){
        return this.banqueConverter;
    }
    public void setBanqueConverter(BanqueConverter banqueConverter ){
        this.banqueConverter = banqueConverter;
    }
    public ProprietaireConverter getProprietaireConverter(){
        return this.proprietaireConverter;
    }
    public void setProprietaireConverter(ProprietaireConverter proprietaireConverter ){
        this.proprietaireConverter = proprietaireConverter;
    }
    public CompteConverter getCompteConverter(){
        return this.compteConverter;
    }
    public void setCompteConverter(CompteConverter compteConverter ){
        this.compteConverter = compteConverter;
    }
    public boolean  isProprietaire(){
        return this.proprietaire;
    }
    public void  setProprietaire(boolean proprietaire){
        this.proprietaire = proprietaire;
    }
    public boolean  isBanque(){
        return this.banque;
    }
    public void  setBanque(boolean banque){
        this.banque = banque;
    }
    public boolean  isCompte(){
        return this.compte;
    }
    public void  setCompte(boolean compte){
        this.compte = compte;
    }
}
