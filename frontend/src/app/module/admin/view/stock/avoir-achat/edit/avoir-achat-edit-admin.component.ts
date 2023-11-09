import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatCriteria} from 'src/app/controller/criteria/stock/AvoirAchatCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';

@Component({
  selector: 'app-avoir-achat-edit-admin',
  templateUrl: './avoir-achat-edit-admin.component.html'
})
export class AvoirAchatEditAdminComponent extends AbstractEditController<AvoirAchatDto, AvoirAchatCriteria, AvoirAchatAdminService>   implements OnInit {

    private _avoirAchatItemsElement = new AvoirAchatItemDto();

    private _validAvoirAchatEntrepriseSociete = true;
    private _validAvoirAchatDateAvoir = true;
    private _validAvoirAchatMontant = true;
    private _validAvoirAchatAchat = true;

    private _validEntrepriseSocieteNom = true;
    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;
    private _validAvoirAchatItemsProduit = true;
    private _validAvoirAchatItemsMontantAvoir = true;
    private _validAvoirAchatItemsQuantite = true;
    private _validAvoirAchatItemsDepot = true;



    constructor( private avoirAchatService: AvoirAchatAdminService , private depotService: DepotAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private produitService: ProduitAdminService, private avoirAchatItemService: AvoirAchatItemAdminService, private achatService: AchatAdminService) {
        super(avoirAchatService);
    }

    ngOnInit(): void {
        this.avoirAchatItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.avoirAchatItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);

        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.achat = new AchatDto();
        this.achatService.findAll().subscribe((data) => this.achats = data);
    }
    public prepareEdit() {
        this.item.dateAvoir = this.avoirAchatService.format(this.item.dateAvoir);
    }



    public validateAvoirAchatItems(){
        this.errorMessages = new Array();
        this.validateAvoirAchatItemsProduit();
        this.validateAvoirAchatItemsMontantAvoir();
        this.validateAvoirAchatItemsQuantite();
        this.validateAvoirAchatItemsDepot();
    }
    public setValidation(value: boolean){
        this.validAvoirAchatEntrepriseSociete = value;
        this.validAvoirAchatDateAvoir = value;
        this.validAvoirAchatMontant = value;
        this.validAvoirAchatAchat = value;
        this.validAvoirAchatItemsProduit = value;
        this.validAvoirAchatItemsMontantAvoir = value;
        this.validAvoirAchatItemsQuantite = value;
        this.validAvoirAchatItemsDepot = value;
        }
   public addAvoirAchatItems() {
        if( this.item.avoirAchatItems == null )
            this.item.avoirAchatItems = new Array<AvoirAchatItemDto>();
       this.validateAvoirAchatItems();
       if (this.errorMessages.length === 0) {
            if(this.avoirAchatItemsElement.id == null){
                this.item.avoirAchatItems.push(this.avoirAchatItemsElement);
            }else{
                const index = this.item.avoirAchatItems.findIndex(e => e.id == this.avoirAchatItemsElement.id);
                this.item.avoirAchatItems[index] = this.avoirAchatItemsElement;
            }
          this.avoirAchatItemsElement = new AvoirAchatItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirAchatItems(p: AvoirAchatItemDto) {
        this.item.avoirAchatItems.forEach((element, index) => {
            if (element === p) { this.item.avoirAchatItems.splice(index, 1); }
        });
    }

    public editAvoirAchatItems(p: AvoirAchatItemDto) {
        this.avoirAchatItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAvoirAchatEntrepriseSociete();
        this.validateAvoirAchatDateAvoir();
        this.validateAvoirAchatMontant();
        this.validateAvoirAchatAchat();
    }
    public validateAvoirAchatEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
            this.errorMessages.push('Entreprise societe non valide');
            this.validAvoirAchatEntrepriseSociete = false;
        } else {
            this.validAvoirAchatEntrepriseSociete = true;
        }
    }
    public validateAvoirAchatDateAvoir(){
        if (this.stringUtilService.isEmpty(this.item.dateAvoir)) {
            this.errorMessages.push('Date avoir non valide');
            this.validAvoirAchatDateAvoir = false;
        } else {
            this.validAvoirAchatDateAvoir = true;
        }
    }
    public validateAvoirAchatMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validAvoirAchatMontant = false;
        } else {
            this.validAvoirAchatMontant = true;
        }
    }
    public validateAvoirAchatAchat(){
        if (this.stringUtilService.isEmpty(this.item.achat)) {
            this.errorMessages.push('Achat non valide');
            this.validAvoirAchatAchat = false;
        } else {
            this.validAvoirAchatAchat = true;
        }
    }


    private validateAvoirAchatItemsProduit(){
        if (this.avoirAchatItemsElement.produit == null) {
        this.errorMessages.push('Produit de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsProduit = false;
        } else {
            this.validAvoirAchatItemsProduit = true;
        }
    }
    private validateAvoirAchatItemsMontantAvoir(){
        if (this.avoirAchatItemsElement.montantAvoir == null) {
        this.errorMessages.push('MontantAvoir de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsMontantAvoir = false;
        } else {
            this.validAvoirAchatItemsMontantAvoir = true;
        }
    }
    private validateAvoirAchatItemsQuantite(){
        if (this.avoirAchatItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsQuantite = false;
        } else {
            this.validAvoirAchatItemsQuantite = true;
        }
    }
    private validateAvoirAchatItemsDepot(){
        if (this.avoirAchatItemsElement.depot == null) {
        this.errorMessages.push('Depot de la avoirAchatItem est  invalide');
            this.validAvoirAchatItemsDepot = false;
        } else {
            this.validAvoirAchatItemsDepot = true;
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
   get entrepriseSociete(): EntrepriseSocieteDto {
       return this.entrepriseSocieteService.item;
   }
  set entrepriseSociete(value: EntrepriseSocieteDto) {
        this.entrepriseSocieteService.item = value;
   }
   get entrepriseSocietes(): Array<EntrepriseSocieteDto> {
        return this.entrepriseSocieteService.items;
   }
   set entrepriseSocietes(value: Array<EntrepriseSocieteDto>) {
        this.entrepriseSocieteService.items = value;
   }
   get createEntrepriseSocieteDialog(): boolean {
       return this.entrepriseSocieteService.createDialog;
   }
  set createEntrepriseSocieteDialog(value: boolean) {
       this.entrepriseSocieteService.createDialog= value;
   }

    get avoirAchatItemsElement(): AvoirAchatItemDto {
        if( this._avoirAchatItemsElement == null )
            this._avoirAchatItemsElement = new AvoirAchatItemDto();
         return this._avoirAchatItemsElement;
    }

    set avoirAchatItemsElement(value: AvoirAchatItemDto) {
        this._avoirAchatItemsElement = value;
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

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
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
    get validAvoirAchatItemsProduit(): boolean {
        return this._validAvoirAchatItemsProduit;
    }
    set validAvoirAchatItemsProduit(value: boolean) {
        this._validAvoirAchatItemsProduit = value;
    }
    get validAvoirAchatItemsMontantAvoir(): boolean {
        return this._validAvoirAchatItemsMontantAvoir;
    }
    set validAvoirAchatItemsMontantAvoir(value: boolean) {
        this._validAvoirAchatItemsMontantAvoir = value;
    }
    get validAvoirAchatItemsQuantite(): boolean {
        return this._validAvoirAchatItemsQuantite;
    }
    set validAvoirAchatItemsQuantite(value: boolean) {
        this._validAvoirAchatItemsQuantite = value;
    }
    get validAvoirAchatItemsDepot(): boolean {
        return this._validAvoirAchatItemsDepot;
    }
    set validAvoirAchatItemsDepot(value: boolean) {
        this._validAvoirAchatItemsDepot = value;
    }
}
