import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaiementAvoirAchatAdminService} from 'src/app/controller/service/admin/paiement/PaiementAvoirAchatAdmin.service';
import {PaiementAvoirAchatDto} from 'src/app/controller/model/paiement/PaiementAvoirAchat.model';
import {PaiementAvoirAchatCriteria} from 'src/app/controller/criteria/paiement/PaiementAvoirAchatCriteria.model';


import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';

@Component({
  selector: 'app-paiement-avoir-achat-edit-admin',
  templateUrl: './paiement-avoir-achat-edit-admin.component.html'
})
export class PaiementAvoirAchatEditAdminComponent extends AbstractEditController<PaiementAvoirAchatDto, PaiementAvoirAchatCriteria, PaiementAvoirAchatAdminService>   implements OnInit {


    private _validPaiementAvoirAchatReference = true;
    private _validPaiementAvoirAchatDatePaiement = true;
    private _validPaiementAvoirAchatMontant = true;
    private _validPaiementAvoirAchatModePaiement = true;

    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;
    private _validModePaiementLibelle = true;
    private _validModePaiementCode = true;
    private _validAvoirAchatEntrepriseSociete = true;
    private _validAvoirAchatDateAvoir = true;
    private _validAvoirAchatMontant = true;
    private _validAvoirAchatAchat = true;



    constructor( private paiementAvoirAchatService: PaiementAvoirAchatAdminService , private modePaiementService: ModePaiementAdminService, private achatService: AchatAdminService, private avoirAchatService: AvoirAchatAdminService) {
        super(paiementAvoirAchatService);
    }

    ngOnInit(): void {
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
        this.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
        this.avoirAchat = new AvoirAchatDto();
        this.avoirAchatService.findAll().subscribe((data) => this.avoirAchats = data);
    }
    public prepareEdit() {
        this.item.datePaiement = this.paiementAvoirAchatService.format(this.item.datePaiement);
    }



    public setValidation(value: boolean){
        this.validPaiementAvoirAchatReference = value;
        this.validPaiementAvoirAchatDatePaiement = value;
        this.validPaiementAvoirAchatMontant = value;
        this.validPaiementAvoirAchatModePaiement = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaiementAvoirAchatReference();
        this.validatePaiementAvoirAchatDatePaiement();
        this.validatePaiementAvoirAchatMontant();
        this.validatePaiementAvoirAchatModePaiement();
    }
    public validatePaiementAvoirAchatReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validPaiementAvoirAchatReference = false;
        } else {
            this.validPaiementAvoirAchatReference = true;
        }
    }
    public validatePaiementAvoirAchatDatePaiement(){
        if (this.stringUtilService.isEmpty(this.item.datePaiement)) {
            this.errorMessages.push('Date paiement non valide');
            this.validPaiementAvoirAchatDatePaiement = false;
        } else {
            this.validPaiementAvoirAchatDatePaiement = true;
        }
    }
    public validatePaiementAvoirAchatMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validPaiementAvoirAchatMontant = false;
        } else {
            this.validPaiementAvoirAchatMontant = true;
        }
    }
    public validatePaiementAvoirAchatModePaiement(){
        if (this.stringUtilService.isEmpty(this.item.modePaiement)) {
            this.errorMessages.push('Mode paiement non valide');
            this.validPaiementAvoirAchatModePaiement = false;
        } else {
            this.validPaiementAvoirAchatModePaiement = true;
        }
    }




   get avoirAchat(): AvoirAchatDto {
       return this.avoirAchatService.item;
   }
  set avoirAchat(value: AvoirAchatDto) {
        this.avoirAchatService.item = value;
   }
   get avoirAchats(): Array<AvoirAchatDto> {
        return this.avoirAchatService.items;
   }
   set avoirAchats(value: Array<AvoirAchatDto>) {
        this.avoirAchatService.items = value;
   }
   get createAvoirAchatDialog(): boolean {
       return this.avoirAchatService.createDialog;
   }
  set createAvoirAchatDialog(value: boolean) {
       this.avoirAchatService.createDialog= value;
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


    get validPaiementAvoirAchatReference(): boolean {
        return this._validPaiementAvoirAchatReference;
    }
    set validPaiementAvoirAchatReference(value: boolean) {
        this._validPaiementAvoirAchatReference = value;
    }
    get validPaiementAvoirAchatDatePaiement(): boolean {
        return this._validPaiementAvoirAchatDatePaiement;
    }
    set validPaiementAvoirAchatDatePaiement(value: boolean) {
        this._validPaiementAvoirAchatDatePaiement = value;
    }
    get validPaiementAvoirAchatMontant(): boolean {
        return this._validPaiementAvoirAchatMontant;
    }
    set validPaiementAvoirAchatMontant(value: boolean) {
        this._validPaiementAvoirAchatMontant = value;
    }
    get validPaiementAvoirAchatModePaiement(): boolean {
        return this._validPaiementAvoirAchatModePaiement;
    }
    set validPaiementAvoirAchatModePaiement(value: boolean) {
        this._validPaiementAvoirAchatModePaiement = value;
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
    get validAvoirAchatEntrepriseSociete(): boolean {
        return this._validAvoirAchatEntrepriseSociete;
    }
    set validAvoirAchatEntrepriseSociete(value: boolean) {
        this._validAvoirAchatEntrepriseSociete = value;
    }
    get validAvoirAchatDateAvoir(): boolean {
        return this._validAvoirAchatDateAvoir;
    }
    set validAvoirAchatDateAvoir(value: boolean) {
        this._validAvoirAchatDateAvoir = value;
    }
    get validAvoirAchatMontant(): boolean {
        return this._validAvoirAchatMontant;
    }
    set validAvoirAchatMontant(value: boolean) {
        this._validAvoirAchatMontant = value;
    }
    get validAvoirAchatAchat(): boolean {
        return this._validAvoirAchatAchat;
    }
    set validAvoirAchatAchat(value: boolean) {
        this._validAvoirAchatAchat = value;
    }
}
