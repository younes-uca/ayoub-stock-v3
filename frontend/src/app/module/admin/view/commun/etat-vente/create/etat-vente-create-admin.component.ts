import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatVenteAdminService} from 'src/app/controller/service/admin/commun/EtatVenteAdmin.service';
import {EtatVenteDto} from 'src/app/controller/model/commun/EtatVente.model';
import {EtatVenteCriteria} from 'src/app/controller/criteria/commun/EtatVenteCriteria.model';
@Component({
  selector: 'app-etat-vente-create-admin',
  templateUrl: './etat-vente-create-admin.component.html'
})
export class EtatVenteCreateAdminComponent extends AbstractCreateController<EtatVenteDto, EtatVenteCriteria, EtatVenteAdminService>  implements OnInit {



   private _validEtatVenteLibelle = true;
   private _validEtatVenteCode = true;

    constructor( private etatVenteService: EtatVenteAdminService ) {
        super(etatVenteService);
    }

    ngOnInit(): void {
    }





    public setValidation(value: boolean){
        this.validEtatVenteLibelle = value;
        this.validEtatVenteCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatVenteLibelle();
        this.validateEtatVenteCode();
    }

    public validateEtatVenteLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatVenteLibelle = false;
        } else {
            this.validEtatVenteLibelle = true;
        }
    }
    public validateEtatVenteCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatVenteCode = false;
        } else {
            this.validEtatVenteCode = true;
        }
    }






    get validEtatVenteLibelle(): boolean {
        return this._validEtatVenteLibelle;
    }

    set validEtatVenteLibelle(value: boolean) {
         this._validEtatVenteLibelle = value;
    }
    get validEtatVenteCode(): boolean {
        return this._validEtatVenteCode;
    }

    set validEtatVenteCode(value: boolean) {
         this._validEtatVenteCode = value;
    }



}
