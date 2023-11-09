import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ChequeEffetAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ChequeEffetAdmin.service';
import {ChequeEffetDto} from 'src/app/controller/model/gestionchequeffet/ChequeEffet.model';
import {ChequeEffetCriteria} from 'src/app/controller/criteria/gestionchequeffet/ChequeEffetCriteria.model';

import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
@Component({
  selector: 'app-cheque-effet-view-admin',
  templateUrl: './cheque-effet-view-admin.component.html'
})
export class ChequeEffetViewAdminComponent extends AbstractViewController<ChequeEffetDto, ChequeEffetCriteria, ChequeEffetAdminService> implements OnInit {


    constructor(private chequeEffetService: ChequeEffetAdminService, private fournisseurService: FournisseurAdminService){
        super(chequeEffetService);
    }

    ngOnInit(): void {
    }


    get beneficiaire(): FournisseurDto {
       return this.fournisseurService.item;
    }
    set beneficiaire(value: FournisseurDto) {
        this.fournisseurService.item = value;
    }
    get beneficiaires(): Array<FournisseurDto> {
       return this.fournisseurService.items;
    }
    set beneficiaires(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
    }


}
