import {Component, OnInit} from '@angular/core';
import {PermutationItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationItemAdmin.service';
import {PermutationItemDto} from 'src/app/controller/model/gestionchequeffet/PermutationItem.model';
import {PermutationItemCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {PermutationDto} from 'src/app/controller/model/gestionchequeffet/Permutation.model';
import {PermutationAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';


@Component({
  selector: 'app-permutation-item-list-admin',
  templateUrl: './permutation-item-list-admin.component.html'
})
export class PermutationItemListAdminComponent extends AbstractListController<PermutationItemDto, PermutationItemCriteria, PermutationItemAdminService>  implements OnInit {

    fileName = 'PermutationItem';

    produits: Array<ProduitDto>;
    depots: Array<DepotDto>;
    permutations: Array<PermutationDto>;


    constructor( private permutationItemService: PermutationItemAdminService  , private depotService: DepotAdminService, private permutationService: PermutationAdminService, private produitService: ProduitAdminService) {
        super(permutationItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadDepot();
        this.loadPermutation();
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.reference', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'depot?.libelle', header: 'Depot'},
            {field: 'permutation?.id', header: 'Permutation'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }
    public async loadPermutation(){
       this.permutationService.findAll().subscribe(permutations => this.permutations = permutations, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.reference ,
                 'Quantite': e.quantite ,
                'Depot': e.depot?.libelle ,
                'Permutation': e.permutation?.id ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.reference ? this.criteria.produit?.reference : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
        //'Permutation': this.criteria.permutation?.id ? this.criteria.permutation?.id : environment.emptyForExport ,
        }];
      }
}
