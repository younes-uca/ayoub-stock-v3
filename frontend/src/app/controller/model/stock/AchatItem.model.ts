import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DepotDto} from '../commun/Depot.model';
import {ProduitDto} from './Produit.model';
import {AchatDto} from './Achat.model';

export class AchatItemDto extends BaseDto{

    public barCode: string;

    public footerBarCode: string;

    public quantite: null | number;

    public quantiteAvoir: null | number;

    public quantiteDisponible: null | number;

    public remise: null | number;

    public prixUnitaireTtc: null | number;

    public prixUnitaireHt: null | number;

    public montantHt: null | number;

    public montantTtc: null | number;

    public produit: ProduitDto ;
    public achat: AchatDto ;
    public depot: DepotDto ;
    

    constructor() {
        super();

        this.barCode = '';
        this.footerBarCode = '';
        this.quantite = null;
        this.quantiteAvoir = null;
        this.quantiteDisponible = null;
        this.remise = null;
        this.prixUnitaireTtc = null;
        this.prixUnitaireHt = null;
        this.montantHt = null;
        this.montantTtc = null;
        this.produit = new ProduitDto() ;
        this.achat = new AchatDto() ;
        this.depot = new DepotDto() ;

        }

}
