import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {EtatCommandeCriteria} from '../commun/EtatCommandeCriteria.model';
import {EntrepriseSocieteCriteria} from '../commun/EntrepriseSocieteCriteria.model';
import {CommandeItemCriteria} from './CommandeItemCriteria.model';
import {FournisseurCriteria} from '../commun/FournisseurCriteria.model';

export class CommandeCriteria  extends BaseCriteria  {

    public id: number;
    public description: string;
    public descriptionLike: string;
  public entrepriseSociete: EntrepriseSocieteCriteria ;
  public entrepriseSocietes: Array<EntrepriseSocieteCriteria> ;
  public fournisseur: FournisseurCriteria ;
  public fournisseurs: Array<FournisseurCriteria> ;
  public etatCommande: EtatCommandeCriteria ;
  public etatCommandes: Array<EtatCommandeCriteria> ;
      public commandeItems: Array<CommandeItemCriteria>;

}
