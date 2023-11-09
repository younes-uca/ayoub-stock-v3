import {Component, OnInit} from '@angular/core';
import {EntreeProduitItemAdminService} from 'src/app/controller/service/admin/stock/EntreeProduitItemAdmin.service';
import {EntreeProduitItemDto} from 'src/app/controller/model/stock/EntreeProduitItem.model';
import {EntreeProduitItemCriteria} from 'src/app/controller/criteria/stock/EntreeProduitItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {EntreeProduitDto} from 'src/app/controller/model/entree/EntreeProduit.model';
import {EntreeProduitAdminService} from 'src/app/controller/service/admin/entree/EntreeProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';


@Component({
  selector: 'app-entree-produit-item-list-admin',
  templateUrl: './entree-produit-item-list-admin.component.html'
})
export class EntreeProduitItemListAdminComponent extends AbstractListController<EntreeProduitItemDto, EntreeProduitItemCriteria, EntreeProduitItemAdminService>  implements OnInit {

    fileName = 'EntreeProduitItem';

    produits: Array<ProduitDto>;
    entreeProduits: Array<EntreeProduitDto>;


    constructor( private entreeProduitItemService: EntreeProduitItemAdminService  , private entreeProduitService: EntreeProduitAdminService, private produitService: ProduitAdminService) {
        super(entreeProduitItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadEntreeProduit();
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.reference', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'entreeProduit?.reference', header: 'Entree produit'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadEntreeProduit(){
       this.entreeProduitService.findAllOptimized().subscribe(entreeProduits => this.entreeProduits = entreeProduits, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.reference ,
                 'Quantite': e.quantite ,
                 'Description': e.description ,
                'Entree produit': e.entreeProduit?.reference ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.reference ? this.criteria.produit?.reference : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Entree produit': this.criteria.entreeProduit?.reference ? this.criteria.entreeProduit?.reference : environment.emptyForExport ,
        }];
      }
}
