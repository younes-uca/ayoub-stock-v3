import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ModePaiementDto} from '../commun/ModePaiement.model';
import {VenteDto} from '../stock/Vente.model';
import {AvoirVenteDto} from '../stock/AvoirVente.model';

export class PaiementAvoirVenteDto extends BaseDto{

    public reference: string;

   public datePaiement: Date;

    public montant: null | number;

    public description: string;

    public vente: VenteDto ;
    public modePaiement: ModePaiementDto ;
    public avoirVente: AvoirVenteDto ;
    

    constructor() {
        super();

        this.reference = '';
        this.datePaiement = null;
        this.montant = null;
        this.description = '';
        this.vente = new VenteDto() ;
        this.modePaiement = new ModePaiementDto() ;
        this.avoirVente = new AvoirVenteDto() ;

        }

}
