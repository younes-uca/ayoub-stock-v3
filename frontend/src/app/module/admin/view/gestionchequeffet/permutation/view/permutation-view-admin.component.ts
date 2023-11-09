import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PermutationAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationAdmin.service';
import {PermutationDto} from 'src/app/controller/model/gestionchequeffet/Permutation.model';
import {PermutationCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationCriteria.model';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {PermutationItemDto} from 'src/app/controller/model/gestionchequeffet/PermutationItem.model';
import {PermutationItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationItemAdmin.service';
@Component({
  selector: 'app-permutation-view-admin',
  templateUrl: './permutation-view-admin.component.html'
})
export class PermutationViewAdminComponent extends AbstractViewController<PermutationDto, PermutationCriteria, PermutationAdminService> implements OnInit {

    permutationItems = new PermutationItemDto();
    permutationItemss: Array<PermutationItemDto> = [];

    constructor(private permutationService: PermutationAdminService, private depotService: DepotAdminService, private produitService: ProduitAdminService, private permutationItemService: PermutationItemAdminService){
        super(permutationService);
    }

    ngOnInit(): void {
    }


    get produit(): ProduitDto {
       return this.produitService.item;
    }
    set produit(value: ProduitDto) {
        this.produitService.item = value;
    }
    get produits(): Array<ProduitDto> {
       return this.produitService.items;
    }
    set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
    }
    get depot(): DepotDto {
       return this.depotService.item;
    }
    set depot(value: DepotDto) {
        this.depotService.item = value;
    }
    get depots(): Array<DepotDto> {
       return this.depotService.items;
    }
    set depots(value: Array<DepotDto>) {
        this.depotService.items = value;
    }


}
