import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {DepotCriteria} from '../commun/DepotCriteria.model';
import {PermutationCriteria} from './PermutationCriteria.model';
import {ProduitCriteria} from '../stock/ProduitCriteria.model';

export class PermutationItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public depot: DepotCriteria ;
  public depots: Array<DepotCriteria> ;
  public permutation: PermutationCriteria ;
  public permutations: Array<PermutationCriteria> ;

}
