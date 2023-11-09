import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaiementAchatAdminService} from 'src/app/controller/service/admin/paiement/PaiementAchatAdmin.service';
import {PaiementAchatDto} from 'src/app/controller/model/paiement/PaiementAchat.model';
import {PaiementAchatCriteria} from 'src/app/controller/criteria/paiement/PaiementAchatCriteria.model';


import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';

@Component({
  selector: 'app-paiement-achat-edit-admin',
  templateUrl: './paiement-achat-edit-admin.component.html'
})
export class PaiementAchatEditAdminComponent extends AbstractEditController<PaiementAchatDto, PaiementAchatCriteria, PaiementAchatAdminService>   implements OnInit {


    private _validPaiementAchatReference = true;
    private _validPaiementAchatDatePaiement = true;
    private _validPaiementAchatMontant = true;
    private _validPaiementAchatModePaiement = true;

    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;
    private _validModePaiementLibelle = true;
    private _validModePaiementCode = true;



    constructor( private paiementAchatService: PaiementAchatAdminService , private modePaiementService: ModePaiementAdminService, private achatService: AchatAdminService) {
        super(paiementAchatService);
    }

    ngOnInit(): void {
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
        this.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
    }
    public prepareEdit() {
        this.item.datePaiement = this.paiementAchatService.format(this.item.datePaiement);
    }



    public setValidation(value: boolean){
        this.validPaiementAchatReference = value;
        this.validPaiementAchatDatePaiement = value;
        this.validPaiementAchatMontant = value;
        this.validPaiementAchatModePaiement = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaiementAchatReference();
        this.validatePaiementAchatDatePaiement();
        this.validatePaiementAchatMontant();
        this.validatePaiementAchatModePaiement();
    }
    public validatePaiementAchatReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validPaiementAchatReference = false;
        } else {
            this.validPaiementAchatReference = true;
        }
    }
    public validatePaiementAchatDatePaiement(){
        if (this.stringUtilService.isEmpty(this.item.datePaiement)) {
            this.errorMessages.push('Date paiement non valide');
            this.validPaiementAchatDatePaiement = false;
        } else {
            this.validPaiementAchatDatePaiement = true;
        }
    }
    public validatePaiementAchatMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validPaiementAchatMontant = false;
        } else {
            this.validPaiementAchatMontant = true;
        }
    }
    public validatePaiementAchatModePaiement(){
        if (this.stringUtilService.isEmpty(this.item.modePaiement)) {
            this.errorMessages.push('Mode paiement non valide');
            this.validPaiementAchatModePaiement = false;
        } else {
            this.validPaiementAchatModePaiement = true;
        }
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
   get createAchatDialog(): boolean {
       return this.achatService.createDialog;
   }
  set createAchatDialog(value: boolean) {
       this.achatService.createDialog= value;
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
   get createModePaiementDialog(): boolean {
       return this.modePaiementService.createDialog;
   }
  set createModePaiementDialog(value: boolean) {
       this.modePaiementService.createDialog= value;
   }


    get validPaiementAchatReference(): boolean {
        return this._validPaiementAchatReference;
    }
    set validPaiementAchatReference(value: boolean) {
        this._validPaiementAchatReference = value;
    }
    get validPaiementAchatDatePaiement(): boolean {
        return this._validPaiementAchatDatePaiement;
    }
    set validPaiementAchatDatePaiement(value: boolean) {
        this._validPaiementAchatDatePaiement = value;
    }
    get validPaiementAchatMontant(): boolean {
        return this._validPaiementAchatMontant;
    }
    set validPaiementAchatMontant(value: boolean) {
        this._validPaiementAchatMontant = value;
    }
    get validPaiementAchatModePaiement(): boolean {
        return this._validPaiementAchatModePaiement;
    }
    set validPaiementAchatModePaiement(value: boolean) {
        this._validPaiementAchatModePaiement = value;
    }

    get validAchatDateFacture(): boolean {
        return this._validAchatDateFacture;
    }
    set validAchatDateFacture(value: boolean) {
        this._validAchatDateFacture = value;
    }
    get validAchatFournisseur(): boolean {
        return this._validAchatFournisseur;
    }
    set validAchatFournisseur(value: boolean) {
        this._validAchatFournisseur = value;
    }
    get validModePaiementLibelle(): boolean {
        return this._validModePaiementLibelle;
    }
    set validModePaiementLibelle(value: boolean) {
        this._validModePaiementLibelle = value;
    }
    get validModePaiementCode(): boolean {
        return this._validModePaiementCode;
    }
    set validModePaiementCode(value: boolean) {
        this._validModePaiementCode = value;
    }
}
