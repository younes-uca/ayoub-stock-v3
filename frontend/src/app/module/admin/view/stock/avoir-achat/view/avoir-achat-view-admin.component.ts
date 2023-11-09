import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatCriteria} from 'src/app/controller/criteria/stock/AvoirAchatCriteria.model';

import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
@Component({
  selector: 'app-avoir-achat-view-admin',
  templateUrl: './avoir-achat-view-admin.component.html'
})
export class AvoirAchatViewAdminComponent extends AbstractViewController<AvoirAchatDto, AvoirAchatCriteria, AvoirAchatAdminService> implements OnInit {

    avoirAchatItems = new AvoirAchatItemDto();
    avoirAchatItemss: Array<AvoirAchatItemDto> = [];

    constructor(private avoirAchatService: AvoirAchatAdminService, private depotService: DepotAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private produitService: ProduitAdminService, private avoirAchatItemService: AvoirAchatItemAdminService, private achatService: AchatAdminService){
        super(avoirAchatService);
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
    get achat(): AchatDto {
       return this.achatService.item;
    }
    set achat(value: AchatDto) {
        this.achatService.item = value;
    }
    get achats(): Array<AchatDto> {
       return this.achatService.items;
    }
    set achats(value: Array<AchatDto>) {
        this.achatService.items = value;
    }
    get entrepriseSociete(): EntrepriseSocieteDto {
       return this.entrepriseSocieteService.item;
    }
    set entrepriseSociete(value: EntrepriseSocieteDto) {
        this.entrepriseSocieteService.item = value;
    }
    get entrepriseSocietes(): Array<EntrepriseSocieteDto> {
       return this.entrepriseSocieteService.items;
    }
    set entrepriseSocietes(value: Array<EntrepriseSocieteDto>) {
        this.entrepriseSocieteService.items = value;
    }


}
