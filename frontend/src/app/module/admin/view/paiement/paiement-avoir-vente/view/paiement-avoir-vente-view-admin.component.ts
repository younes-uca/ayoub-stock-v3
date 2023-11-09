import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaiementAvoirVenteAdminService} from 'src/app/controller/service/admin/paiement/PaiementAvoirVenteAdmin.service';
import {PaiementAvoirVenteDto} from 'src/app/controller/model/paiement/PaiementAvoirVente.model';
import {PaiementAvoirVenteCriteria} from 'src/app/controller/criteria/paiement/PaiementAvoirVenteCriteria.model';

import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
@Component({
  selector: 'app-paiement-avoir-vente-view-admin',
  templateUrl: './paiement-avoir-vente-view-admin.component.html'
})
export class PaiementAvoirVenteViewAdminComponent extends AbstractViewController<PaiementAvoirVenteDto, PaiementAvoirVenteCriteria, PaiementAvoirVenteAdminService> implements OnInit {


    constructor(private paiementAvoirVenteService: PaiementAvoirVenteAdminService, private modePaiementService: ModePaiementAdminService, private venteService: VenteAdminService, private avoirVenteService: AvoirVenteAdminService){
        super(paiementAvoirVenteService);
    }

    ngOnInit(): void {
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
    get vente(): VenteDto {
       return this.venteService.item;
    }
    set vente(value: VenteDto) {
        this.venteService.item = value;
    }
    get ventes(): Array<VenteDto> {
       return this.venteService.items;
    }
    set ventes(value: Array<VenteDto>) {
        this.venteService.items = value;
    }
    get modePaiement(): ModePaiementDto {
       return this.modePaiementService.item;
    }
    set modePaiement(value: ModePaiementDto) {
        this.modePaiementService.item = value;
    }
    get modePaiements(): Array<ModePaiementDto> {
       return this.modePaiementService.items;
    }
    set modePaiements(value: Array<ModePaiementDto>) {
        this.modePaiementService.items = value;
    }


}
