import {Component, OnInit} from '@angular/core';
import {VenteItemAdminService} from 'src/app/controller/service/admin/stock/VenteItemAdmin.service';
import {VenteItemDto} from 'src/app/controller/model/stock/VenteItem.model';
import {VenteItemCriteria} from 'src/app/controller/criteria/stock/VenteItemCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {TauxTvaDto} from 'src/app/controller/model/stock/TauxTva.model';
import {TauxTvaAdminService} from 'src/app/controller/service/admin/stock/TauxTvaAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';


@Component({
  selector: 'app-vente-item-list-admin',
  templateUrl: './vente-item-list-admin.component.html'
})
export class VenteItemListAdminComponent extends AbstractListController<VenteItemDto, VenteItemCriteria, VenteItemAdminService>  implements OnInit {

    fileName = 'VenteItem';

    produits: Array<ProduitDto>;
    tauxTvas: Array<TauxTvaDto>;
    ventes: Array<VenteDto>;
    depots: Array<DepotDto>;


    constructor( private venteItemService: VenteItemAdminService  , private depotService: DepotAdminService, private tauxTvaService: TauxTvaAdminService, private produitService: ProduitAdminService, private venteService: VenteAdminService) {
        super(venteItemService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadProduit();
        this.loadTauxTva();
        this.loadVente();
        this.loadDepot();
    }


    public initCol() {
        this.cols = [
            {field: 'barCode', header: 'Bar code'},
            {field: 'produit?.reference', header: 'Produit'},
            {field: 'quantite', header: 'Quantite'},
            {field: 'quantiteAvoir', header: 'Quantite avoir'},
            {field: 'quantiteVendue', header: 'Quantite vendue'},
            {field: 'remise', header: 'Remise'},
            {field: 'prixUnitaireTtc', header: 'Prix unitaire ttc'},
            {field: 'tauxTva?.libelle', header: 'Taux tva'},
            {field: 'prixUnitaireHt', header: 'Prix unitaire ht'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTtc', header: 'Montant ttc'},
            {field: 'vente?.id', header: 'Vente'},
            {field: 'depot?.libelle', header: 'Depot'},
        ];
    }


    public async loadProduit(){
       this.produitService.findAllOptimized().subscribe(produits => this.produits = produits, error => console.log(error))
    }
    public async loadTauxTva(){
       this.tauxTvaService.findAllOptimized().subscribe(tauxTvas => this.tauxTvas = tauxTvas, error => console.log(error))
    }
    public async loadVente(){
       this.venteService.findAll().subscribe(ventes => this.ventes = ventes, error => console.log(error))
    }
    public async loadDepot(){
       this.depotService.findAllOptimized().subscribe(depots => this.depots = depots, error => console.log(error))
    }



   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                 'Bar code': e.barCode ,
                'Produit': e.produit?.reference ,
                 'Quantite': e.quantite ,
                 'Quantite avoir': e.quantiteAvoir ,
                 'Quantite vendue': e.quantiteVendue ,
                 'Remise': e.remise ,
                 'Prix unitaire ttc': e.prixUnitaireTtc ,
                'Taux tva': e.tauxTva?.libelle ,
                 'Prix unitaire ht': e.prixUnitaireHt ,
                 'Montant ht': e.montantHt ,
                 'Montant ttc': e.montantTtc ,
                'Vente': e.vente?.id ,
                'Depot': e.depot?.libelle ,
            }
        });

        this.criteriaData = [{
            'Bar code': this.criteria.barCode ? this.criteria.barCode : environment.emptyForExport ,
        //'Produit': this.criteria.produit?.reference ? this.criteria.produit?.reference : environment.emptyForExport ,
            'Quantite Min': this.criteria.quantiteMin ? this.criteria.quantiteMin : environment.emptyForExport ,
            'Quantite Max': this.criteria.quantiteMax ? this.criteria.quantiteMax : environment.emptyForExport ,
            'Quantite avoir Min': this.criteria.quantiteAvoirMin ? this.criteria.quantiteAvoirMin : environment.emptyForExport ,
            'Quantite avoir Max': this.criteria.quantiteAvoirMax ? this.criteria.quantiteAvoirMax : environment.emptyForExport ,
            'Quantite vendue Min': this.criteria.quantiteVendueMin ? this.criteria.quantiteVendueMin : environment.emptyForExport ,
            'Quantite vendue Max': this.criteria.quantiteVendueMax ? this.criteria.quantiteVendueMax : environment.emptyForExport ,
            'Remise Min': this.criteria.remiseMin ? this.criteria.remiseMin : environment.emptyForExport ,
            'Remise Max': this.criteria.remiseMax ? this.criteria.remiseMax : environment.emptyForExport ,
            'Prix unitaire ttc Min': this.criteria.prixUnitaireTtcMin ? this.criteria.prixUnitaireTtcMin : environment.emptyForExport ,
            'Prix unitaire ttc Max': this.criteria.prixUnitaireTtcMax ? this.criteria.prixUnitaireTtcMax : environment.emptyForExport ,
        //'Taux tva': this.criteria.tauxTva?.libelle ? this.criteria.tauxTva?.libelle : environment.emptyForExport ,
            'Prix unitaire ht Min': this.criteria.prixUnitaireHtMin ? this.criteria.prixUnitaireHtMin : environment.emptyForExport ,
            'Prix unitaire ht Max': this.criteria.prixUnitaireHtMax ? this.criteria.prixUnitaireHtMax : environment.emptyForExport ,
            'Montant ht Min': this.criteria.montantHtMin ? this.criteria.montantHtMin : environment.emptyForExport ,
            'Montant ht Max': this.criteria.montantHtMax ? this.criteria.montantHtMax : environment.emptyForExport ,
            'Montant ttc Min': this.criteria.montantTtcMin ? this.criteria.montantTtcMin : environment.emptyForExport ,
            'Montant ttc Max': this.criteria.montantTtcMax ? this.criteria.montantTtcMax : environment.emptyForExport ,
        //'Vente': this.criteria.vente?.id ? this.criteria.vente?.id : environment.emptyForExport ,
        //'Depot': this.criteria.depot?.libelle ? this.criteria.depot?.libelle : environment.emptyForExport ,
        }];
      }
}
