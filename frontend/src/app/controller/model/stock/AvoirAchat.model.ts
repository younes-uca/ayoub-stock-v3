import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';
import {AvoirAchatItemDto} from './AvoirAchatItem.model';
import {AchatDto} from './Achat.model';

export class AvoirAchatDto extends BaseDto{

   public dateAvoir: Date;

    public montant: null | number;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public achat: AchatDto ;
     public avoirAchatItems: Array<AvoirAchatItemDto>;
    

    constructor() {
        super();

        this.dateAvoir = null;
        this.montant = null;
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.achat = new AchatDto() ;
        this.avoirAchatItems = new Array<AvoirAchatItemDto>();

        }

}
