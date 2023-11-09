import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {CommandeCriteria} from './CommandeCriteria.model';

export class CommandeItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
    public description: string;
    public descriptionLike: string;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public commande: CommandeCriteria ;
  public commandes: Array<CommandeCriteria> ;

}
