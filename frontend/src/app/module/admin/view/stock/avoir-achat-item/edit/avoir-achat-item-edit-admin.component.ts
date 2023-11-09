import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemCriteria} from 'src/app/controller/criteria/stock/AvoirAchatItemCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';

@Component({
  selector: 'app-avoir-achat-item-edit-admin',
  templateUrl: './avoir-achat-item-edit-admin.component.html'
})
export class AvoirAchatItemEditAdminComponent extends AbstractEditController<AvoirAchatItemDto, AvoirAchatItemCriteria, AvoirAchatItemAdminService>   implements OnInit {


    private _validAvoirAchatItemProduit = true;
    private _validAvoirAchatItemMontantAvoir = true;
    private _validAvoirAchatItemQuantite = true;
    private _validAvoirAchatItemDepot = true;

    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitCategorie = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validDepotLibelle = true;
    private _validDepotCode = true;
    private _validAvoirAchatEntrepriseSociete = true;
    private _validAvoirAchatDateAvoir = true;
    private _validAvoirAchatMontant = true;
    private _validAvoirAchatAchat = true;



    constructor( private avoirAchatItemService: AvoirAchatItemAdminService , private depotService: DepotAdminService, private produitService: ProduitAdminService, private avoirAchatService: AvoirAchatAdminService) {
        super(avoirAchatItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.avoirAchat = new AvoirAchatDto();
        this.avoirAchatService.findAll().subscribe((data) => this.avoirAchats = data);
    }


    public setValidation(value: boolean){
        this.validAvoirAchatItemProduit = value;
        this.validAvoirAchatItemMontantAvoir = value;
        this.validAvoirAchatItemQuantite = value;
        this.validAvoirAchatItemDepot = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAvoirAchatItemProduit();
        this.validateAvoirAchatItemMontantAvoir();
        this.validateAvoirAchatItemQuantite();
        this.validateAvoirAchatItemDepot();
    }
    public validateAvoirAchatItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validAvoirAchatItemProduit = false;
        } else {
            this.validAvoirAchatItemProduit = true;
        }
    }
    public validateAvoirAchatItemMontantAvoir(){
        if (this.stringUtilService.isEmpty(this.item.montantAvoir)) {
            this.errorMessages.push('Montant avoir non valide');
            this.validAvoirAchatItemMontantAvoir = false;
        } else {
            this.validAvoirAchatItemMontantAvoir = true;
        }
    }
    public validateAvoirAchatItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validAvoirAchatItemQuantite = false;
        } else {
            this.validAvoirAchatItemQuantite = true;
        }
    }
    public validateAvoirAchatItemDepot(){
        if (this.stringUtilService.isEmpty(this.item.depot)) {
            this.errorMessages.push('Depot non valide');
            this.validAvoirAchatItemDepot = false;
        } else {
            this.validAvoirAchatItemDepot = true;
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
   public async openCreateAvoirAchat(avoirAchat: string) {
        const isPermistted = await this.roleService.isPermitted('AvoirAchat', 'edit');
        if (isPermistted) {
             this.avoirAchat = new AvoirAchatDto();
             this.createAvoirAchatDialog = true;
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


    get validAvoirAchatItemProduit(): boolean {
        return this._validAvoirAchatItemProduit;
    }
    set validAvoirAchatItemProduit(value: boolean) {
        this._validAvoirAchatItemProduit = value;
    }
    get validAvoirAchatItemMontantAvoir(): boolean {
        return this._validAvoirAchatItemMontantAvoir;
    }
    set validAvoirAchatItemMontantAvoir(value: boolean) {
        this._validAvoirAchatItemMontantAvoir = value;
    }
    get validAvoirAchatItemQuantite(): boolean {
        return this._validAvoirAchatItemQuantite;
    }
    set validAvoirAchatItemQuantite(value: boolean) {
        this._validAvoirAchatItemQuantite = value;
    }
    get validAvoirAchatItemDepot(): boolean {
        return this._validAvoirAchatItemDepot;
    }
    set validAvoirAchatItemDepot(value: boolean) {
        this._validAvoirAchatItemDepot = value;
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
