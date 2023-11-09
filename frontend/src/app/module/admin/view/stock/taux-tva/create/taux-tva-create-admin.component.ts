import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TauxTvaAdminService} from 'src/app/controller/service/admin/stock/TauxTvaAdmin.service';
import {TauxTvaDto} from 'src/app/controller/model/stock/TauxTva.model';
import {TauxTvaCriteria} from 'src/app/controller/criteria/stock/TauxTvaCriteria.model';
@Component({
  selector: 'app-taux-tva-create-admin',
  templateUrl: './taux-tva-create-admin.component.html'
})
export class TauxTvaCreateAdminComponent extends AbstractCreateController<TauxTvaDto, TauxTvaCriteria, TauxTvaAdminService>  implements OnInit {



   private _validTauxTvaLibelle = true;
   private _validTauxTvaMontant = true;
   private _validTauxTvaCode = true;

    constructor( private tauxTvaService: TauxTvaAdminService ) {
        super(tauxTvaService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validTauxTvaLibelle = value;
        this.validTauxTvaMontant = value;
        this.validTauxTvaCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTauxTvaLibelle();
        this.validateTauxTvaMontant();
        this.validateTauxTvaCode();
    }

    public validateTauxTvaLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validTauxTvaLibelle = false;
        } else {
            this.validTauxTvaLibelle = true;
        }
    }
    public validateTauxTvaMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
        this.errorMessages.push('Montant non valide');
        this.validTauxTvaMontant = false;
        } else {
            this.validTauxTvaMontant = true;
        }
    }
    public validateTauxTvaCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validTauxTvaCode = false;
        } else {
            this.validTauxTvaCode = true;
        }
    }






    get validTauxTvaLibelle(): boolean {
        return this._validTauxTvaLibelle;
    }

    set validTauxTvaLibelle(value: boolean) {
         this._validTauxTvaLibelle = value;
    }
    get validTauxTvaMontant(): boolean {
        return this._validTauxTvaMontant;
    }

    set validTauxTvaMontant(value: boolean) {
         this._validTauxTvaMontant = value;
    }
    get validTauxTvaCode(): boolean {
        return this._validTauxTvaCode;
    }

    set validTauxTvaCode(value: boolean) {
         this._validTauxTvaCode = value;
    }



}
