import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {DepotCriteria} from '../commun/DepotCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {AvoirVenteCriteria} from './AvoirVenteCriteria.model';

export class AvoirVenteItemCriteria  extends BaseCriteria  {

    public id: number;
     public montantAvoir: number;
     public montantAvoirMin: number;
     public montantAvoirMax: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public depot: DepotCriteria ;
  public depots: Array<DepotCriteria> ;
  public avoirVente: AvoirVenteCriteria ;
  public avoirVentes: Array<AvoirVenteCriteria> ;

}
