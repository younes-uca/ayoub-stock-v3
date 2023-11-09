import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {VilleAdminService} from 'src/app/controller/service/admin/commun/VilleAdmin.service';
import {VilleDto} from 'src/app/controller/model/commun/Ville.model';
import {VilleCriteria} from 'src/app/controller/criteria/commun/VilleCriteria.model';



@Component({
  selector: 'app-ville-edit-admin',
  templateUrl: './ville-edit-admin.component.html'
})
export class VilleEditAdminComponent extends AbstractEditController<VilleDto, VilleCriteria, VilleAdminService>   implements OnInit {


    private _validVilleLibelle = true;




    constructor( private villeService: VilleAdminService ) {
        super(villeService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validVilleLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateVilleLibelle();
    }
    public validateVilleLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validVilleLibelle = false;
        } else {
            this.validVilleLibelle = true;
        }
    }






    get validVilleLibelle(): boolean {
        return this._validVilleLibelle;
    }
    set validVilleLibelle(value: boolean) {
        this._validVilleLibelle = value;
    }

}
