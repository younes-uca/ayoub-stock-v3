import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {DepotCriteria} from '../commun/DepotCriteria.model';
import {EntreeProduitItemCriteria} from '../stock/EntreeProduitItemCriteria.model';
import {FournisseurCriteria} from '../commun/FournisseurCriteria.model';

export class EntreeProduitCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateEntreeProduit: Date;
    public dateEntreeProduitFrom: Date;
    public dateEntreeProduitTo: Date;
    public description: string;
    public descriptionLike: string;
  public fournisseur: FournisseurCriteria ;
  public fournisseurs: Array<FournisseurCriteria> ;
  public depot: DepotCriteria ;
  public depots: Array<DepotCriteria> ;
      public entreeProduitItems: Array<EntreeProduitItemCriteria>;

}
