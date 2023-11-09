import {Component, OnInit} from '@angular/core';
import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemCriteria} from 'src/app/controller/criteria/stock/AvoirAchatItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';


@Component({
  selector: 'app-avoir-achat-item-list-admin',
  templateUrl: './avoir-achat-item-list-admin.component.html'
})
export class AvoirAchatItemListAdminComponent extends AbstractListController<AvoirAchatItemDto, AvoirAchatItemCriteria, AvoirAchatItemAdminService>  implements OnInit {

    fileName = 'AvoirAchatItem';

    produits: Array<ProduitDto>;
    depots: Array<DepotDto>;
    avoirAchats: Array<AvoirAchatDto>;


    constructor( private avoirAchatItemService: AvoirAchatItemAdminService  , private depotService: DepotAdminService, private produitService: ProduitAdminService, private avoirAchatService: AvoirAchatAdminService) {
        super(avoirAchatItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadDepot();
        this.loadAvoirAchat();
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.reference', header: 'Produit'},
            {field: 'montantAvoir', header: 'Montant avoir'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'depot?.libelle', header: 'Depot'},
            {field: 'avoirAchat?.id', header: 'Avoir achat'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }
    public async loadAvoirAchat(){
       this.avoirAchatService.findAll().subscribe(avoirAchats => this.avoirAchats = avoirAchats, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.reference ,
                 'Montant avoir': e.montantAvoir ,
                 'Quantite': e.quantite ,
                'Depot': e.depot?.libelle ,
                'Avoir achat': e.avoirAchat?.id ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.reference ? this.criteria.produit?.reference : environment.emptyForExport ,
            'Montant avoir Min': this.criteria.montantAvoirMin ? this.criteria.montantAvoirMin : environment.emptyForExport ,
            'Montant avoir Max': this.criteria.montantAvoirMax ? this.criteria.montantAvoirMax : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
        //'Avoir achat': this.criteria.avoirAchat?.id ? this.criteria.avoirAchat?.id : environment.emptyForExport ,
        }];
      }
}
