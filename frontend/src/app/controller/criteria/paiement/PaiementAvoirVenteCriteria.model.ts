import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ModePaiementCriteria} from '../commun/ModePaiementCriteria.model';
import {VenteCriteria} from '../stock/VenteCriteria.model';
import {AvoirVenteCriteria} from '../stock/AvoirVenteCriteria.model';

export class PaiementAvoirVenteCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public datePaiement: Date;
    public datePaiementFrom: Date;
    public datePaiementTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
    public description: string;
    public descriptionLike: string;
  public vente: VenteCriteria ;
  public ventes: Array<VenteCriteria> ;
  public modePaiement: ModePaiementCriteria ;
  public modePaiements: Array<ModePaiementCriteria> ;
  public avoirVente: AvoirVenteCriteria ;
  public avoirVentes: Array<AvoirVenteCriteria> ;

}
