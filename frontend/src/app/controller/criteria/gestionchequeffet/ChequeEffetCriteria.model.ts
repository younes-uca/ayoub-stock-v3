import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {FournisseurCriteria} from '../commun/FournisseurCriteria.model';

export class ChequeEffetCriteria  extends BaseCriteria  {

    public id: number;
    public numeroChequeEffet: string;
    public numeroChequeEffetLike: string;
    public dateEmission: Date;
    public dateEmissionFrom: Date;
    public dateEmissionTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
  public beneficiaire: FournisseurCriteria ;
  public beneficiaires: Array<FournisseurCriteria> ;

}
