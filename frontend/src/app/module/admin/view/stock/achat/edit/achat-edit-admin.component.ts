import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AchatAdminService} from 'src/app/controller/service/admin/stock/AchatAdmin.service';
import {AchatDto} from 'src/app/controller/model/stock/Achat.model';
import {AchatCriteria} from 'src/app/controller/criteria/stock/AchatCriteria.model';


import {EtatAchatDto} from 'src/app/controller/model/commun/EtatAchat.model';
import {EtatAchatAdminService} from 'src/app/controller/service/admin/commun/EtatAchatAdmin.service';
import {AvoirAchatDto} from 'src/app/controller/model/stock/AvoirAchat.model';
import {AvoirAchatAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {AchatItemDto} from 'src/app/controller/model/stock/AchatItem.model';
import {AchatItemAdminService} from 'src/app/controller/service/admin/stock/AchatItemAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirAchatItemDto} from 'src/app/controller/model/stock/AvoirAchatItem.model';
import {AvoirAchatItemAdminService} from 'src/app/controller/service/admin/stock/AvoirAchatItemAdmin.service';

@Component({
  selector: 'app-achat-edit-admin',
  templateUrl: './achat-edit-admin.component.html'
})
export class AchatEditAdminComponent extends AbstractEditController<AchatDto, AchatCriteria, AchatAdminService>   implements OnInit {

    private _achatItemsElement = new AchatItemDto();
    private _avoirsElement = new AvoirAchatDto();

    private _validAchatDateFacture = true;
    private _validAchatFournisseur = true;

    private _validEntrepriseSocieteNom = true;
    private _validFournisseurNom = true;
    private _validFournisseurIce = true;
    private _validEtatAchatLibelle = true;
    private _validEtatAchatCode = true;
    private _validAchatItemsBarCode = true;
    private _validAchatItemsFooterBarCode = true;
    private _validAchatItemsQuantite = true;
    private _validAchatItemsRemise = true;
    private _validAchatItemsPrixUnitaireTtc = true;
    private _validAvoirsEntrepriseSociete = true;
    private _validAvoirsDateAvoir = true;
    private _validAvoirsMontant = true;
    private _validAvoirsAchat = true;



    constructor( private achatService: AchatAdminService , private depotService: DepotAdminService, private etatAchatService: EtatAchatAdminService, private achatItemService: AchatItemAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private produitService: ProduitAdminService, private avoirAchatService: AvoirAchatAdminService, private fournisseurService: FournisseurAdminService) {
        super(achatService);
    }

    ngOnInit(): void {
        this.achatItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.achatItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);

        this.avoirsElement.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);

        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
        this.etatAchat = new EtatAchatDto();
        this.etatAchatService.findAll().subscribe((data) => this.etatAchats = data);
    }
    public prepareEdit() {
        this.item.dateFacture = this.achatService.format(this.item.dateFacture);
    }



    public validateAchatItems(){
        this.errorMessages = new Array();
        this.validateAchatItemsBarCode();
        this.validateAchatItemsFooterBarCode();
        this.validateAchatItemsQuantite();
        this.validateAchatItemsRemise();
        this.validateAchatItemsPrixUnitaireTtc();
    }
    public validateAvoirs(){
        this.errorMessages = new Array();
        this.validateAvoirsEntrepriseSociete();
        this.validateAvoirsDateAvoir();
        this.validateAvoirsMontant();
        this.validateAvoirsAchat();
    }
    public setValidation(value: boolean){
        this.validAchatDateFacture = value;
        this.validAchatFournisseur = value;
        this.validAchatItemsBarCode = value;
        this.validAchatItemsFooterBarCode = value;
        this.validAchatItemsQuantite = value;
        this.validAchatItemsRemise = value;
        this.validAchatItemsPrixUnitaireTtc = value;
        this.validAvoirsEntrepriseSociete = value;
        this.validAvoirsDateAvoir = value;
        this.validAvoirsMontant = value;
        this.validAvoirsAchat = value;
        }
   public addAchatItems() {
        if( this.item.achatItems == null )
            this.item.achatItems = new Array<AchatItemDto>();
       this.validateAchatItems();
       if (this.errorMessages.length === 0) {
            if(this.achatItemsElement.id == null){
                this.item.achatItems.push(this.achatItemsElement);
            }else{
                const index = this.item.achatItems.findIndex(e => e.id == this.achatItemsElement.id);
                this.item.achatItems[index] = this.achatItemsElement;
            }
          this.achatItemsElement = new AchatItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAchatItems(p: AchatItemDto) {
        this.item.achatItems.forEach((element, index) => {
            if (element === p) { this.item.achatItems.splice(index, 1); }
        });
    }

    public editAchatItems(p: AchatItemDto) {
        this.achatItemsElement = {... p};
        this.activeTab = 0;
    }
   public addAvoirs() {
        if( this.item.avoirs == null )
            this.item.avoirs = new Array<AvoirAchatDto>();
       this.validateAvoirs();
       if (this.errorMessages.length === 0) {
            if(this.avoirsElement.id == null){
                this.item.avoirs.push(this.avoirsElement);
            }else{
                const index = this.item.avoirs.findIndex(e => e.id == this.avoirsElement.id);
                this.item.avoirs[index] = this.avoirsElement;
            }
          this.avoirsElement = new AvoirAchatDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirs(p: AvoirAchatDto) {
        this.item.avoirs.forEach((element, index) => {
            if (element === p) { this.item.avoirs.splice(index, 1); }
        });
    }

    public editAvoirs(p: AvoirAchatDto) {
        this.avoirsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAchatDateFacture();
        this.validateAchatFournisseur();
    }
    public validateAchatDateFacture(){
        if (this.stringUtilService.isEmpty(this.item.dateFacture)) {
            this.errorMessages.push('Date facture non valide');
            this.validAchatDateFacture = false;
        } else {
            this.validAchatDateFacture = true;
        }
    }
    public validateAchatFournisseur(){
        if (this.stringUtilService.isEmpty(this.item.fournisseur)) {
            this.errorMessages.push('Fournisseur non valide');
            this.validAchatFournisseur = false;
        } else {
            this.validAchatFournisseur = true;
        }
    }


    private validateAchatItemsBarCode(){
        if (this.achatItemsElement.barCode == null) {
        this.errorMessages.push('BarCode de la achatItem est  invalide');
            this.validAchatItemsBarCode = false;
        } else {
            this.validAchatItemsBarCode = true;
        }
    }
    private validateAchatItemsFooterBarCode(){
        if (this.achatItemsElement.footerBarCode == null) {
        this.errorMessages.push('FooterBarCode de la achatItem est  invalide');
            this.validAchatItemsFooterBarCode = false;
        } else {
            this.validAchatItemsFooterBarCode = true;
        }
    }
    private validateAchatItemsQuantite(){
        if (this.achatItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la achatItem est  invalide');
            this.validAchatItemsQuantite = false;
        } else {
            this.validAchatItemsQuantite = true;
        }
    }
    private validateAchatItemsRemise(){
        if (this.achatItemsElement.remise == null) {
        this.errorMessages.push('Remise de la achatItem est  invalide');
            this.validAchatItemsRemise = false;
        } else {
            this.validAchatItemsRemise = true;
        }
    }
    private validateAchatItemsPrixUnitaireTtc(){
        if (this.achatItemsElement.prixUnitaireTtc == null) {
        this.errorMessages.push('PrixUnitaireTtc de la achatItem est  invalide');
            this.validAchatItemsPrixUnitaireTtc = false;
        } else {
            this.validAchatItemsPrixUnitaireTtc = true;
        }
    }
    private validateAvoirsEntrepriseSociete(){
        if (this.avoirsElement.entrepriseSociete == null) {
        this.errorMessages.push('EntrepriseSociete de la avoirAchat est  invalide');
            this.validAvoirsEntrepriseSociete = false;
        } else {
            this.validAvoirsEntrepriseSociete = true;
        }
    }
    private validateAvoirsDateAvoir(){
        if (this.avoirsElement.dateAvoir == null) {
        this.errorMessages.push('DateAvoir de la avoirAchat est  invalide');
            this.validAvoirsDateAvoir = false;
        } else {
            this.validAvoirsDateAvoir = true;
        }
    }
    private validateAvoirsMontant(){
        if (this.avoirsElement.montant == null) {
        this.errorMessages.push('Montant de la avoirAchat est  invalide');
            this.validAvoirsMontant = false;
        } else {
            this.validAvoirsMontant = true;
        }
    }
    private validateAvoirsAchat(){
        if (this.avoirsElement.achat == null) {
        this.errorMessages.push('Achat de la avoirAchat est  invalide');
            this.validAvoirsAchat = false;
        } else {
            this.validAvoirsAchat = true;
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
   get etatAchat(): EtatAchatDto {
       return this.etatAchatService.item;
   }
  set etatAchat(value: EtatAchatDto) {
        this.etatAchatService.item = value;
   }
   get etatAchats(): Array<EtatAchatDto> {
        return this.etatAchatService.items;
   }
   set etatAchats(value: Array<EtatAchatDto>) {
        this.etatAchatService.items = value;
   }
   get createEtatAchatDialog(): boolean {
       return this.etatAchatService.createDialog;
   }
  set createEtatAchatDialog(value: boolean) {
       this.etatAchatService.createDialog= value;
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
   get fournisseur(): FournisseurDto {
       return this.fournisseurService.item;
   }
  set fournisseur(value: FournisseurDto) {
        this.fournisseurService.item = value;
   }
   get fournisseurs(): Array<FournisseurDto> {
        return this.fournisseurService.items;
   }
   set fournisseurs(value: Array<FournisseurDto>) {
        this.fournisseurService.items = value;
   }
   get createFournisseurDialog(): boolean {
       return this.fournisseurService.createDialog;
   }
  set createFournisseurDialog(value: boolean) {
       this.fournisseurService.createDialog= value;
   }

    get achatItemsElement(): AchatItemDto {
        if( this._achatItemsElement == null )
            this._achatItemsElement = new AchatItemDto();
         return this._achatItemsElement;
    }

    set achatItemsElement(value: AchatItemDto) {
        this._achatItemsElement = value;
    }
    get avoirsElement(): AvoirAchatDto {
        if( this._avoirsElement == null )
            this._avoirsElement = new AvoirAchatDto();
         return this._avoirsElement;
    }

    set avoirsElement(value: AvoirAchatDto) {
        this._avoirsElement = value;
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

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
    }
    get validFournisseurNom(): boolean {
        return this._validFournisseurNom;
    }
    set validFournisseurNom(value: boolean) {
        this._validFournisseurNom = value;
    }
    get validFournisseurIce(): boolean {
        return this._validFournisseurIce;
    }
    set validFournisseurIce(value: boolean) {
        this._validFournisseurIce = value;
    }
    get validEtatAchatLibelle(): boolean {
        return this._validEtatAchatLibelle;
    }
    set validEtatAchatLibelle(value: boolean) {
        this._validEtatAchatLibelle = value;
    }
    get validEtatAchatCode(): boolean {
        return this._validEtatAchatCode;
    }
    set validEtatAchatCode(value: boolean) {
        this._validEtatAchatCode = value;
    }
    get validAchatItemsBarCode(): boolean {
        return this._validAchatItemsBarCode;
    }
    set validAchatItemsBarCode(value: boolean) {
        this._validAchatItemsBarCode = value;
    }
    get validAchatItemsFooterBarCode(): boolean {
        return this._validAchatItemsFooterBarCode;
    }
    set validAchatItemsFooterBarCode(value: boolean) {
        this._validAchatItemsFooterBarCode = value;
    }
    get validAchatItemsQuantite(): boolean {
        return this._validAchatItemsQuantite;
    }
    set validAchatItemsQuantite(value: boolean) {
        this._validAchatItemsQuantite = value;
    }
    get validAchatItemsRemise(): boolean {
        return this._validAchatItemsRemise;
    }
    set validAchatItemsRemise(value: boolean) {
        this._validAchatItemsRemise = value;
    }
    get validAchatItemsPrixUnitaireTtc(): boolean {
        return this._validAchatItemsPrixUnitaireTtc;
    }
    set validAchatItemsPrixUnitaireTtc(value: boolean) {
        this._validAchatItemsPrixUnitaireTtc = value;
    }
    get validAvoirsEntrepriseSociete(): boolean {
        return this._validAvoirsEntrepriseSociete;
    }
    set validAvoirsEntrepriseSociete(value: boolean) {
        this._validAvoirsEntrepriseSociete = value;
    }
    get validAvoirsDateAvoir(): boolean {
        return this._validAvoirsDateAvoir;
    }
    set validAvoirsDateAvoir(value: boolean) {
        this._validAvoirsDateAvoir = value;
    }
    get validAvoirsMontant(): boolean {
        return this._validAvoirsMontant;
    }
    set validAvoirsMontant(value: boolean) {
        this._validAvoirsMontant = value;
    }
    get validAvoirsAchat(): boolean {
        return this._validAvoirsAchat;
    }
    set validAvoirsAchat(value: boolean) {
        this._validAvoirsAchat = value;
    }
}
