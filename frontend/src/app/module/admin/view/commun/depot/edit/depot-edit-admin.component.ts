import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotCriteria} from 'src/app/controller/criteria/commun/DepotCriteria.model';



@Component({
  selector: 'app-depot-edit-admin',
  templateUrl: './depot-edit-admin.component.html'
})
export class DepotEditAdminComponent extends AbstractEditController<DepotDto, DepotCriteria, DepotAdminService>   implements OnInit {


    private _validDepotLibelle = true;
    private _validDepotCode = true;




    constructor( private depotService: DepotAdminService ) {
        super(depotService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validDepotLibelle = value;
        this.validDepotCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateDepotLibelle();
        this.validateDepotCode();
    }
    public validateDepotLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validDepotLibelle = false;
        } else {
            this.validDepotLibelle = true;
        }
    }
    public validateDepotCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validDepotCode = false;
        } else {
            this.validDepotCode = true;
        }
    }






    get validDepotLibelle(): boolean {
        return this._validDepotLibelle;
    }
    set validDepotLibelle(value: boolean) {
        this._validDepotLibelle = value;
    }
    get validDepotCode(): boolean {
        return this._validDepotCode;
    }
    set validDepotCode(value: boolean) {
        this._validDepotCode = value;
    }

}
