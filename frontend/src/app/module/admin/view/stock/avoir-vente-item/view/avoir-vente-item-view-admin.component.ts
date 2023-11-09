import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemCriteria} from 'src/app/controller/criteria/stock/AvoirVenteItemCriteria.model';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
@Component({
  selector: 'app-avoir-vente-item-view-admin',
  templateUrl: './avoir-vente-item-view-admin.component.html'
})
export class AvoirVenteItemViewAdminComponent extends AbstractViewController<AvoirVenteItemDto, AvoirVenteItemCriteria, AvoirVenteItemAdminService> implements OnInit {


    constructor(private avoirVenteItemService: AvoirVenteItemAdminService, private depotService: DepotAdminService, private produitService: ProduitAdminService, private avoirVenteService: AvoirVenteAdminService){
        super(avoirVenteItemService);
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
    get avoirVente(): AvoirVenteDto {
       return this.avoirVenteService.item;
    }
    set avoirVente(value: AvoirVenteDto) {
        this.avoirVenteService.item = value;
    }
    get avoirVentes(): Array<AvoirVenteDto> {
       return this.avoirVenteService.items;
    }
    set avoirVentes(value: Array<AvoirVenteDto>) {
        this.avoirVenteService.items = value;
    }


}
