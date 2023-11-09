import {Component, OnInit} from '@angular/core';
import {AchatItemAdminService} from 'src/app/controller/service/admin/stock/AchatItemAdmin.service';
import {AchatItemDto} from 'src/app/controller/model/stock/AchatItem.model';
import {AchatItemCriteria} from 'src/app/controller/criteria/stock/AchatItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';


@Component({
  selector: 'app-achat-item-list-admin',
  templateUrl: './achat-item-list-admin.component.html'
})
export class AchatItemListAdminComponent extends AbstractListController<AchatItemDto, AchatItemCriteria, AchatItemAdminService>  implements OnInit {

    fileName = 'AchatItem';

    produits: Array<ProduitDto>;
    achats: Array<AchatDto>;
    depots: Array<DepotDto>;


    constructor( private achatItemService: AchatItemAdminService  , private depotService: DepotAdminService, private produitService: ProduitAdminService, private achatService: AchatAdminService) {
        super(achatItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadAchat();
        this.loadDepot();
    }


    public initCol() {
        this.cols = [
            {field: 'barCode', header: 'Bar code'},
            {field: 'footerBarCode', header: 'Footer bar code'},
            {field: 'produit?.reference', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'quantiteAvoir', header: 'Quantite avoir'},
            {field: 'quantiteDisponible', header: 'Quantite disponible'},
            {field: 'remise', header: 'Remise'},
            {field: 'prixUnitaireTtc', header: 'Prix unitaire ttc'},
            {field: 'prixUnitaireHt', header: 'Prix unitaire ht'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTtc', header: 'Montant ttc'},
            {field: 'achat?.id', header: 'Achat'},
            {field: 'depot?.libelle', header: 'Depot'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadAchat(){
       this.achatService.findAll().subscribe(achats => this.achats = achats, error => console.log(error))
    }
    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Bar code': e.barCode ,
                 'Footer bar code': e.footerBarCode ,
                'Produit': e.produit?.reference ,
                 'Quantite': e.quantite ,
                 'Quantite avoir': e.quantiteAvoir ,
                 'Quantite disponible': e.quantiteDisponible ,
                 'Remise': e.remise ,
                 'Prix unitaire ttc': e.prixUnitaireTtc ,
                 'Prix unitaire ht': e.prixUnitaireHt ,
                 'Montant ht': e.montantHt ,
                 'Montant ttc': e.montantTtc ,
                'Achat': e.achat?.id ,
                'Depot': e.depot?.libelle ,
            }
        });

        this.criteriaData = [{
            'Bar code': this.criteria.barCode ? this.criteria.barCode : environment.emptyForExport ,
            'Footer bar code': this.criteria.footerBarCode ? this.criteria.footerBarCode : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.reference ? this.criteria.produit?.reference : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
            'Quantite avoir Min': this.criteria.quantiteAvoirMin ? this.criteria.quantiteAvoirMin : environment.emptyForExport ,
            'Quantite avoir Max': this.criteria.quantiteAvoirMax ? this.criteria.quantiteAvoirMax : environment.emptyForExport ,
            'Quantite disponible Min': this.criteria.quantiteDisponibleMin ? this.criteria.quantiteDisponibleMin : environment.emptyForExport ,
            'Quantite disponible Max': this.criteria.quantiteDisponibleMax ? this.criteria.quantiteDisponibleMax : environment.emptyForExport ,
            'Remise Min': this.criteria.remiseMin ? this.criteria.remiseMin : environment.emptyForExport ,
            'Remise Max': this.criteria.remiseMax ? this.criteria.remiseMax : environment.emptyForExport ,
            'Prix unitaire ttc Min': this.criteria.prixUnitaireTtcMin ? this.criteria.prixUnitaireTtcMin : environment.emptyForExport ,
            'Prix unitaire ttc Max': this.criteria.prixUnitaireTtcMax ? this.criteria.prixUnitaireTtcMax : environment.emptyForExport ,
            'Prix unitaire ht Min': this.criteria.prixUnitaireHtMin ? this.criteria.prixUnitaireHtMin : environment.emptyForExport ,
            'Prix unitaire ht Max': this.criteria.prixUnitaireHtMax ? this.criteria.prixUnitaireHtMax : environment.emptyForExport ,
            'Montant ht Min': this.criteria.montantHtMin ? this.criteria.montantHtMin : environment.emptyForExport ,
            'Montant ht Max': this.criteria.montantHtMax ? this.criteria.montantHtMax : environment.emptyForExport ,
            'Montant ttc Min': this.criteria.montantTtcMin ? this.criteria.montantTtcMin : environment.emptyForExport ,
            'Montant ttc Max': this.criteria.montantTtcMax ? this.criteria.montantTtcMax : environment.emptyForExport ,
        //'Achat': this.criteria.achat?.id ? this.criteria.achat?.id : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
        }];
      }
}
