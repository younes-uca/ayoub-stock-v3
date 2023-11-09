import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class ClientCriteria  extends BaseCriteria  {

    public id: number;
    public cin: string;
    public cinLike: string;
    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;
    public telephone: string;
    public telephoneLike: string;
    public adresse: string;
    public adresseLike: string;
    public description: string;
    public descriptionLike: string;
     public creance: number;
     public creanceMin: number;
     public creanceMax: number;

}
