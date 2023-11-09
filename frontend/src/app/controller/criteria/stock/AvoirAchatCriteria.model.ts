import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EntrepriseSocieteCriteria} from '../commun/EntrepriseSocieteCriteria.model';
import {AvoirAchatItemCriteria} from './AvoirAchatItemCriteria.model';
import {AchatCriteria} from './AchatCriteria.model';

export class AvoirAchatCriteria  extends BaseCriteria  {

    public id: number;
    public dateAvoir: Date;
    public dateAvoirFrom: Date;
    public dateAvoirTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
  public entrepriseSociete: EntrepriseSocieteCriteria ;
  public entrepriseSocietes: Array<EntrepriseSocieteCriteria> ;
  public achat: AchatCriteria ;
  public achats: Array<AchatCriteria> ;
      public avoirAchatItems: Array<AvoirAchatItemCriteria>;

}
