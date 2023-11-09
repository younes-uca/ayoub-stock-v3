import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EntreeProduitCriteria} from '../entree/EntreeProduitCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';

export class EntreeProduitItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
    public description: string;
    public descriptionLike: string;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public entreeProduit: EntreeProduitCriteria ;
  public entreeProduits: Array<EntreeProduitCriteria> ;

}
