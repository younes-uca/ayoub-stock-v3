import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaiementAvoirAchatAdminService} from 'src/app/controller/service/admin/paiement/PaiementAvoirAchatAdmin.service';
import {PaiementAvoirAchatDto} from 'src/app/controller/model/paiement/PaiementAvoirAchat.model';
import {PaiementAvoirAchatCriteria} from 'src/app/controller/criteria/paiement/PaiementAvoirAchatCriteria.model';

import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
@Component({
  selector: 'app-paiement-avoir-achat-view-admin',
  templateUrl: './paiement-avoir-achat-view-admin.component.html'
})
export class PaiementAvoirAchatViewAdminComponent extends AbstractViewController<PaiementAvoirAchatDto, PaiementAvoirAchatCriteria, PaiementAvoirAchatAdminService> implements OnInit {


    constructor(private paiementAvoirAchatService: PaiementAvoirAchatAdminService, private modePaiementService: ModePaiementAdminService, private achatService: AchatAdminService, private avoirAchatService: AvoirAchatAdminService){
        super(paiementAvoirAchatService);
    }

    ngOnInit(): void {
    }


    get avoirAchat(): AvoirAchatDto {
       return this.avoirAchatService.item;
    }
    set avoirAchat(value: AvoirAchatDto) {
        this.avoirAchatService.item = value;
    }
    get avoirAchats(): Array<AvoirAchatDto> {
       return this.avoirAchatService.items;
    }
    set avoirAchats(value: Array<AvoirAchatDto>) {
        this.avoirAchatService.items = value;
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
