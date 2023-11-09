import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {FournisseurDto} from '../commun/Fournisseur.model';

export class ChequeEffetDto extends BaseDto{

    public numeroChequeEffet: string;

   public dateEmission: Date;

    public montant: null | number;

    public beneficiaire: FournisseurDto ;
    

    constructor() {
        super();

        this.numeroChequeEffet = '';
        this.dateEmission = null;
        this.montant = null;
        this.beneficiaire = new FournisseurDto() ;

        }

}
