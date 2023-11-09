import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {VilleDto} from './Ville.model';

export class FournisseurDto extends BaseDto{

    public nom: string;

    public ice: string;

    public telephone: string;

    public infoBancaire: string;

    public adresse: string;

    public creance: null | number;

    public description: string;

    public ville: VilleDto ;
    

    constructor() {
        super();

        this.nom = '';
        this.ice = '';
        this.telephone = '';
        this.infoBancaire = '';
        this.adresse = '';
        this.creance = null;
        this.description = '';
        this.ville = new VilleDto() ;

        }

}
