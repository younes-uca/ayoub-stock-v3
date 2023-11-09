import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementCriteria} from 'src/app/controller/criteria/commun/ModePaiementCriteria.model';

@Component({
  selector: 'app-mode-paiement-view-admin',
  templateUrl: './mode-paiement-view-admin.component.html'
})
export class ModePaiementViewAdminComponent extends AbstractViewController<ModePaiementDto, ModePaiementCriteria, ModePaiementAdminService> implements OnInit {


    constructor(private modePaiementService: ModePaiementAdminService){
        super(modePaiementService);
    }

    ngOnInit(): void {
    }




}
