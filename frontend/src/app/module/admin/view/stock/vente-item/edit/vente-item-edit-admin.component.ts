import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {VenteItemAdminService} from 'src/app/controller/service/admin/stock/VenteItemAdmin.service';
import {VenteItemDto} from 'src/app/controller/model/stock/VenteItem.model';
import {VenteItemCriteria} from 'src/app/controller/criteria/stock/VenteItemCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {TauxTvaDto} from 'src/app/controller/model/stock/TauxTva.model';
import {TauxTvaAdminService} from 'src/app/controller/service/admin/stock/TauxTvaAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';

@Component({
  selector: 'app-vente-item-edit-admin',
  templateUrl: './vente-item-edit-admin.component.html'
})
export class VenteItemEditAdminComponent extends AbstractEditController<VenteItemDto, VenteItemCriteria, VenteItemAdminService>   implements OnInit {


    private _validVenteItemBarCode = true;
    private _validVenteItemProduit = true;
    private _validVenteItemQuantite = true;
    private _validVenteItemQuantiteVendue = true;
    private _validVenteItemRemise = true;
    private _validVenteItemPrixUnitaireTtc = true;
    private _validVenteItemMontantTtc = true;
    private _validVenteItemDepot = true;

    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitCategorie = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validTauxTvaLibelle = true;
    private _validTauxTvaMontant = true;
    private _validTauxTvaCode = true;
    private _validVenteEntrepriseSociete = true;
    private _validVenteCodeVente = true;
    private _validVenteClient = true;
    private _validVenteMontantTtc = true;
    private _validDepotLibelle = true;
    private _validDepotCode = true;



    constructor( private venteItemService: VenteItemAdminService , private depotService: DepotAdminService, private tauxTvaService: TauxTvaAdminService, private produitService: ProduitAdminService, private venteService: VenteAdminService) {
        super(venteItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.tauxTva = new TauxTvaDto();
        this.tauxTvaService.findAll().subscribe((data) => this.tauxTvas = data);
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
    }


    public setValidation(value: boolean){
        this.validVenteItemBarCode = value;
        this.validVenteItemProduit = value;
        this.validVenteItemQuantite = value;
        this.validVenteItemQuantiteVendue = value;
        this.validVenteItemRemise = value;
        this.validVenteItemPrixUnitaireTtc = value;
        this.validVenteItemMontantTtc = value;
        this.validVenteItemDepot = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateVenteItemBarCode();
        this.validateVenteItemProduit();
        this.validateVenteItemQuantite();
        this.validateVenteItemQuantiteVendue();
        this.validateVenteItemRemise();
        this.validateVenteItemPrixUnitaireTtc();
        this.validateVenteItemMontantTtc();
        this.validateVenteItemDepot();
    }
    public validateVenteItemBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
            this.errorMessages.push('Bar code non valide');
            this.validVenteItemBarCode = false;
        } else {
            this.validVenteItemBarCode = true;
        }
    }
    public validateVenteItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
            this.errorMessages.push('Produit non valide');
            this.validVenteItemProduit = false;
        } else {
            this.validVenteItemProduit = true;
        }
    }
    public validateVenteItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
            this.errorMessages.push('Quantite non valide');
            this.validVenteItemQuantite = false;
        } else {
            this.validVenteItemQuantite = true;
        }
    }
    public validateVenteItemQuantiteVendue(){
        if (this.stringUtilService.isEmpty(this.item.quantiteVendue)) {
            this.errorMessages.push('Quantite vendue non valide');
            this.validVenteItemQuantiteVendue = false;
        } else {
            this.validVenteItemQuantiteVendue = true;
        }
    }
    public validateVenteItemRemise(){
        if (this.stringUtilService.isEmpty(this.item.remise)) {
            this.errorMessages.push('Remise non valide');
            this.validVenteItemRemise = false;
        } else {
            this.validVenteItemRemise = true;
        }
    }
    public validateVenteItemPrixUnitaireTtc(){
        if (this.stringUtilService.isEmpty(this.item.prixUnitaireTtc)) {
            this.errorMessages.push('Prix unitaire ttc non valide');
            this.validVenteItemPrixUnitaireTtc = false;
        } else {
            this.validVenteItemPrixUnitaireTtc = true;
        }
    }
    public validateVenteItemMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
            this.errorMessages.push('Montant ttc non valide');
            this.validVenteItemMontantTtc = false;
        } else {
            this.validVenteItemMontantTtc = true;
        }
    }
    public validateVenteItemDepot(){
        if (this.stringUtilService.isEmpty(this.item.depot)) {
            this.errorMessages.push('Depot non valide');
            this.validVenteItemDepot = false;
        } else {
            this.validVenteItemDepot = true;
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
   public async openCreateTauxTva(tauxTva: string) {
        const isPermistted = await this.roleService.isPermitted('TauxTva', 'edit');
        if (isPermistted) {
             this.tauxTva = new TauxTvaDto();
             this.createTauxTvaDialog = true;
        }else {
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateVente(vente: string) {
        const isPermistted = await this.roleService.isPermitted('Vente', 'edit');
        if (isPermistted) {
             this.vente = new VenteDto();
             this.createVenteDialog = true;
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
   get tauxTva(): TauxTvaDto {
       return this.tauxTvaService.item;
   }
  set tauxTva(value: TauxTvaDto) {
        this.tauxTvaService.item = value;
   }
   get tauxTvas(): Array<TauxTvaDto> {
        return this.tauxTvaService.items;
   }
   set tauxTvas(value: Array<TauxTvaDto>) {
        this.tauxTvaService.items = value;
   }
   get createTauxTvaDialog(): boolean {
       return this.tauxTvaService.createDialog;
   }
  set createTauxTvaDialog(value: boolean) {
       this.tauxTvaService.createDialog= value;
   }
   get vente(): VenteDto {
       return this.venteService.item;
   }
  set vente(value: VenteDto) {
        this.venteService.item = value;
   }
   get ventes(): Array<VenteDto> {
        return this.venteService.items;
   }
   set ventes(value: Array<VenteDto>) {
        this.venteService.items = value;
   }
   get createVenteDialog(): boolean {
       return this.venteService.createDialog;
   }
  set createVenteDialog(value: boolean) {
       this.venteService.createDialog= value;
   }


    get validVenteItemBarCode(): boolean {
        return this._validVenteItemBarCode;
    }
    set validVenteItemBarCode(value: boolean) {
        this._validVenteItemBarCode = value;
    }
    get validVenteItemProduit(): boolean {
        return this._validVenteItemProduit;
    }
    set validVenteItemProduit(value: boolean) {
        this._validVenteItemProduit = value;
    }
    get validVenteItemQuantite(): boolean {
        return this._validVenteItemQuantite;
    }
    set validVenteItemQuantite(value: boolean) {
        this._validVenteItemQuantite = value;
    }
    get validVenteItemQuantiteVendue(): boolean {
        return this._validVenteItemQuantiteVendue;
    }
    set validVenteItemQuantiteVendue(value: boolean) {
        this._validVenteItemQuantiteVendue = value;
    }
    get validVenteItemRemise(): boolean {
        return this._validVenteItemRemise;
    }
    set validVenteItemRemise(value: boolean) {
        this._validVenteItemRemise = value;
    }
    get validVenteItemPrixUnitaireTtc(): boolean {
        return this._validVenteItemPrixUnitaireTtc;
    }
    set validVenteItemPrixUnitaireTtc(value: boolean) {
        this._validVenteItemPrixUnitaireTtc = value;
    }
    get validVenteItemMontantTtc(): boolean {
        return this._validVenteItemMontantTtc;
    }
    set validVenteItemMontantTtc(value: boolean) {
        this._validVenteItemMontantTtc = value;
    }
    get validVenteItemDepot(): boolean {
        return this._validVenteItemDepot;
    }
    set validVenteItemDepot(value: boolean) {
        this._validVenteItemDepot = value;
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
    get validVenteEntrepriseSociete(): boolean {
        return this._validVenteEntrepriseSociete;
    }
    set validVenteEntrepriseSociete(value: boolean) {
        this._validVenteEntrepriseSociete = value;
    }
    get validVenteCodeVente(): boolean {
        return this._validVenteCodeVente;
    }
    set validVenteCodeVente(value: boolean) {
        this._validVenteCodeVente = value;
    }
    get validVenteClient(): boolean {
        return this._validVenteClient;
    }
    set validVenteClient(value: boolean) {
        this._validVenteClient = value;
    }
    get validVenteMontantTtc(): boolean {
        return this._validVenteMontantTtc;
    }
    set validVenteMontantTtc(value: boolean) {
        this._validVenteMontantTtc = value;
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
