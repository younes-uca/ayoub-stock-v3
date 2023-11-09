import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProduitDto} from './Produit.model';
import {CommandeDto} from './Commande.model';

export class CommandeItemDto extends BaseDto{

    public quantite: null | number;

    public description: string;

    public produit: ProduitDto ;
    public commande: CommandeDto ;
    

    constructor() {
        super();

        this.quantite = null;
        this.description = '';
        this.produit = new ProduitDto() ;
        this.commande = new CommandeDto() ;

        }

}
