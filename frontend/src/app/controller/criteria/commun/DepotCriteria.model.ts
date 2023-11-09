import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class DepotCriteria  extends BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
    public code: string;
    public codeLike: string;
    public adresse: string;
    public adresseLike: string;

}
