import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DepotDto} from '../commun/Depot.model';
import {ProduitDto} from './Produit.model';
import {AvoirVenteDto} from './AvoirVente.model';

export class AvoirVenteItemDto extends BaseDto{

    public montantAvoir: null | number;

    public quantite: null | number;

    public produit: ProduitDto ;
    public depot: DepotDto ;
    public avoirVente: AvoirVenteDto ;
    

    constructor() {
        super();

        this.montantAvoir = null;
        this.quantite = null;
        this.produit = new ProduitDto() ;
        this.depot = new DepotDto() ;
        this.avoirVente = new AvoirVenteDto() ;

        }

}
