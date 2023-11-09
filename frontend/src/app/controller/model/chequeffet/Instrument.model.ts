import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ChequeEffetDto} from '../gestionchequeffet/ChequeEffet.model';
import {TypeInstrumentDto} from '../gestionchequeffet/TypeInstrument.model';

export class InstrumentDto extends BaseDto{

   public dateEmission: Date;

    public montant: null | number;

    public typeInstrument: TypeInstrumentDto ;
    public chequeEffet: ChequeEffetDto ;
    

    constructor() {
        super();

        this.dateEmission = null;
        this.montant = null;
        this.typeInstrument = new TypeInstrumentDto() ;
        this.chequeEffet = new ChequeEffetDto() ;

        }

}
