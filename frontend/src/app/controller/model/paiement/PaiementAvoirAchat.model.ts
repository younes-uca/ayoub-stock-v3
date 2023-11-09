import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ModePaiementDto} from '../commun/ModePaiement.model';
import {AchatDto} from '../stock/Achat.model';
import {AvoirAchatDto} from '../stock/AvoirAchat.model';

export class PaiementAvoirAchatDto extends BaseDto{

    public reference: string;

   public datePaiement: Date;

    public montant: null | number;

    public description: string;

    public achat: AchatDto ;
    public modePaiement: ModePaiementDto ;
    public avoirAchat: AvoirAchatDto ;
    

    constructor() {
        super();

        this.reference = '';
        this.datePaiement = null;
        this.montant = null;
        this.description = '';
        this.achat = new AchatDto() ;
        this.modePaiement = new ModePaiementDto() ;
        this.avoirAchat = new AvoirAchatDto() ;

        }

}
