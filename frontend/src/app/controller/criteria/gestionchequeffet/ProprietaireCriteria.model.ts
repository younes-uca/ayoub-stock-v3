import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class ProprietaireCriteria  extends BaseCriteria  {

    public id: number;
    public nom: string;
    public nomLike: string;
    public code: string;
    public codeLike: string;

}
