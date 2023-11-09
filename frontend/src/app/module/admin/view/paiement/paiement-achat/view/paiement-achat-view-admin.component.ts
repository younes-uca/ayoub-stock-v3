import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaiementAchatAdminService} from 'src/app/controller/service/admin/paiement/PaiementAchatAdmin.service';
import {PaiementAchatDto} from 'src/app/controller/model/paiement/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/paiement/PaiementAchatCriteria.model';

import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
@Component({
  selector: 'app-paiement-achat-view-admin',
  templateUrl: './paiement-achat-view-admin.component.html'
})
export class PaiementAchatViewAdminComponent extends AbstractViewController<PaiementAchatDto, PaiementAchatCriteria, PaiementAchatAdminService> implements OnInit {


    constructor(private paiementAchatService: PaiementAchatAdminService, private modePaiementService: ModePaiementAdminService, private achatService: AchatAdminService){
        super(paiementAchatService);
    }

    ngOnInit(): void {
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
