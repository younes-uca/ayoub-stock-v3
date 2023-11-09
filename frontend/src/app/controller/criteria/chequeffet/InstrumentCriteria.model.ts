import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ChequeEffetCriteria} from '../gestionchequeffet/ChequeEffetCriteria.model';
import {TypeInstrumentCriteria} from '../gestionchequeffet/TypeInstrumentCriteria.model';

export class InstrumentCriteria  extends BaseCriteria  {

    public id: number;
    public dateEmission: Date;
    public dateEmissionFrom: Date;
    public dateEmissionTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
  public typeInstrument: TypeInstrumentCriteria ;
  public typeInstruments: Array<TypeInstrumentCriteria> ;
  public chequeEffet: ChequeEffetCriteria ;
  public chequeEffets: Array<ChequeEffetCriteria> ;

}
