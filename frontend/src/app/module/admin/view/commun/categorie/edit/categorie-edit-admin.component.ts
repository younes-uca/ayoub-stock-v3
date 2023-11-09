import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CategorieAdminService} from 'src/app/controller/service/admin/commun/CategorieAdmin.service';
import {CategorieDto} from 'src/app/controller/model/commun/Categorie.model';
import {CategorieCriteria} from 'src/app/controller/criteria/commun/CategorieCriteria.model';



@Component({
  selector: 'app-categorie-edit-admin',
  templateUrl: './categorie-edit-admin.component.html'
})
export class CategorieEditAdminComponent extends AbstractEditController<CategorieDto, CategorieCriteria, CategorieAdminService>   implements OnInit {


    private _validCategorieLibelle = true;
    private _validCategorieCode = true;




    constructor( private categorieService: CategorieAdminService ) {
        super(categorieService);
    }

    ngOnInit(): void {
    }


    public setValidation(value: boolean){
        this.validCategorieLibelle = value;
        this.validCategorieCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCategorieLibelle();
        this.validateCategorieCode();
    }
    public validateCategorieLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validCategorieLibelle = false;
        } else {
            this.validCategorieLibelle = true;
        }
    }
    public validateCategorieCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validCategorieCode = false;
        } else {
            this.validCategorieCode = true;
        }
    }






    get validCategorieLibelle(): boolean {
        return this._validCategorieLibelle;
    }
    set validCategorieLibelle(value: boolean) {
        this._validCategorieLibelle = value;
    }
    get validCategorieCode(): boolean {
        return this._validCategorieCode;
    }
    set validCategorieCode(value: boolean) {
        this._validCategorieCode = value;
    }

}
