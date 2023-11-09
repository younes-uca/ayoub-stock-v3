import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EtatAchatCriteria} from '../commun/EtatAchatCriteria.model';
import {AchatItemCriteria} from './AchatItemCriteria.model';
import {EntrepriseSocieteCriteria} from '../commun/EntrepriseSocieteCriteria.model';
import {AvoirAchatCriteria} from './AvoirAchatCriteria.model';
import {FournisseurCriteria} from '../commun/FournisseurCriteria.model';

export class AchatCriteria  extends BaseCriteria  {

    public id: number;
    public dateFacture: Date;
    public dateFactureFrom: Date;
    public dateFactureTo: Date;
     public montantHt: number;
     public montantHtMin: number;
     public montantHtMax: number;
     public montantTva: number;
     public montantTvaMin: number;
     public montantTvaMax: number;
     public montantTtc: number;
     public montantTtcMin: number;
     public montantTtcMax: number;
    public description: string;
    public descriptionLike: string;
  public entrepriseSociete: EntrepriseSocieteCriteria ;
  public entrepriseSocietes: Array<EntrepriseSocieteCriteria> ;
  public fournisseur: FournisseurCriteria ;
  public fournisseurs: Array<FournisseurCriteria> ;
  public etatAchat: EtatAchatCriteria ;
  public etatAchats: Array<EtatAchatCriteria> ;
      public achatItems: Array<AchatItemCriteria>;
      public avoirs: Array<AvoirAchatCriteria>;

}
