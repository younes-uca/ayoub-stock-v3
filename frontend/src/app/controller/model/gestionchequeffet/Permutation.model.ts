import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {PermutationItemDto} from './PermutationItem.model';

export class PermutationDto extends BaseDto{

   public datePermutation: Date;

    public description: string;

     public permutationItems: Array<PermutationItemDto>;
    

    constructor() {
        super();

        this.datePermutation = null;
        this.description = '';
        this.permutationItems = new Array<PermutationItemDto>();

        }

}
