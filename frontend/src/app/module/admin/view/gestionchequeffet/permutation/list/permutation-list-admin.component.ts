import {Component, OnInit} from '@angular/core';
import {PermutationAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationAdmin.service';
import {PermutationDto} from 'src/app/controller/model/gestionchequeffet/Permutation.model';
import {PermutationCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {PermutationItemDto} from 'src/app/controller/model/gestionchequeffet/PermutationItem.model';
import {PermutationItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationItemAdmin.service';


@Component({
  selector: 'app-permutation-list-admin',
  templateUrl: './permutation-list-admin.component.html'
})
export class PermutationListAdminComponent extends AbstractListController<PermutationDto, PermutationCriteria, PermutationAdminService>  implements OnInit {

    fileName = 'Permutation';



    constructor( private permutationService: PermutationAdminService  , private depotService: DepotAdminService, private produitService: ProduitAdminService, private permutationItemService: PermutationItemAdminService) {
        super(permutationService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
    }


    public initCol() {
        this.cols = [
            {field: 'datePermutation', header: 'Date permutation'},
        ];
    }



	public initDuplicate(res: PermutationDto) {
        if (res.permutationItems != null) {
             res.permutationItems.forEach(d => { d.permutation = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Date permutation': this.datePipe.transform(e.datePermutation , 'dd/MM/yyyy hh:mm'),
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
            'Date permutation Min': this.criteria.datePermutationFrom ? this.datePipe.transform(this.criteria.datePermutationFrom , this.dateFormat) : environment.emptyForExport ,
            'Date permutation Max': this.criteria.datePermutationTo ? this.datePipe.transform(this.criteria.datePermutationTo , this.dateFormat) : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
