package  ma.zs.stocky.ws.converter.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.stocky.zynerator.util.ListUtil;

import ma.zs.stocky.ws.converter.stock.TauxTvaConverter;
import ma.zs.stocky.ws.converter.stock.VenteItemConverter;
import ma.zs.stocky.ws.converter.commun.ClientConverter;
import ma.zs.stocky.ws.converter.stock.AvoirVenteItemConverter;
import ma.zs.stocky.ws.converter.commun.DepotConverter;
import ma.zs.stocky.ws.converter.commun.EntrepriseSocieteConverter;
import ma.zs.stocky.ws.converter.commun.EtatVenteConverter;
import ma.zs.stocky.ws.converter.stock.ProduitConverter;
import ma.zs.stocky.ws.converter.stock.AvoirVenteConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stock.Vente;
import ma.zs.stocky.ws.dto.stock.VenteDto;

@Component
public class VenteConverter extends AbstractConverter<Vente, VenteDto> {

    @Autowired
    private TauxTvaConverter tauxTvaConverter ;
    @Autowired
    private VenteItemConverter venteItemConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private AvoirVenteItemConverter avoirVenteItemConverter ;
    @Autowired
    private DepotConverter depotConverter ;
    @Autowired
    private EntrepriseSocieteConverter entrepriseSocieteConverter ;
    @Autowired
    private EtatVenteConverter etatVenteConverter ;
    @Autowired
    private ProduitConverter produitConverter ;
    @Autowired
    private AvoirVenteConverter avoirVenteConverter ;
    private boolean entrepriseSociete;
    private boolean client;
    private boolean etatVente;
    private boolean venteItems;
    private boolean avoirs;

    public  VenteConverter(){
        super(Vente.class, VenteDto.class);
        init(true);
    }

    @Override
    public Vente toItem(VenteDto dto) {
        if (dto == null) {
            return null;
        } else {
        Vente item = new Vente();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCodeVente()))
                item.setCodeVente(dto.getCodeVente());
            if(StringUtil.isNotEmpty(dto.getMontantHt()))
                item.setMontantHt(dto.getMontantHt());
            if(StringUtil.isNotEmpty(dto.getMontantTva()))
                item.setMontantTva(dto.getMontantTva());
            if(StringUtil.isNotEmpty(dto.getMontantTtc()))
                item.setMontantTtc(dto.getMontantTtc());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(this.entrepriseSociete && dto.getEntrepriseSociete()!=null &&  dto.getEntrepriseSociete().getId() != null)
                item.setEntrepriseSociete(entrepriseSocieteConverter.toItem(dto.getEntrepriseSociete())) ;

            if(this.client && dto.getClient()!=null &&  dto.getClient().getId() != null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.etatVente && dto.getEtatVente()!=null &&  dto.getEtatVente().getId() != null)
                item.setEtatVente(etatVenteConverter.toItem(dto.getEtatVente())) ;


            if(this.venteItems && ListUtil.isNotEmpty(dto.getVenteItems()))
                item.setVenteItems(venteItemConverter.toItem(dto.getVenteItems()));
            if(this.avoirs && ListUtil.isNotEmpty(dto.getAvoirs()))
                item.setAvoirs(avoirVenteConverter.toItem(dto.getAvoirs()));


        return item;
        }
    }

    @Override
    public VenteDto toDto(Vente item) {
        if (item == null) {
            return null;
        } else {
            VenteDto dto = new VenteDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCodeVente()))
                dto.setCodeVente(item.getCodeVente());
            if(StringUtil.isNotEmpty(item.getMontantHt()))
                dto.setMontantHt(item.getMontantHt());
            if(StringUtil.isNotEmpty(item.getMontantTva()))
                dto.setMontantTva(item.getMontantTva());
            if(StringUtil.isNotEmpty(item.getMontantTtc()))
                dto.setMontantTtc(item.getMontantTtc());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.entrepriseSociete && item.getEntrepriseSociete()!=null) {
            dto.setEntrepriseSociete(entrepriseSocieteConverter.toDto(item.getEntrepriseSociete())) ;
        }
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.etatVente && item.getEtatVente()!=null) {
            dto.setEtatVente(etatVenteConverter.toDto(item.getEtatVente())) ;
        }
        if(this.venteItems && ListUtil.isNotEmpty(item.getVenteItems())){
            venteItemConverter.init(true);
            venteItemConverter.setVente(false);
            dto.setVenteItems(venteItemConverter.toDto(item.getVenteItems()));
            venteItemConverter.setVente(true);

        }
        if(this.avoirs && ListUtil.isNotEmpty(item.getAvoirs())){
            avoirVenteConverter.init(true);
            avoirVenteConverter.setVente(false);
            dto.setAvoirs(avoirVenteConverter.toDto(item.getAvoirs()));
            avoirVenteConverter.setVente(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.venteItems = value;
        this.avoirs = value;
    }

    public void initObject(boolean value) {
        this.entrepriseSociete = value;
        this.client = value;
        this.etatVente = value;
    }


    public TauxTvaConverter getTauxTvaConverter(){
        return this.tauxTvaConverter;
    }
    public void setTauxTvaConverter(TauxTvaConverter tauxTvaConverter ){
        this.tauxTvaConverter = tauxTvaConverter;
    }
    public VenteItemConverter getVenteItemConverter(){
        return this.venteItemConverter;
    }
    public void setVenteItemConverter(VenteItemConverter venteItemConverter ){
        this.venteItemConverter = venteItemConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public AvoirVenteItemConverter getAvoirVenteItemConverter(){
        return this.avoirVenteItemConverter;
    }
    public void setAvoirVenteItemConverter(AvoirVenteItemConverter avoirVenteItemConverter ){
        this.avoirVenteItemConverter = avoirVenteItemConverter;
    }
    public DepotConverter getDepotConverter(){
        return this.depotConverter;
    }
    public void setDepotConverter(DepotConverter depotConverter ){
        this.depotConverter = depotConverter;
    }
    public EntrepriseSocieteConverter getEntrepriseSocieteConverter(){
        return this.entrepriseSocieteConverter;
    }
    public void setEntrepriseSocieteConverter(EntrepriseSocieteConverter entrepriseSocieteConverter ){
        this.entrepriseSocieteConverter = entrepriseSocieteConverter;
    }
    public EtatVenteConverter getEtatVenteConverter(){
        return this.etatVenteConverter;
    }
    public void setEtatVenteConverter(EtatVenteConverter etatVenteConverter ){
        this.etatVenteConverter = etatVenteConverter;
    }
    public ProduitConverter getProduitConverter(){
        return this.produitConverter;
    }
    public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
    }
    public AvoirVenteConverter getAvoirVenteConverter(){
        return this.avoirVenteConverter;
    }
    public void setAvoirVenteConverter(AvoirVenteConverter avoirVenteConverter ){
        this.avoirVenteConverter = avoirVenteConverter;
    }
    public boolean  isEntrepriseSociete(){
        return this.entrepriseSociete;
    }
    public void  setEntrepriseSociete(boolean entrepriseSociete){
        this.entrepriseSociete = entrepriseSociete;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isEtatVente(){
        return this.etatVente;
    }
    public void  setEtatVente(boolean etatVente){
        this.etatVente = etatVente;
    }
    public boolean  isVenteItems(){
        return this.venteItems ;
    }
    public void  setVenteItems(boolean venteItems ){
        this.venteItems  = venteItems ;
    }
    public boolean  isAvoirs(){
        return this.avoirs ;
    }
    public void  setAvoirs(boolean avoirs ){
        this.avoirs  = avoirs ;
    }
}
