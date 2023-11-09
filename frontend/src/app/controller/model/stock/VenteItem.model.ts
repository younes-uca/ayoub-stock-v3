import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DepotDto} from '../commun/Depot.model';
import {TauxTvaDto} from './TauxTva.model';
import {ProduitDto} from './Produit.model';
import {VenteDto} from './Vente.model';

export class VenteItemDto extends BaseDto{

    public barCode: string;

    public quantite: null | number;

    public quantiteAvoir: null | number;

    public quantiteVendue: null | number;

    public remise: null | number;

    public prixUnitaireTtc: null | number;

    public prixUnitaireHt: null | number;

    public montantHt: null | number;

    public montantTtc: null | number;

    public produit: ProduitDto ;
    public tauxTva: TauxTvaDto ;
    public vente: VenteDto ;
    public depot: DepotDto ;
    

    constructor() {
        super();

        this.barCode = '';
        this.quantite = null;
        this.quantiteAvoir = null;
        this.quantiteVendue = null;
        this.remise = null;
        this.prixUnitaireTtc = null;
        this.prixUnitaireHt = null;
        this.montantHt = null;
        this.montantTtc = null;
        this.produit = new ProduitDto() ;
        this.tauxTva = new TauxTvaDto() ;
        this.vente = new VenteDto() ;
        this.depot = new DepotDto() ;

        }

}
