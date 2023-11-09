import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AchatItemAdminService} from 'src/app/controller/service/admin/stock/AchatItemAdmin.service';
import {AchatItemDto} from 'src/app/controller/model/stock/AchatItem.model';
import {AchatItemCriteria} from 'src/app/controller/criteria/stock/AchatItemCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';

@Component({
  selector: 'app-achat-item-edit-admin',
  templateUrl: './achat-item-edit-admin.component.html'
})
export class AchatItemEditAdminComponent extends AbstractEditController<AchatItemDto, AchatItemCriteria, AchatItemAdminService>   implements OnInit {


    private _validAchatItemBarCode = true;
    private _validAchatItemFooterBarCode = true;
    private _validAchatItemQuantite = true;
    private _validAchatItemRemise = true;
    private _validAchatItemPrixUnitaireTtc = true;

    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitCategorie = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;
    private _validDepotLibelle = true;
    private _validDepotCode = true;



    constructor( private achatItemService: AchatItemAdminService , private depotService: DepotAdminService, private produitService: ProduitAdminService, private achatService: AchatAdminService) {
        super(achatItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
    }


    public setValidation(value: boolean){
        this.validAchatItemBarCode = value;
        this.validAchatItemFooterBarCode = value;
        this.validAchatItemQuantite = value;
        this.validAchatItemRemise = value;
        this.validAchatItemPrixUnitaireTtc = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAchatItemBarCode();
        this.validateAchatItemFooterBarCode();
        this.validateAchatItemQuantite();
        this.validateAchatItemRemise();
        this.validateAchatItemPrixUnitaireTtc();
    }
    public validateAchatItemBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
            this.errorMessages.push('Bar code non valide');
            this.validAchatItemBarCode = false;
        } else {
            this.validAchatItemBarCode = true;
        }
    }
    public validateAchatItemFooterBarCode(){
        if (this.stringUtilService.isEmpty(this.item.footerBarCode)) {
            this.errorMessages.push('Footer bar code non valide');
            this.validAchatItemFooterBarCode = false;
        } else {
            this.validAchatItemFooterBarCode = true;
        }
    }
    public validateAchatItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validAchatItemQuantite = false;
        } else {
            this.validAchatItemQuantite = true;
        }
    }
    public validateAchatItemRemise(){
        if (this.stringUtilService.isEmpty(this.item.remise)) {
            this.errorMessages.push('Remise non valide');
            this.validAchatItemRemise = false;
        } else {
            this.validAchatItemRemise = true;
        }
    }
    public validateAchatItemPrixUnitaireTtc(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireTtc)) {
            this.errorMessages.push('Prix unitaire ttc non valide');
            this.validAchatItemPrixUnitaireTtc = false;
        } else {
            this.validAchatItemPrixUnitaireTtc = true;
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
   public async openCreateAchat(achat: string) {
        const isPermistted = await this.roleService.isPermitted('Achat', 'edit');
        if (isPermistted) {
             this.achat = new AchatDto();
             this.createAchatDialog = true;
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


    get validAchatItemBarCode(): boolean {
        return this._validAchatItemBarCode;
    }
    set validAchatItemBarCode(value: boolean) {
        this._validAchatItemBarCode = value;
    }
    get validAchatItemFooterBarCode(): boolean {
        return this._validAchatItemFooterBarCode;
    }
    set validAchatItemFooterBarCode(value: boolean) {
        this._validAchatItemFooterBarCode = value;
    }
    get validAchatItemQuantite(): boolean {
        return this._validAchatItemQuantite;
    }
    set validAchatItemQuantite(value: boolean) {
        this._validAchatItemQuantite = value;
    }
    get validAchatItemRemise(): boolean {
        return this._validAchatItemRemise;
    }
    set validAchatItemRemise(value: boolean) {
        this._validAchatItemRemise = value;
    }
    get validAchatItemPrixUnitaireTtc(): boolean {
        return this._validAchatItemPrixUnitaireTtc;
    }
    set validAchatItemPrixUnitaireTtc(value: boolean) {
        this._validAchatItemPrixUnitaireTtc = value;
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
}
