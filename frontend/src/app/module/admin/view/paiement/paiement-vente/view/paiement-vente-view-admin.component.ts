import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaiementVenteAdminService} from 'src/app/controller/service/admin/paiement/PaiementVenteAdmin.service';
import {PaiementVenteDto} from 'src/app/controller/model/paiement/PaiementVente.model';
import {PaiementVenteCriteria} from 'src/app/controller/criteria/paiement/PaiementVenteCriteria.model';

import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
@Component({
  selector: 'app-paiement-vente-view-admin',
  templateUrl: './paiement-vente-view-admin.component.html'
})
export class PaiementVenteViewAdminComponent extends AbstractViewController<PaiementVenteDto, PaiementVenteCriteria, PaiementVenteAdminService> implements OnInit {


    constructor(private paiementVenteService: PaiementVenteAdminService, private modePaiementService: ModePaiementAdminService, private venteService: VenteAdminService){
        super(paiementVenteService);
    }

    ngOnInit(): void {
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
