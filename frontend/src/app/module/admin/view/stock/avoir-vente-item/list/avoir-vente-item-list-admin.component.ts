import {Component, OnInit} from '@angular/core';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemCriteria} from 'src/app/controller/criteria/stock/AvoirVenteItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';


@Component({
  selector: 'app-avoir-vente-item-list-admin',
  templateUrl: './avoir-vente-item-list-admin.component.html'
})
export class AvoirVenteItemListAdminComponent extends AbstractListController<AvoirVenteItemDto, AvoirVenteItemCriteria, AvoirVenteItemAdminService>  implements OnInit {

    fileName = 'AvoirVenteItem';

    produits: Array<ProduitDto>;
    depots: Array<DepotDto>;
    avoirVentes: Array<AvoirVenteDto>;


    constructor( private avoirVenteItemService: AvoirVenteItemAdminService  , private depotService: DepotAdminService, private produitService: ProduitAdminService, private avoirVenteService: AvoirVenteAdminService) {
        super(avoirVenteItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadDepot();
        this.loadAvoirVente();
    }


    public initCol() {
        this.cols = [
            {field: 'produit?.reference', header: 'Produit'},
            {field: 'montantAvoir', header: 'Montant avoir'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'depot?.libelle', header: 'Depot'},
            {field: 'avoirVente?.id', header: 'Avoir vente'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }
    public async loadAvoirVente(){
       this.avoirVenteService.findAll().subscribe(avoirVentes => this.avoirVentes = avoirVentes, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Produit': e.produit?.reference ,
                 'Montant avoir': e.montantAvoir ,
                 'Quantite': e.quantite ,
                'Depot': e.depot?.libelle ,
                'Avoir vente': e.avoirVente?.id ,
            }
        });

        this.criteriaData = [{
        //'Produit': this.criteria.produit?.reference ? this.criteria.produit?.reference : environment.emptyForExport ,
            'Montant avoir Min': this.criteria.montantAvoirMin ? this.criteria.montantAvoirMin : environment.emptyForExport ,
            'Montant avoir Max': this.criteria.montantAvoirMax ? this.criteria.montantAvoirMax : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
        //'Avoir vente': this.criteria.avoirVente?.id ? this.criteria.avoirVente?.id : environment.emptyForExport ,
        }];
      }
}
