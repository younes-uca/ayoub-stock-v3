import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {TypeTransactionAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeTransactionAdmin.service';
import {TypeTransactionDto} from 'src/app/controller/model/gestionchequeffet/TypeTransaction.model';
import {TypeTransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/TypeTransactionCriteria.model';



@Component({
  selector: 'app-type-transaction-edit-admin',
  templateUrl: './type-transaction-edit-admin.component.html'
})
export class TypeTransactionEditAdminComponent extends AbstractEditController<TypeTransactionDto, TypeTransactionCriteria, TypeTransactionAdminService>   implements OnInit {


    private _validTypeTransactionLibelle = true;
    private _validTypeTransactionCode = true;




    constructor( private typeTransactionService: TypeTransactionAdminService ) {
        super(typeTransactionService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validTypeTransactionLibelle = value;
        this.validTypeTransactionCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypeTransactionLibelle();
        this.validateTypeTransactionCode();
    }
    public validateTypeTransactionLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validTypeTransactionLibelle = false;
        } else {
            this.validTypeTransactionLibelle = true;
        }
    }
    public validateTypeTransactionCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validTypeTransactionCode = false;
        } else {
            this.validTypeTransactionCode = true;
        }
    }






    get validTypeTransactionLibelle(): boolean {
        return this._validTypeTransactionLibelle;
    }
    set validTypeTransactionLibelle(value: boolean) {
        this._validTypeTransactionLibelle = value;
    }
    get validTypeTransactionCode(): boolean {
        return this._validTypeTransactionCode;
    }
    set validTypeTransactionCode(value: boolean) {
        this._validTypeTransactionCode = value;
    }

}
