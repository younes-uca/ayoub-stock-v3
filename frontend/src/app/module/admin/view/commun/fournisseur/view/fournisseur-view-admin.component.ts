import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurCriteria} from 'src/app/controller/criteria/commun/FournisseurCriteria.model';

import {VilleDto} from 'src/app/controller/model/commun/Ville.model';
import {VilleAdminService} from 'src/app/controller/service/admin/commun/VilleAdmin.service';
@Component({
  selector: 'app-fournisseur-view-admin',
  templateUrl: './fournisseur-view-admin.component.html'
})
export class FournisseurViewAdminComponent extends AbstractViewController<FournisseurDto, FournisseurCriteria, FournisseurAdminService> implements OnInit {


    constructor(private fournisseurService: FournisseurAdminService, private villeService: VilleAdminService){
        super(fournisseurService);
    }

    ngOnInit(): void {
    }


    get ville(): VilleDto {
       return this.villeService.item;
    }
    set ville(value: VilleDto) {
        this.villeService.item = value;
    }
    get villes(): Array<VilleDto> {
       return this.villeService.items;
    }
    set villes(value: Array<VilleDto>) {
        this.villeService.items = value;
    }


}
