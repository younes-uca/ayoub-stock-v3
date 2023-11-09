import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CollaborateurDto extends BaseDto{

    public nom: string;

    public prenom: string;

    

    constructor() {
        super();

        this.nom = '';
        this.prenom = '';

        }

}
