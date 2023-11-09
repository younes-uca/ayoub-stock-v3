import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {EtatCommandeDto} from '../commun/EtatCommande.model';
import {EntrepriseSocieteDto} from '../commun/EntrepriseSociete.model';
import {CommandeItemDto} from './CommandeItem.model';
import {FournisseurDto} from '../commun/Fournisseur.model';

export class CommandeDto extends BaseDto{

    public description: string;

    public entrepriseSociete: EntrepriseSocieteDto ;
    public fournisseur: FournisseurDto ;
    public etatCommande: EtatCommandeDto ;
     public commandeItems: Array<CommandeItemDto>;
    

    constructor() {
        super();

        this.description = '';
        this.entrepriseSociete = new EntrepriseSocieteDto() ;
        this.fournisseur = new FournisseurDto() ;
        this.etatCommande = new EtatCommandeDto() ;
        this.commandeItems = new Array<CommandeItemDto>();

        }

}
