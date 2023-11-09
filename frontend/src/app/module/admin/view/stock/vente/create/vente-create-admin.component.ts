import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/stock/VenteCriteria.model';
import {TauxTvaDto} from 'src/app/controller/model/stock/TauxTva.model';
import {TauxTvaAdminService} from 'src/app/controller/service/admin/stock/TauxTvaAdmin.service';
import {VenteItemDto} from 'src/app/controller/model/stock/VenteItem.model';
import {VenteItemAdminService} from 'src/app/controller/service/admin/stock/VenteItemAdmin.service';
import {ClientDto} from 'src/app/controller/model/commun/Client.model';
import {ClientAdminService} from 'src/app/controller/service/admin/commun/ClientAdmin.service';
import {AvoirVenteItemDto} from 'src/app/controller/model/stock/AvoirVenteItem.model';
import {AvoirVenteItemAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteItemAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
import {EtatVenteDto} from 'src/app/controller/model/commun/EtatVente.model';
import {EtatVenteAdminService} from 'src/app/controller/service/admin/commun/EtatVenteAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
@Component({
  selector: 'app-vente-create-admin',
  templateUrl: './vente-create-admin.component.html'
})
export class VenteCreateAdminComponent extends AbstractCreateController<VenteDto, VenteCriteria, VenteAdminService>  implements OnInit {

    private _venteItemsElement = new VenteItemDto();
    private _avoirsElement = new AvoirVenteDto();


   private _validVenteEntrepriseSociete = true;
   private _validVenteCodeVente = true;
   private _validVenteClient = true;
   private _validVenteMontantTtc = true;
    private _validEntrepriseSocieteNom = true;
    private _validClientCin = true;
    private _validClientNom = true;
    private _validClientPrenom = true;
    private _validClientTelephone = true;
    private _validEtatVenteLibelle = true;
    private _validEtatVenteCode = true;
    private _validVenteItemsBarCode = true;
    private _validVenteItemsProduit = true;
    private _validVenteItemsQuantite = true;
    private _validVenteItemsQuantiteVendue = true;
    private _validVenteItemsRemise = true;
    private _validVenteItemsPrixUnitaireTtc = true;
    private _validVenteItemsMontantTtc = true;
    private _validVenteItemsDepot = true;
    private _validAvoirsEntrepriseSociete = true;
    private _validAvoirsDateAvoir = true;
    private _validAvoirsMontant = true;
    private _validAvoirsVente = true;

    constructor( private venteService: VenteAdminService , private depotService: DepotAdminService, private tauxTvaService: TauxTvaAdminService, private venteItemService: VenteItemAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private etatVenteService: EtatVenteAdminService, private produitService: ProduitAdminService, private clientService: ClientAdminService, private avoirVenteService: AvoirVenteAdminService) {
        super(venteService);
    }

    ngOnInit(): void {
        this.venteItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.venteItemsElement.tauxTva = new TauxTvaDto();
        this.tauxTvaService.findAll().subscribe((data) => this.tauxTvas = data);
        this.venteItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.avoirsElement.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.etatVente = new EtatVenteDto();
        this.etatVenteService.findAll().subscribe((data) => this.etatVentes = data);
    }



    validateVenteItems(){
        this.errorMessages = new Array();
        this.validateVenteItemsBarCode();
        this.validateVenteItemsProduit();
        this.validateVenteItemsQuantite();
        this.validateVenteItemsQuantiteVendue();
        this.validateVenteItemsRemise();
        this.validateVenteItemsPrixUnitaireTtc();
        this.validateVenteItemsMontantTtc();
        this.validateVenteItemsDepot();
    }
    validateAvoirs(){
        this.errorMessages = new Array();
        this.validateAvoirsEntrepriseSociete();
        this.validateAvoirsDateAvoir();
        this.validateAvoirsMontant();
        this.validateAvoirsVente();
    }


    public setValidation(value: boolean){
        this.validVenteEntrepriseSociete = value;
        this.validVenteCodeVente = value;
        this.validVenteClient = value;
        this.validVenteMontantTtc = value;
        this.validVenteItemsBarCode = value;
        this.validVenteItemsProduit = value;
        this.validVenteItemsQuantite = value;
        this.validVenteItemsQuantiteVendue = value;
        this.validVenteItemsRemise = value;
        this.validVenteItemsPrixUnitaireTtc = value;
        this.validVenteItemsMontantTtc = value;
        this.validVenteItemsDepot = value;
        this.validAvoirsEntrepriseSociete = value;
        this.validAvoirsDateAvoir = value;
        this.validAvoirsMontant = value;
        this.validAvoirsVente = value;
    }

    public addVenteItems() {
        if( this.item.venteItems == null )
            this.item.venteItems = new Array<VenteItemDto>();
       this.validateVenteItems();
       if (this.errorMessages.length === 0) {
              this.item.venteItems.push({... this.venteItemsElement});
              this.venteItemsElement = new VenteItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteventeItems(p: VenteItemDto) {
        this.item.venteItems.forEach((element, index) => {
            if (element === p) { this.item.venteItems.splice(index, 1); }
        });
    }

    public editventeItems(p: VenteItemDto) {
        this.venteItemsElement = {... p};
        this.activeTab = 0;
    }
    public addAvoirs() {
        if( this.item.avoirs == null )
            this.item.avoirs = new Array<AvoirVenteDto>();
       this.validateAvoirs();
       if (this.errorMessages.length === 0) {
              this.item.avoirs.push({... this.avoirsElement});
              this.avoirsElement = new AvoirVenteDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deleteavoirs(p: AvoirVenteDto) {
        this.item.avoirs.forEach((element, index) => {
            if (element === p) { this.item.avoirs.splice(index, 1); }
        });
    }

    public editavoirs(p: AvoirVenteDto) {
        this.avoirsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateVenteEntrepriseSociete();
        this.validateVenteCodeVente();
        this.validateVenteClient();
        this.validateVenteMontantTtc();
    }

    public validateVenteEntrepriseSociete(){
        if (this.stringUtilService.isEmpty(this.item.entrepriseSociete)) {
        this.errorMessages.push('Entreprise societe non valide');
        this.validVenteEntrepriseSociete = false;
        } else {
            this.validVenteEntrepriseSociete = true;
        }
    }
    public validateVenteCodeVente(){
        if (this.stringUtilService.isEmpty(this.item.codeVente)) {
        this.errorMessages.push('Code vente non valide');
        this.validVenteCodeVente = false;
        } else {
            this.validVenteCodeVente = true;
        }
    }
    public validateVenteClient(){
        if (this.stringUtilService.isEmpty(this.item.client)) {
        this.errorMessages.push('Client non valide');
        this.validVenteClient = false;
        } else {
            this.validVenteClient = true;
        }
    }
    public validateVenteMontantTtc(){
        if (this.stringUtilService.isEmpty(this.item.montantTtc)) {
        this.errorMessages.push('Montant ttc non valide');
        this.validVenteMontantTtc = false;
        } else {
            this.validVenteMontantTtc = true;
        }
    }

    public validateVenteItemsBarCode(){
        if (this.venteItemsElement.barCode == null) {
            this.errorMessages.push('BarCode de la venteItem est  invalide');
            this.validVenteItemsBarCode = false;
        } else {
            this.validVenteItemsBarCode = true;
        }
    }
    public validateVenteItemsProduit(){
        if (this.venteItemsElement.produit == null) {
            this.errorMessages.push('Produit de la venteItem est  invalide');
            this.validVenteItemsProduit = false;
        } else {
            this.validVenteItemsProduit = true;
        }
    }
    public validateVenteItemsQuantite(){
        if (this.venteItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la venteItem est  invalide');
            this.validVenteItemsQuantite = false;
        } else {
            this.validVenteItemsQuantite = true;
        }
    }
    public validateVenteItemsQuantiteVendue(){
        if (this.venteItemsElement.quantiteVendue == null) {
            this.errorMessages.push('QuantiteVendue de la venteItem est  invalide');
            this.validVenteItemsQuantiteVendue = false;
        } else {
            this.validVenteItemsQuantiteVendue = true;
        }
    }
    public validateVenteItemsRemise(){
        if (this.venteItemsElement.remise == null) {
            this.errorMessages.push('Remise de la venteItem est  invalide');
            this.validVenteItemsRemise = false;
        } else {
            this.validVenteItemsRemise = true;
        }
    }
    public validateVenteItemsPrixUnitaireTtc(){
        if (this.venteItemsElement.prixUnitaireTtc == null) {
            this.errorMessages.push('PrixUnitaireTtc de la venteItem est  invalide');
            this.validVenteItemsPrixUnitaireTtc = false;
        } else {
            this.validVenteItemsPrixUnitaireTtc = true;
        }
    }
    public validateVenteItemsMontantTtc(){
        if (this.venteItemsElement.montantTtc == null) {
            this.errorMessages.push('MontantTtc de la venteItem est  invalide');
            this.validVenteItemsMontantTtc = false;
        } else {
            this.validVenteItemsMontantTtc = true;
        }
    }
    public validateVenteItemsDepot(){
        if (this.venteItemsElement.depot == null) {
            this.errorMessages.push('Depot de la venteItem est  invalide');
            this.validVenteItemsDepot = false;
        } else {
            this.validVenteItemsDepot = true;
        }
    }
    public validateAvoirsEntrepriseSociete(){
        if (this.avoirsElement.entrepriseSociete == null) {
            this.errorMessages.push('EntrepriseSociete de la avoirVente est  invalide');
            this.validAvoirsEntrepriseSociete = false;
        } else {
            this.validAvoirsEntrepriseSociete = true;
        }
    }
    public validateAvoirsDateAvoir(){
        if (this.avoirsElement.dateAvoir == null) {
            this.errorMessages.push('DateAvoir de la avoirVente est  invalide');
            this.validAvoirsDateAvoir = false;
        } else {
            this.validAvoirsDateAvoir = true;
        }
    }
    public validateAvoirsMontant(){
        if (this.avoirsElement.montant == null) {
            this.errorMessages.push('Montant de la avoirVente est  invalide');
            this.validAvoirsMontant = false;
        } else {
            this.validAvoirsMontant = true;
        }
    }
    public validateAvoirsVente(){
        if (this.avoirsElement.vente == null) {
            this.errorMessages.push('Vente de la avoirVente est  invalide');
            this.validAvoirsVente = false;
        } else {
            this.validAvoirsVente = true;
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
    public async openCreateTauxTva(tauxTva: string) {
    const isPermistted = await this.roleService.isPermitted('TauxTva', 'add');
    if(isPermistted) {
         this.tauxTva = new TauxTvaDto();
         this.createTauxTvaDialog = true;
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
    get client(): ClientDto {
        return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients(): Array<ClientDto> {
        return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get createClientDialog(): boolean {
       return this.clientService.createDialog;
    }
    set createClientDialog(value: boolean) {
        this.clientService.createDialog= value;
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
    get etatVente(): EtatVenteDto {
        return this.etatVenteService.item;
    }
    set etatVente(value: EtatVenteDto) {
        this.etatVenteService.item = value;
    }
    get etatVentes(): Array<EtatVenteDto> {
        return this.etatVenteService.items;
    }
    set etatVentes(value: Array<EtatVenteDto>) {
        this.etatVenteService.items = value;
    }
    get createEtatVenteDialog(): boolean {
       return this.etatVenteService.createDialog;
    }
    set createEtatVenteDialog(value: boolean) {
        this.etatVenteService.createDialog= value;
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

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
    }
    get validClientCin(): boolean {
        return this._validClientCin;
    }
    set validClientCin(value: boolean) {
        this._validClientCin = value;
    }
    get validClientNom(): boolean {
        return this._validClientNom;
    }
    set validClientNom(value: boolean) {
        this._validClientNom = value;
    }
    get validClientPrenom(): boolean {
        return this._validClientPrenom;
    }
    set validClientPrenom(value: boolean) {
        this._validClientPrenom = value;
    }
    get validClientTelephone(): boolean {
        return this._validClientTelephone;
    }
    set validClientTelephone(value: boolean) {
        this._validClientTelephone = value;
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
    get validVenteItemsBarCode(): boolean {
        return this._validVenteItemsBarCode;
    }
    set validVenteItemsBarCode(value: boolean) {
        this._validVenteItemsBarCode = value;
    }
    get validVenteItemsProduit(): boolean {
        return this._validVenteItemsProduit;
    }
    set validVenteItemsProduit(value: boolean) {
        this._validVenteItemsProduit = value;
    }
    get validVenteItemsQuantite(): boolean {
        return this._validVenteItemsQuantite;
    }
    set validVenteItemsQuantite(value: boolean) {
        this._validVenteItemsQuantite = value;
    }
    get validVenteItemsQuantiteVendue(): boolean {
        return this._validVenteItemsQuantiteVendue;
    }
    set validVenteItemsQuantiteVendue(value: boolean) {
        this._validVenteItemsQuantiteVendue = value;
    }
    get validVenteItemsRemise(): boolean {
        return this._validVenteItemsRemise;
    }
    set validVenteItemsRemise(value: boolean) {
        this._validVenteItemsRemise = value;
    }
    get validVenteItemsPrixUnitaireTtc(): boolean {
        return this._validVenteItemsPrixUnitaireTtc;
    }
    set validVenteItemsPrixUnitaireTtc(value: boolean) {
        this._validVenteItemsPrixUnitaireTtc = value;
    }
    get validVenteItemsMontantTtc(): boolean {
        return this._validVenteItemsMontantTtc;
    }
    set validVenteItemsMontantTtc(value: boolean) {
        this._validVenteItemsMontantTtc = value;
    }
    get validVenteItemsDepot(): boolean {
        return this._validVenteItemsDepot;
    }
    set validVenteItemsDepot(value: boolean) {
        this._validVenteItemsDepot = value;
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
    get validAvoirsVente(): boolean {
        return this._validAvoirsVente;
    }
    set validAvoirsVente(value: boolean) {
        this._validAvoirsVente = value;
    }

    get venteItemsElement(): VenteItemDto {
        if( this._venteItemsElement == null )
            this._venteItemsElement = new VenteItemDto();
        return this._venteItemsElement;
    }

    set venteItemsElement(value: VenteItemDto) {
        this._venteItemsElement = value;
    }
    get avoirsElement(): AvoirVenteDto {
        if( this._avoirsElement == null )
            this._avoirsElement = new AvoirVenteDto();
        return this._avoirsElement;
    }

    set avoirsElement(value: AvoirVenteDto) {
        this._avoirsElement = value;
    }

}
