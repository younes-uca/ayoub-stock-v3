import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaiementVenteAdminService} from 'src/app/controller/service/admin/paiement/PaiementVenteAdmin.service';
import {PaiementVenteDto} from 'src/app/controller/model/paiement/PaiementVente.model';
import {PaiementVenteCriteria} from 'src/app/controller/criteria/paiement/PaiementVenteCriteria.model';


import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementAdminService} from 'src/app/controller/service/admin/commun/ModePaiementAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';

@Component({
  selector: 'app-paiement-vente-edit-admin',
  templateUrl: './paiement-vente-edit-admin.component.html'
})
export class PaiementVenteEditAdminComponent extends AbstractEditController<PaiementVenteDto, PaiementVenteCriteria, PaiementVenteAdminService>   implements OnInit {


    private _validPaiementVenteReference = true;
    private _validPaiementVenteDatePaiement = true;
    private _validPaiementVenteMontant = true;
    private _validPaiementVenteVente = true;
    private _validPaiementVenteModePaiement = true;

    private _validVenteEntrepriseSociete = true;
    private _validVenteCodeVente = true;
    private _validVenteClient = true;
    private _validVenteMontantTtc = true;
    private _validModePaiementLibelle = true;
    private _validModePaiementCode = true;



    constructor( private paiementVenteService: PaiementVenteAdminService , private modePaiementService: ModePaiementAdminService, private venteService: VenteAdminService) {
        super(paiementVenteService);
    }

    ngOnInit(): void {
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
        this.modePaiement = new ModePaiementDto();
        this.modePaiementService.findAll().subscribe((data) => this.modePaiements = data);
    }
    public prepareEdit() {
        this.item.datePaiement = this.paiementVenteService.format(this.item.datePaiement);
    }



    public setValidation(value: boolean){
        this.validPaiementVenteReference = value;
        this.validPaiementVenteDatePaiement = value;
        this.validPaiementVenteMontant = value;
        this.validPaiementVenteVente = value;
        this.validPaiementVenteModePaiement = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePaiementVenteReference();
        this.validatePaiementVenteDatePaiement();
        this.validatePaiementVenteMontant();
        this.validatePaiementVenteVente();
        this.validatePaiementVenteModePaiement();
    }
    public validatePaiementVenteReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
            this.errorMessages.push('Reference non valide');
            this.validPaiementVenteReference = false;
        } else {
            this.validPaiementVenteReference = true;
        }
    }
    public validatePaiementVenteDatePaiement(){
        if (this.stringUtilService.isEmpty(this.item.datePaiement)) {
            this.errorMessages.push('Date paiement non valide');
            this.validPaiementVenteDatePaiement = false;
        } else {
            this.validPaiementVenteDatePaiement = true;
        }
    }
    public validatePaiementVenteMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validPaiementVenteMontant = false;
        } else {
            this.validPaiementVenteMontant = true;
        }
    }
    public validatePaiementVenteVente(){
        if (this.stringUtilService.isEmpty(this.item.vente)) {
            this.errorMessages.push('Vente non valide');
            this.validPaiementVenteVente = false;
        } else {
            this.validPaiementVenteVente = true;
        }
    }
    public validatePaiementVenteModePaiement(){
        if (this.stringUtilService.isEmpty(this.item.modePaiement)) {
            this.errorMessages.push('Mode paiement non valide');
            this.validPaiementVenteModePaiement = false;
        } else {
            this.validPaiementVenteModePaiement = true;
        }
    }




   get vente(): VenteDto {
       return this.venteService.item;
   }
  set vente(value: VenteDto) {
        this.venteService.item = value;
   }
   get ventes(): Array<VenteDto> {
        return this.venteService.items;
   }
   set ventes(value: Array<VenteDto>) {
        this.venteService.items = value;
   }
   get createVenteDialog(): boolean {
       return this.venteService.createDialog;
   }
  set createVenteDialog(value: boolean) {
       this.venteService.createDialog= value;
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


    get validPaiementVenteReference(): boolean {
        return this._validPaiementVenteReference;
    }
    set validPaiementVenteReference(value: boolean) {
        this._validPaiementVenteReference = value;
    }
    get validPaiementVenteDatePaiement(): boolean {
        return this._validPaiementVenteDatePaiement;
    }
    set validPaiementVenteDatePaiement(value: boolean) {
        this._validPaiementVenteDatePaiement = value;
    }
    get validPaiementVenteMontant(): boolean {
        return this._validPaiementVenteMontant;
    }
    set validPaiementVenteMontant(value: boolean) {
        this._validPaiementVenteMontant = value;
    }
    get validPaiementVenteVente(): boolean {
        return this._validPaiementVenteVente;
    }
    set validPaiementVenteVente(value: boolean) {
        this._validPaiementVenteVente = value;
    }
    get validPaiementVenteModePaiement(): boolean {
        return this._validPaiementVenteModePaiement;
    }
    set validPaiementVenteModePaiement(value: boolean) {
        this._validPaiementVenteModePaiement = value;
    }

    get validVenteEntrepriseSociete(): boolean {
        return this._validVenteEntrepriseSociete;
    }
    set validVenteEntrepriseSociete(value: boolean) {
        this._validVenteEntrepriseSociete = value;
    }
    get validVenteCodeVente(): boolean {
        return this._validVenteCodeVente;
    }
    set validVenteCodeVente(value: boolean) {
        this._validVenteCodeVente = value;
    }
    get validVenteClient(): boolean {
        return this._validVenteClient;
    }
    set validVenteClient(value: boolean) {
        this._validVenteClient = value;
    }
    get validVenteMontantTtc(): boolean {
        return this._validVenteMontantTtc;
    }
    set validVenteMontantTtc(value: boolean) {
        this._validVenteMontantTtc = value;
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
