import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DepotDto extends BaseDto{

    public libelle: string;

    public code: string;

    public adresse: string;

    

    constructor() {
        super();

        this.libelle = '';
        this.code = '';
        this.adresse = '';

        }

}
