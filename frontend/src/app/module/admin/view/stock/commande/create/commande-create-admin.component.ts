import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CommandeAdminService} from 'src/app/controller/service/admin/stock/CommandeAdmin.service';
import {CommandeDto} from 'src/app/controller/model/stock/Commande.model';
import {CommandeCriteria} from 'src/app/controller/criteria/stock/CommandeCriteria.model';
import {EtatCommandeDto} from 'src/app/controller/model/commun/EtatCommande.model';
import {EtatCommandeAdminService} from 'src/app/controller/service/admin/commun/EtatCommandeAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {CommandeItemDto} from 'src/app/controller/model/stock/CommandeItem.model';
import {CommandeItemAdminService} from 'src/app/controller/service/admin/stock/CommandeItemAdmin.service';
import {FournisseurDto} from 'src/app/controller/model/commun/Fournisseur.model';
import {FournisseurAdminService} from 'src/app/controller/service/admin/commun/FournisseurAdmin.service';
@Component({
  selector: 'app-commande-create-admin',
  templateUrl: './commande-create-admin.component.html'
})
export class CommandeCreateAdminComponent extends AbstractCreateController<CommandeDto, CommandeCriteria, CommandeAdminService>  implements OnInit {

    private _commandeItemsElement = new CommandeItemDto();


    private _validEntrepriseSocieteNom = true;
    private _validFournisseurNom = true;
    private _validFournisseurIce = true;
    private _validEtatCommandeLibelle = true;
    private _validEtatCommandeCode = true;
    private _validCommandeItemsProduit = true;
    private _validCommandeItemsQuantite = true;

    constructor( private commandeService: CommandeAdminService , private etatCommandeService: EtatCommandeAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private produitService: ProduitAdminService, private commandeItemService: CommandeItemAdminService, private fournisseurService: FournisseurAdminService) {
        super(commandeService);
    }

    ngOnInit(): void {
        this.commandeItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.fournisseur = new FournisseurDto();
        this.fournisseurService.findAll().subscribe((data) => this.fournisseurs = data);
        this.etatCommande = new EtatCommandeDto();
        this.etatCommandeService.findAll().subscribe((data) => this.etatCommandes = data);
    }



    validateCommandeItems(){
        this.errorMessages = new Array();
        this.validateCommandeItemsProduit();
        this.validateCommandeItemsQuantite();
    }


    public setValidation(value: boolean){
        this.validCommandeItemsProduit = value;
        this.validCommandeItemsQuantite = value;
    }

    public addCommandeItems() {
        if( this.item.commandeItems == null )
            this.item.commandeItems = new Array<CommandeItemDto>();
       this.validateCommandeItems();
       if (this.errorMessages.length === 0) {
              this.item.commandeItems.push({... this.commandeItemsElement});
              this.commandeItemsElement = new CommandeItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletecommandeItems(p: CommandeItemDto) {
        this.item.commandeItems.forEach((element, index) => {
            if (element === p) { this.item.commandeItems.splice(index, 1); }
        });
    }

    public editcommandeItems(p: CommandeItemDto) {
        this.commandeItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }


    public validateCommandeItemsProduit(){
        if (this.commandeItemsElement.produit == null) {
            this.errorMessages.push('Produit de la commandeItem est  invalide');
            this.validCommandeItemsProduit = false;
        } else {
            this.validCommandeItemsProduit = true;
        }
    }
    public validateCommandeItemsQuantite(){
        if (this.commandeItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la commandeItem est  invalide');
            this.validCommandeItemsQuantite = false;
        } else {
            this.validCommandeItemsQuantite = true;
        }
    }

    public async openCreateProduit(produit: string) {
    const isPermistted = await this.roleService.isPermitted('Produit', 'add');
    if(isPermistted) {
         this.produit = new ProduitDto();
         this.createProduitDialog = true;
    }else{
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
    get etatCommande(): EtatCommandeDto {
        return this.etatCommandeService.item;
    }
    set etatCommande(value: EtatCommandeDto) {
        this.etatCommandeService.item = value;
    }
    get etatCommandes(): Array<EtatCommandeDto> {
        return this.etatCommandeService.items;
    }
    set etatCommandes(value: Array<EtatCommandeDto>) {
        this.etatCommandeService.items = value;
    }
    get createEtatCommandeDialog(): boolean {
       return this.etatCommandeService.createDialog;
    }
    set createEtatCommandeDialog(value: boolean) {
        this.etatCommandeService.createDialog= value;
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
    get validEtatCommandeLibelle(): boolean {
        return this._validEtatCommandeLibelle;
    }
    set validEtatCommandeLibelle(value: boolean) {
        this._validEtatCommandeLibelle = value;
    }
    get validEtatCommandeCode(): boolean {
        return this._validEtatCommandeCode;
    }
    set validEtatCommandeCode(value: boolean) {
        this._validEtatCommandeCode = value;
    }
    get validCommandeItemsProduit(): boolean {
        return this._validCommandeItemsProduit;
    }
    set validCommandeItemsProduit(value: boolean) {
        this._validCommandeItemsProduit = value;
    }
    get validCommandeItemsQuantite(): boolean {
        return this._validCommandeItemsQuantite;
    }
    set validCommandeItemsQuantite(value: boolean) {
        this._validCommandeItemsQuantite = value;
    }

    get commandeItemsElement(): CommandeItemDto {
        if( this._commandeItemsElement == null )
            this._commandeItemsElement = new CommandeItemDto();
        return this._commandeItemsElement;
    }

    set commandeItemsElement(value: CommandeItemDto) {
        this._commandeItemsElement = value;
    }

}
