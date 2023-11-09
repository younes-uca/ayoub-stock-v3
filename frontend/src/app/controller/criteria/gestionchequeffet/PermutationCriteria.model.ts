import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {PermutationItemCriteria} from './PermutationItemCriteria.model';

export class PermutationCriteria  extends BaseCriteria  {

    public id: number;
    public datePermutation: Date;
    public datePermutationFrom: Date;
    public datePermutationTo: Date;
    public description: string;
    public descriptionLike: string;
      public permutationItems: Array<PermutationItemCriteria>;

}
