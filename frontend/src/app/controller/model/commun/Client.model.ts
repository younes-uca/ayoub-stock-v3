import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ClientDto extends BaseDto{

    public cin: string;

    public nom: string;

    public prenom: string;

    public telephone: string;

    public adresse: string;

    public description: string;

    public creance: null | number;

    

    constructor() {
        super();

        this.cin = '';
        this.nom = '';
        this.prenom = '';
        this.telephone = '';
        this.adresse = '';
        this.description = '';
        this.creance = null;

        }

}
