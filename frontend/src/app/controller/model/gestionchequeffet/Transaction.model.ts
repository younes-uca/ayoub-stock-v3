import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TypeTransactionDto} from './TypeTransaction.model';
import {CompteDto} from './Compte.model';
import {InstrumentDto} from '../chequeffet/Instrument.model';

export class TransactionDto extends BaseDto{

   public dateTransaction: Date;

   public dateEncaissement: Date;

    public pathCheque: string;

    public description: string;

    public typeTransaction: TypeTransactionDto ;
    public instrument: InstrumentDto ;
    public compte: CompteDto ;
    

    constructor() {
        super();

        this.dateTransaction = null;
        this.dateEncaissement = null;
        this.pathCheque = '';
        this.description = '';
        this.typeTransaction = new TypeTransactionDto() ;
        this.instrument = new InstrumentDto() ;
        this.compte = new CompteDto() ;

        }

}
