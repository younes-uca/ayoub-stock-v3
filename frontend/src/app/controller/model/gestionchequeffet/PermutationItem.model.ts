import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DepotDto} from '../commun/Depot.model';
import {PermutationDto} from './Permutation.model';
import {ProduitDto} from '../stock/Produit.model';

export class PermutationItemDto extends BaseDto{

    public quantite: null | number;

    public produit: ProduitDto ;
    public depot: DepotDto ;
    public permutation: PermutationDto ;
    

    constructor() {
        super();

        this.quantite = null;
        this.produit = new ProduitDto() ;
        this.depot = new DepotDto() ;
        this.permutation = new PermutationDto() ;

        }

}
