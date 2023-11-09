import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ChequeEffetAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ChequeEffetAdmin.service';
import {ChequeEffetDto} from 'src/app/controller/model/gestionchequeffet/ChequeEffet.model';
import {ChequeEffetCriteria} from 'src/app/controller/criteria/gestionchequeffet/ChequeEffetCriteria.model';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
@Component({
  selector: 'app-cheque-effet-create-admin',
  templateUrl: './cheque-effet-create-admin.component.html'
})
export class ChequeEffetCreateAdminComponent extends AbstractCreateController<ChequeEffetDto, ChequeEffetCriteria, ChequeEffetAdminService>  implements OnInit {



   private _validChequeEffetNumeroChequeEffet = true;
   private _validChequeEffetMontant = true;
    private _validBeneficiaireNom = true;
    private _validBeneficiaireIce = true;

    constructor( private chequeEffetService: ChequeEffetAdminService , private fournisseurService: FournisseurAdminService) {
        super(chequeEffetService);
    }

    ngOnInit(): void {
        this.beneficiaire = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.beneficiaires = data);
    }





    public setValidation(value: boolean){
        this.validChequeEffetNumeroChequeEffet = value;
        this.validChequeEffetMontant = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateChequeEffetNumeroChequeEffet();
        this.validateChequeEffetMontant();
    }

    public validateChequeEffetNumeroChequeEffet(){
        if (this.stringUtilService.isEmpty(this.item.numeroChequeEffet)) {
        this.errorMessages.push('Numero cheque effet non valide');
        this.validChequeEffetNumeroChequeEffet = false;
        } else {
            this.validChequeEffetNumeroChequeEffet = true;
        }
    }
    public validateChequeEffetMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
        this.errorMessages.push('Montant non valide');
        this.validChequeEffetMontant = false;
        } else {
            this.validChequeEffetMontant = true;
        }
    }



    get beneficiaire(): FournisseurDto {
        return this.fournisseurService.item;
    }
    set beneficiaire(value: FournisseurDto) {
        this.fournisseurService.item = value;
    }
    get beneficiaires(): Array<FournisseurDto> {
        return this.fournisseurService.items;
    }
    set beneficiaires(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
    }
    get createBeneficiaireDialog(): boolean {
       return this.fournisseurService.createDialog;
    }
    set createBeneficiaireDialog(value: boolean) {
        this.fournisseurService.createDialog= value;
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

    get validBeneficiaireNom(): boolean {
        return this._validBeneficiaireNom;
    }
    set validBeneficiaireNom(value: boolean) {
        this._validBeneficiaireNom = value;
    }
    get validBeneficiaireIce(): boolean {
        return this._validBeneficiaireIce;
    }
    set validBeneficiaireIce(value: boolean) {
        this._validBeneficiaireIce = value;
    }


}
