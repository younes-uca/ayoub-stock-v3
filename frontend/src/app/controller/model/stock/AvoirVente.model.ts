import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';
import {AvoirVenteItemDto} from './AvoirVenteItem.model';
import {VenteDto} from './Vente.model';

export class AvoirVenteDto extends BaseDto{

   public dateAvoir: Date;

    public montant: null | number;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public vente: VenteDto ;
     public avoirVenteItems: Array<AvoirVenteItemDto>;
    

    constructor() {
        super();

        this.dateAvoir = null;
        this.montant = null;
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.vente = new VenteDto() ;
        this.avoirVenteItems = new Array<AvoirVenteItemDto>();

        }

}
