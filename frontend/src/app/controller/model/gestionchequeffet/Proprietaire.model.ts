import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ProprietaireDto extends BaseDto{

    public nom: string;

    public code: string;

    

    constructor() {
        super();

        this.nom = '';
        this.code = '';

        }

}
