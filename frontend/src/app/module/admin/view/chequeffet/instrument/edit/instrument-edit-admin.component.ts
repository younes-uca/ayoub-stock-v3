import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {InstrumentAdminService} from 'src/app/controller/service/admin/chequeffet/InstrumentAdmin.service';
import {InstrumentDto} from 'src/app/controller/model/chequeffet/Instrument.model';
import {InstrumentCriteria} from 'src/app/controller/criteria/chequeffet/InstrumentCriteria.model';


import {ChequeEffetDto} from 'src/app/controller/model/gestionchequeffet/ChequeEffet.model';
import {ChequeEffetAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ChequeEffetAdmin.service';
import {TypeInstrumentDto} from 'src/app/controller/model/gestionchequeffet/TypeInstrument.model';
import {TypeInstrumentAdminService} from 'src/app/controller/service/admin/gestionchequeffet/TypeInstrumentAdmin.service';

@Component({
  selector: 'app-instrument-edit-admin',
  templateUrl: './instrument-edit-admin.component.html'
})
export class InstrumentEditAdminComponent extends AbstractEditController<InstrumentDto, InstrumentCriteria, InstrumentAdminService>   implements OnInit {



    private _validTypeInstrumentLibelle = true;
    private _validTypeInstrumentCode = true;
    private _validChequeEffetNumeroChequeEffet = true;
    private _validChequeEffetMontant = true;



    constructor( private instrumentService: InstrumentAdminService , private chequeEffetService: ChequeEffetAdminService, private typeInstrumentService: TypeInstrumentAdminService) {
        super(instrumentService);
    }

    ngOnInit(): void {
        this.typeInstrument = new TypeInstrumentDto();
        this.typeInstrumentService.findAll().subscribe((data) => this.typeInstruments = data);
        this.chequeEffet = new ChequeEffetDto();
        this.chequeEffetService.findAll().subscribe((data) => this.chequeEffets = data);
    }
    public prepareEdit() {
        this.item.dateEmission = this.instrumentService.format(this.item.dateEmission);
    }



    public setValidation(value: boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }




   get typeInstrument(): TypeInstrumentDto {
       return this.typeInstrumentService.item;
   }
  set typeInstrument(value: TypeInstrumentDto) {
        this.typeInstrumentService.item = value;
   }
   get typeInstruments(): Array<TypeInstrumentDto> {
        return this.typeInstrumentService.items;
   }
   set typeInstruments(value: Array<TypeInstrumentDto>) {
        this.typeInstrumentService.items = value;
   }
   get createTypeInstrumentDialog(): boolean {
       return this.typeInstrumentService.createDialog;
   }
  set createTypeInstrumentDialog(value: boolean) {
       this.typeInstrumentService.createDialog= value;
   }
   get chequeEffet(): ChequeEffetDto {
       return this.chequeEffetService.item;
   }
  set chequeEffet(value: ChequeEffetDto) {
        this.chequeEffetService.item = value;
   }
   get chequeEffets(): Array<ChequeEffetDto> {
        return this.chequeEffetService.items;
   }
   set chequeEffets(value: Array<ChequeEffetDto>) {
        this.chequeEffetService.items = value;
   }
   get createChequeEffetDialog(): boolean {
       return this.chequeEffetService.createDialog;
   }
  set createChequeEffetDialog(value: boolean) {
       this.chequeEffetService.createDialog= value;
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
    get validChequeEffetNumeroChequeEffet(): boolean {
        return this._validChequeEffetNumeroChequeEffet;
    }
    set validChequeEffetNumeroChequeEffet(value: boolean) {
        this._validChequeEffetNumeroChequeEffet = value;
    }
    get validChequeEffetMontant(): boolean {
        return this._validChequeEffetMontant;
    }
    set validChequeEffetMontant(value: boolean) {
        this._validChequeEffetMontant = value;
    }
}
