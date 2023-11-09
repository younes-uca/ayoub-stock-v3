import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DepotDto} from '../commun/Depot.model';
import {ProduitDto} from './Produit.model';
import {AvoirAchatDto} from './AvoirAchat.model';

export class AvoirAchatItemDto extends BaseDto{

    public montantAvoir: null | number;

    public quantite: null | number;

    public produit: ProduitDto ;
    public depot: DepotDto ;
    public avoirAchat: AvoirAchatDto ;
    

    constructor() {
        super();

        this.montantAvoir = null;
        this.quantite = null;
        this.produit = new ProduitDto() ;
        this.depot = new DepotDto() ;
        this.avoirAchat = new AvoirAchatDto() ;

        }

}
