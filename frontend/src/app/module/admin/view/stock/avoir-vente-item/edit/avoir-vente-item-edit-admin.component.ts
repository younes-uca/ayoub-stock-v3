import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemCriteria} from 'src/app/controller/criteria/stock/AvoirVenteItemCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';

@Component({
  selector: 'app-avoir-vente-item-edit-admin',
  templateUrl: './avoir-vente-item-edit-admin.component.html'
})
export class AvoirVenteItemEditAdminComponent extends AbstractEditController<AvoirVenteItemDto, AvoirVenteItemCriteria, AvoirVenteItemAdminService>   implements OnInit {


    private _validAvoirVenteItemProduit = true;
    private _validAvoirVenteItemMontantAvoir = true;
    private _validAvoirVenteItemQuantite = true;
    private _validAvoirVenteItemDepot = true;

    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitCategorie = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validDepotLibelle = true;
    private _validDepotCode = true;
    private _validAvoirVenteEntrepriseSociete = true;
    private _validAvoirVenteDateAvoir = true;
    private _validAvoirVenteMontant = true;
    private _validAvoirVenteVente = true;



    constructor( private avoirVenteItemService: AvoirVenteItemAdminService , private depotService: DepotAdminService, private produitService: ProduitAdminService, private avoirVenteService: AvoirVenteAdminService) {
        super(avoirVenteItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.avoirVente = new AvoirVenteDto();
        this.avoirVenteService.findAll().subscribe((data) => this.avoirVentes = data);
    }


    public setValidation(value: boolean){
        this.validAvoirVenteItemProduit = value;
        this.validAvoirVenteItemMontantAvoir = value;
        this.validAvoirVenteItemQuantite = value;
        this.validAvoirVenteItemDepot = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAvoirVenteItemProduit();
        this.validateAvoirVenteItemMontantAvoir();
        this.validateAvoirVenteItemQuantite();
        this.validateAvoirVenteItemDepot();
    }
    public validateAvoirVenteItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validAvoirVenteItemProduit = false;
        } else {
            this.validAvoirVenteItemProduit = true;
        }
    }
    public validateAvoirVenteItemMontantAvoir(){
        if (this.stringUtilService.isEmpty(this.item.montantAvoir)) {
            this.errorMessages.push('Montant avoir non valide');
            this.validAvoirVenteItemMontantAvoir = false;
        } else {
            this.validAvoirVenteItemMontantAvoir = true;
        }
    }
    public validateAvoirVenteItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validAvoirVenteItemQuantite = false;
        } else {
            this.validAvoirVenteItemQuantite = true;
        }
    }
    public validateAvoirVenteItemDepot(){
        if (this.stringUtilService.isEmpty(this.item.depot)) {
            this.errorMessages.push('Depot non valide');
            this.validAvoirVenteItemDepot = false;
        } else {
            this.validAvoirVenteItemDepot = true;
        }
    }



   public async openCreateProduit(produit: string) {
        const isPermistted = await this.roleService.isPermitted('Produit', 'edit');
        if (isPermistted) {
             this.produit = new ProduitDto();
             this.createProduitDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateAvoirVente(avoirVente: string) {
        const isPermistted = await this.roleService.isPermitted('AvoirVente', 'edit');
        if (isPermistted) {
             this.avoirVente = new AvoirVenteDto();
             this.createAvoirVenteDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get produit(): ProduitDto {
       return this.produitService.item;
   }
  set produit(value: ProduitDto) {
        this.produitService.item = value;
   }
   get produits(): Array<ProduitDto> {
        return this.produitService.items;
   }
   set produits(value: Array<ProduitDto>) {
        this.produitService.items = value;
   }
   get createProduitDialog(): boolean {
       return this.produitService.createDialog;
   }
  set createProduitDialog(value: boolean) {
       this.produitService.createDialog= value;
   }
   get depot(): DepotDto {
       return this.depotService.item;
   }
  set depot(value: DepotDto) {
        this.depotService.item = value;
   }
   get depots(): Array<DepotDto> {
        return this.depotService.items;
   }
   set depots(value: Array<DepotDto>) {
        this.depotService.items = value;
   }
   get createDepotDialog(): boolean {
       return this.depotService.createDialog;
   }
  set createDepotDialog(value: boolean) {
       this.depotService.createDialog= value;
   }
   get avoirVente(): AvoirVenteDto {
       return this.avoirVenteService.item;
   }
  set avoirVente(value: AvoirVenteDto) {
        this.avoirVenteService.item = value;
   }
   get avoirVentes(): Array<AvoirVenteDto> {
        return this.avoirVenteService.items;
   }
   set avoirVentes(value: Array<AvoirVenteDto>) {
        this.avoirVenteService.items = value;
   }
   get createAvoirVenteDialog(): boolean {
       return this.avoirVenteService.createDialog;
   }
  set createAvoirVenteDialog(value: boolean) {
       this.avoirVenteService.createDialog= value;
   }


    get validAvoirVenteItemProduit(): boolean {
        return this._validAvoirVenteItemProduit;
    }
    set validAvoirVenteItemProduit(value: boolean) {
        this._validAvoirVenteItemProduit = value;
    }
    get validAvoirVenteItemMontantAvoir(): boolean {
        return this._validAvoirVenteItemMontantAvoir;
    }
    set validAvoirVenteItemMontantAvoir(value: boolean) {
        this._validAvoirVenteItemMontantAvoir = value;
    }
    get validAvoirVenteItemQuantite(): boolean {
        return this._validAvoirVenteItemQuantite;
    }
    set validAvoirVenteItemQuantite(value: boolean) {
        this._validAvoirVenteItemQuantite = value;
    }
    get validAvoirVenteItemDepot(): boolean {
        return this._validAvoirVenteItemDepot;
    }
    set validAvoirVenteItemDepot(value: boolean) {
        this._validAvoirVenteItemDepot = value;
    }

    get validProduitReference(): boolean {
        return this._validProduitReference;
    }
    set validProduitReference(value: boolean) {
        this._validProduitReference = value;
    }
    get validProduitBarCode(): boolean {
        return this._validProduitBarCode;
    }
    set validProduitBarCode(value: boolean) {
        this._validProduitBarCode = value;
    }
    get validProduitCategorie(): boolean {
        return this._validProduitCategorie;
    }
    set validProduitCategorie(value: boolean) {
        this._validProduitCategorie = value;
    }
    get validProduitDesignation(): boolean {
        return this._validProduitDesignation;
    }
    set validProduitDesignation(value: boolean) {
        this._validProduitDesignation = value;
    }
    get validProduitQuantite(): boolean {
        return this._validProduitQuantite;
    }
    set validProduitQuantite(value: boolean) {
        this._validProduitQuantite = value;
    }
    get validDepotLibelle(): boolean {
        return this._validDepotLibelle;
    }
    set validDepotLibelle(value: boolean) {
        this._validDepotLibelle = value;
    }
    get validDepotCode(): boolean {
        return this._validDepotCode;
    }
    set validDepotCode(value: boolean) {
        this._validDepotCode = value;
    }
    get validAvoirVenteEntrepriseSociete(): boolean {
        return this._validAvoirVenteEntrepriseSociete;
    }
    set validAvoirVenteEntrepriseSociete(value: boolean) {
        this._validAvoirVenteEntrepriseSociete = value;
    }
    get validAvoirVenteDateAvoir(): boolean {
        return this._validAvoirVenteDateAvoir;
    }
    set validAvoirVenteDateAvoir(value: boolean) {
        this._validAvoirVenteDateAvoir = value;
    }
    get validAvoirVenteMontant(): boolean {
        return this._validAvoirVenteMontant;
    }
    set validAvoirVenteMontant(value: boolean) {
        this._validAvoirVenteMontant = value;
    }
    get validAvoirVenteVente(): boolean {
        return this._validAvoirVenteVente;
    }
    set validAvoirVenteVente(value: boolean) {
        this._validAvoirVenteVente = value;
    }
}
