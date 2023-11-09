import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ProprietaireAdminService} from 'src/app/controller/service/admin/gestionchequeffet/ProprietaireAdmin.service';
import {ProprietaireDto} from 'src/app/controller/model/gestionchequeffet/Proprietaire.model';
import {ProprietaireCriteria} from 'src/app/controller/criteria/gestionchequeffet/ProprietaireCriteria.model';



@Component({
  selector: 'app-proprietaire-edit-admin',
  templateUrl: './proprietaire-edit-admin.component.html'
})
export class ProprietaireEditAdminComponent extends AbstractEditController<ProprietaireDto, ProprietaireCriteria, ProprietaireAdminService>   implements OnInit {


    private _validProprietaireNom = true;
    private _validProprietaireCode = true;




    constructor( private proprietaireService: ProprietaireAdminService ) {
        super(proprietaireService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validProprietaireNom = value;
        this.validProprietaireCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProprietaireNom();
        this.validateProprietaireCode();
    }
    public validateProprietaireNom(){
        if (this.stringUtilService.isEmpty(this.item.nom)) {
            this.errorMessages.push('Nom non valide');
            this.validProprietaireNom = false;
        } else {
            this.validProprietaireNom = true;
        }
    }
    public validateProprietaireCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validProprietaireCode = false;
        } else {
            this.validProprietaireCode = true;
        }
    }






    get validProprietaireNom(): boolean {
        return this._validProprietaireNom;
    }
    set validProprietaireNom(value: boolean) {
        this._validProprietaireNom = value;
    }
    get validProprietaireCode(): boolean {
        return this._validProprietaireCode;
    }
    set validProprietaireCode(value: boolean) {
        this._validProprietaireCode = value;
    }

}
