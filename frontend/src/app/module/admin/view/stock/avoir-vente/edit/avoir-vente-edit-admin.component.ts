import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteCriteria} from 'src/app/controller/criteria/stock/AvoirVenteCriteria.model';


import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';

@Component({
  selector: 'app-avoir-vente-edit-admin',
  templateUrl: './avoir-vente-edit-admin.component.html'
})
export class AvoirVenteEditAdminComponent extends AbstractEditController<AvoirVenteDto, AvoirVenteCriteria, AvoirVenteAdminService>   implements OnInit {

    private _avoirVenteItemsElement = new AvoirVenteItemDto();

    private _validAvoirVenteEntrepriseSociete = true;
    private _validAvoirVenteDateAvoir = true;
    private _validAvoirVenteMontant = true;
    private _validAvoirVenteVente = true;

    private _validEntrepriseSocieteNom = true;
    private _validVenteEntrepriseSociete = true;
    private _validVenteCodeVente = true;
    private _validVenteClient = true;
    private _validVenteMontantTtc = true;
    private _validAvoirVenteItemsProduit = true;
    private _validAvoirVenteItemsMontantAvoir = true;
    private _validAvoirVenteItemsQuantite = true;
    private _validAvoirVenteItemsDepot = true;



    constructor( private avoirVenteService: AvoirVenteAdminService , private depotService: DepotAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private produitService: ProduitAdminService, private avoirVenteItemService: AvoirVenteItemAdminService, private venteService: VenteAdminService) {
        super(avoirVenteService);
    }

    ngOnInit(): void {
        this.avoirVenteItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.avoirVenteItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);

        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.vente = new VenteDto();
        this.venteService.findAll().subscribe((data) => this.ventes = data);
    }
    public prepareEdit() {
        this.item.dateAvoir = this.avoirVenteService.format(this.item.dateAvoir);
    }



    public validateAvoirVenteItems(){
        this.errorMessages = new Array();
        this.validateAvoirVenteItemsProduit();
        this.validateAvoirVenteItemsMontantAvoir();
        this.validateAvoirVenteItemsQuantite();
        this.validateAvoirVenteItemsDepot();
    }
    public setValidation(value: boolean){
        this.validAvoirVenteEntrepriseSociete = value;
        this.validAvoirVenteDateAvoir = value;
        this.validAvoirVenteMontant = value;
        this.validAvoirVenteVente = value;
        this.validAvoirVenteItemsProduit = value;
        this.validAvoirVenteItemsMontantAvoir = value;
        this.validAvoirVenteItemsQuantite = value;
        this.validAvoirVenteItemsDepot = value;
        }
   public addAvoirVenteItems() {
        if( this.item.avoirVenteItems == null )
            this.item.avoirVenteItems = new Array<AvoirVenteItemDto>();
       this.validateAvoirVenteItems();
       if (this.errorMessages.length === 0) {
            if(this.avoirVenteItemsElement.id == null){
                this.item.avoirVenteItems.push(this.avoirVenteItemsElement);
            }else{
                const index = this.item.avoirVenteItems.findIndex(e => e.id == this.avoirVenteItemsElement.id);
                this.item.avoirVenteItems[index] = this.avoirVenteItemsElement;
            }
          this.avoirVenteItemsElement = new AvoirVenteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteAvoirVenteItems(p: AvoirVenteItemDto) {
        this.item.avoirVenteItems.forEach((element, index) => {
            if (element === p) { this.item.avoirVenteItems.splice(index, 1); }
        });
    }

    public editAvoirVenteItems(p: AvoirVenteItemDto) {
        this.avoirVenteItemsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateAvoirVenteEntrepriseSociete();
        this.validateAvoirVenteDateAvoir();
        this.validateAvoirVenteMontant();
        this.validateAvoirVenteVente();
    }
    public validateAvoirVenteEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
            this.errorMessages.push('Entreprise societe non valide');
            this.validAvoirVenteEntrepriseSociete = false;
        } else {
            this.validAvoirVenteEntrepriseSociete = true;
        }
    }
    public validateAvoirVenteDateAvoir(){
        if (this.stringUtilService.isEmpty(this.item.dateAvoir)) {
            this.errorMessages.push('Date avoir non valide');
            this.validAvoirVenteDateAvoir = false;
        } else {
            this.validAvoirVenteDateAvoir = true;
        }
    }
    public validateAvoirVenteMontant(){
        if (this.stringUtilService.isEmpty(this.item.montant)) {
            this.errorMessages.push('Montant non valide');
            this.validAvoirVenteMontant = false;
        } else {
            this.validAvoirVenteMontant = true;
        }
    }
    public validateAvoirVenteVente(){
        if (this.stringUtilService.isEmpty(this.item.vente)) {
            this.errorMessages.push('Vente non valide');
            this.validAvoirVenteVente = false;
        } else {
            this.validAvoirVenteVente = true;
        }
    }


    private validateAvoirVenteItemsProduit(){
        if (this.avoirVenteItemsElement.produit == null) {
        this.errorMessages.push('Produit de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsProduit = false;
        } else {
            this.validAvoirVenteItemsProduit = true;
        }
    }
    private validateAvoirVenteItemsMontantAvoir(){
        if (this.avoirVenteItemsElement.montantAvoir == null) {
        this.errorMessages.push('MontantAvoir de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsMontantAvoir = false;
        } else {
            this.validAvoirVenteItemsMontantAvoir = true;
        }
    }
    private validateAvoirVenteItemsQuantite(){
        if (this.avoirVenteItemsElement.quantite == null) {
        this.errorMessages.push('Quantite de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsQuantite = false;
        } else {
            this.validAvoirVenteItemsQuantite = true;
        }
    }
    private validateAvoirVenteItemsDepot(){
        if (this.avoirVenteItemsElement.depot == null) {
        this.errorMessages.push('Depot de la avoirVenteItem est  invalide');
            this.validAvoirVenteItemsDepot = false;
        } else {
            this.validAvoirVenteItemsDepot = true;
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

    get avoirVenteItemsElement(): AvoirVenteItemDto {
        if( this._avoirVenteItemsElement == null )
            this._avoirVenteItemsElement = new AvoirVenteItemDto();
         return this._avoirVenteItemsElement;
    }

    set avoirVenteItemsElement(value: AvoirVenteItemDto) {
        this._avoirVenteItemsElement = value;
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

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
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
    get validAvoirVenteItemsProduit(): boolean {
        return this._validAvoirVenteItemsProduit;
    }
    set validAvoirVenteItemsProduit(value: boolean) {
        this._validAvoirVenteItemsProduit = value;
    }
    get validAvoirVenteItemsMontantAvoir(): boolean {
        return this._validAvoirVenteItemsMontantAvoir;
    }
    set validAvoirVenteItemsMontantAvoir(value: boolean) {
        this._validAvoirVenteItemsMontantAvoir = value;
    }
    get validAvoirVenteItemsQuantite(): boolean {
        return this._validAvoirVenteItemsQuantite;
    }
    set validAvoirVenteItemsQuantite(value: boolean) {
        this._validAvoirVenteItemsQuantite = value;
    }
    get validAvoirVenteItemsDepot(): boolean {
        return this._validAvoirVenteItemsDepot;
    }
    set validAvoirVenteItemsDepot(value: boolean) {
        this._validAvoirVenteItemsDepot = value;
    }
}
