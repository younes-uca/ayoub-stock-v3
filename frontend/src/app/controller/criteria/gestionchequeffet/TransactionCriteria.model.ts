import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {TypeTransactionCriteria} from './TypeTransactionCriteria.model';
import {CompteCriteria} from './CompteCriteria.model';
import {InstrumentCriteria} from '../chequeffet/InstrumentCriteria.model';

export class TransactionCriteria  extends BaseCriteria  {

    public id: number;
    public dateTransaction: Date;
    public dateTransactionFrom: Date;
    public dateTransactionTo: Date;
    public dateEncaissement: Date;
    public dateEncaissementFrom: Date;
    public dateEncaissementTo: Date;
    public pathCheque: string;
    public pathChequeLike: string;
    public description: string;
    public descriptionLike: string;
  public typeTransaction: TypeTransactionCriteria ;
  public typeTransactions: Array<TypeTransactionCriteria> ;
  public instrument: InstrumentCriteria ;
  public instruments: Array<InstrumentCriteria> ;
  public compte: CompteCriteria ;
  public comptes: Array<CompteCriteria> ;

}
