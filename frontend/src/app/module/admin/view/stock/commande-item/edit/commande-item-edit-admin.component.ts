import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CommandeItemAdminService} from 'src/app/controller/service/admin/stock/CommandeItemAdmin.service';
import {CommandeItemDto} from 'src/app/controller/model/stock/CommandeItem.model';
import {CommandeItemCriteria} from 'src/app/controller/criteria/stock/CommandeItemCriteria.model';


import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {CommandeDto} from 'src/app/controller/model/stock/Commande.model';
import {CommandeAdminService} from 'src/app/controller/service/admin/stock/CommandeAdmin.service';

@Component({
  selector: 'app-commande-item-edit-admin',
  templateUrl: './commande-item-edit-admin.component.html'
})
export class CommandeItemEditAdminComponent extends AbstractEditController<CommandeItemDto, CommandeItemCriteria, CommandeItemAdminService>   implements OnInit {


    private _validCommandeItemProduit = true;
    private _validCommandeItemQuantite = true;

    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitCategorie = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;



    constructor( private commandeItemService: CommandeItemAdminService , private produitService: ProduitAdminService, private commandeService: CommandeAdminService) {
        super(commandeItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.commande = new CommandeDto();
        this.commandeService.findAll().subscribe((data) => this.commandes = data);
    }


    public setValidation(value: boolean){
        this.validCommandeItemProduit = value;
        this.validCommandeItemQuantite = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateCommandeItemProduit();
        this.validateCommandeItemQuantite();
    }
    public validateCommandeItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validCommandeItemProduit = false;
        } else {
            this.validCommandeItemProduit = true;
        }
    }
    public validateCommandeItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validCommandeItemQuantite = false;
        } else {
            this.validCommandeItemQuantite = true;
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
   public async openCreateCommande(commande: string) {
        const isPermistted = await this.roleService.isPermitted('Commande', 'edit');
        if (isPermistted) {
             this.commande = new CommandeDto();
             this.createCommandeDialog = true;
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
   get commande(): CommandeDto {
       return this.commandeService.item;
   }
  set commande(value: CommandeDto) {
        this.commandeService.item = value;
   }
   get commandes(): Array<CommandeDto> {
        return this.commandeService.items;
   }
   set commandes(value: Array<CommandeDto>) {
        this.commandeService.items = value;
   }
   get createCommandeDialog(): boolean {
       return this.commandeService.createDialog;
   }
  set createCommandeDialog(value: boolean) {
       this.commandeService.createDialog= value;
   }


    get validCommandeItemProduit(): boolean {
        return this._validCommandeItemProduit;
    }
    set validCommandeItemProduit(value: boolean) {
        this._validCommandeItemProduit = value;
    }
    get validCommandeItemQuantite(): boolean {
        return this._validCommandeItemQuantite;
    }
    set validCommandeItemQuantite(value: boolean) {
        this._validCommandeItemQuantite = value;
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
}
