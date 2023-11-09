import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentCriteria} from 'src/app/controller/criteria/gestionchequeffet/TypeInstrumentCriteria.model';



@Component({
  selector: 'app-type-instrument-edit-admin',
  templateUrl: './type-instrument-edit-admin.component.html'
})
export class TypeInstrumentEditAdminComponent extends AbstractEditController<TypeInstrumentDto, TypeInstrumentCriteria, TypeInstrumentAdminService>   implements OnInit {


    private _validTypeInstrumentLibelle = true;
    private _validTypeInstrumentCode = true;




    constructor( private typeInstrumentService: TypeInstrumentAdminService ) {
        super(typeInstrumentService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validTypeInstrumentLibelle = value;
        this.validTypeInstrumentCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypeInstrumentLibelle();
        this.validateTypeInstrumentCode();
    }
    public validateTypeInstrumentLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validTypeInstrumentLibelle = false;
        } else {
            this.validTypeInstrumentLibelle = true;
        }
    }
    public validateTypeInstrumentCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validTypeInstrumentCode = false;
        } else {
            this.validTypeInstrumentCode = true;
        }
    }






    get validTypeInstrumentLibelle(): boolean {
        return this._validTypeInstrumentLibelle;
    }
    set validTypeInstrumentLibelle(value: boolean) {
        this._validTypeInstrumentLibelle = value;
    }
    get validTypeInstrumentCode(): boolean {
        return this._validTypeInstrumentCode;
    }
    set validTypeInstrumentCode(value: boolean) {
        this._validTypeInstrumentCode = value;
    }

}
