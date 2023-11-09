import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class TauxTvaDto extends BaseDto{

    public libelle: string;

    public montant: null | number;

    public code: string;

    

    constructor() {
        super();

        this.libelle = '';
        this.montant = null;
        this.code = '';

        }

}
