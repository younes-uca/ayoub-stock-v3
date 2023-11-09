import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitCriteria} from 'src/app/controller/criteria/stock/ProduitCriteria.model';
import {MarqueDto} from 'src/app/controller/model/commun/Marque.model';
import {MarqueAdminService} from 'src/app/controller/service/admin/commun/MarqueAdmin.service';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {CategorieDto} from 'src/app/controller/model/commun/Categorie.model';
import {CategorieAdminService} from 'src/app/controller/service/admin/commun/CategorieAdmin.service';
import {StockDto} from 'src/app/controller/model/stock/Stock.model';
import {StockAdminService} from 'src/app/controller/service/admin/stock/StockAdmin.service';
import {UniteMesureDto} from 'src/app/controller/model/commun/UniteMesure.model';
import {UniteMesureAdminService} from 'src/app/controller/service/admin/commun/UniteMesureAdmin.service';
import {EntrepriseSocieteDto} from 'src/app/controller/model/commun/EntrepriseSociete.model';
import {EntrepriseSocieteAdminService} from 'src/app/controller/service/admin/commun/EntrepriseSocieteAdmin.service';
@Component({
  selector: 'app-produit-create-admin',
  templateUrl: './produit-create-admin.component.html'
})
export class ProduitCreateAdminComponent extends AbstractCreateController<ProduitDto, ProduitCriteria, ProduitAdminService>  implements OnInit {

    private _stocksElement = new StockDto();


   private _validProduitReference = true;
   private _validProduitBarCode = true;
   private _validProduitCategorie = true;
   private _validProduitDesignation = true;
   private _validProduitQuantite = true;
    private _validEntrepriseSocieteNom = true;
    private _validCategorieLibelle = true;
    private _validCategorieCode = true;
    private _validMarqueLibelle = true;
    private _validMarqueCode = true;
    private _validUniteMesureLibelle = true;
    private _validUniteMesureCode = true;
    private _validStocksQuantite = true;

    constructor( private produitService: ProduitAdminService , private marqueService: MarqueAdminService, private depotService: DepotAdminService, private categorieService: CategorieAdminService, private stockService: StockAdminService, private uniteMesureService: UniteMesureAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService) {
        super(produitService);
    }

    ngOnInit(): void {
        this.stocksElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.entrepriseSociete = new EntrepriseSocieteDto();
        this.entrepriseSocieteService.findAll().subscribe((data) => this.entrepriseSocietes = data);
        this.categorie = new CategorieDto();
        this.categorieService.findAll().subscribe((data) => this.categories = data);
        this.marque = new MarqueDto();
        this.marqueService.findAll().subscribe((data) => this.marques = data);
        this.uniteMesure = new UniteMesureDto();
        this.uniteMesureService.findAll().subscribe((data) => this.uniteMesures = data);
    }



    validateStocks(){
        this.errorMessages = new Array();
        this.validateStocksQuantite();
    }


    public setValidation(value: boolean){
        this.validProduitReference = value;
        this.validProduitBarCode = value;
        this.validProduitCategorie = value;
        this.validProduitDesignation = value;
        this.validProduitQuantite = value;
        this.validStocksQuantite = value;
    }

    public addStocks() {
        if( this.item.stocks == null )
            this.item.stocks = new Array<StockDto>();
       this.validateStocks();
       if (this.errorMessages.length === 0) {
              this.item.stocks.push({... this.stocksElement});
              this.stocksElement = new StockDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletestocks(p: StockDto) {
        this.item.stocks.forEach((element, index) => {
            if (element === p) { this.item.stocks.splice(index, 1); }
        });
    }

    public editstocks(p: StockDto) {
        this.stocksElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateProduitReference();
        this.validateProduitBarCode();
        this.validateProduitCategorie();
        this.validateProduitDesignation();
        this.validateProduitQuantite();
    }

    public validateProduitReference(){
        if (this.stringUtilService.isEmpty(this.item.reference)) {
        this.errorMessages.push('Reference non valide');
        this.validProduitReference = false;
        } else {
            this.validProduitReference = true;
        }
    }
    public validateProduitBarCode(){
        if (this.stringUtilService.isEmpty(this.item.barCode)) {
        this.errorMessages.push('Bar code non valide');
        this.validProduitBarCode = false;
        } else {
            this.validProduitBarCode = true;
        }
    }
    public validateProduitCategorie(){
        if (this.stringUtilService.isEmpty(this.item.categorie)) {
        this.errorMessages.push('Categorie non valide');
        this.validProduitCategorie = false;
        } else {
            this.validProduitCategorie = true;
        }
    }
    public validateProduitDesignation(){
        if (this.stringUtilService.isEmpty(this.item.designation)) {
        this.errorMessages.push('Designation non valide');
        this.validProduitDesignation = false;
        } else {
            this.validProduitDesignation = true;
        }
    }
    public validateProduitQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
        this.errorMessages.push('Quantite non valide');
        this.validProduitQuantite = false;
        } else {
            this.validProduitQuantite = true;
        }
    }

    public validateStocksQuantite(){
        if (this.stocksElement.quantite == null) {
            this.errorMessages.push('Quantite de la stock est  invalide');
            this.validStocksQuantite = false;
        } else {
            this.validStocksQuantite = true;
        }
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
    get marque(): MarqueDto {
        return this.marqueService.item;
    }
    set marque(value: MarqueDto) {
        this.marqueService.item = value;
    }
    get marques(): Array<MarqueDto> {
        return this.marqueService.items;
    }
    set marques(value: Array<MarqueDto>) {
        this.marqueService.items = value;
    }
    get createMarqueDialog(): boolean {
       return this.marqueService.createDialog;
    }
    set createMarqueDialog(value: boolean) {
        this.marqueService.createDialog= value;
    }
    get uniteMesure(): UniteMesureDto {
        return this.uniteMesureService.item;
    }
    set uniteMesure(value: UniteMesureDto) {
        this.uniteMesureService.item = value;
    }
    get uniteMesures(): Array<UniteMesureDto> {
        return this.uniteMesureService.items;
    }
    set uniteMesures(value: Array<UniteMesureDto>) {
        this.uniteMesureService.items = value;
    }
    get createUniteMesureDialog(): boolean {
       return this.uniteMesureService.createDialog;
    }
    set createUniteMesureDialog(value: boolean) {
        this.uniteMesureService.createDialog= value;
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
    get categorie(): CategorieDto {
        return this.categorieService.item;
    }
    set categorie(value: CategorieDto) {
        this.categorieService.item = value;
    }
    get categories(): Array<CategorieDto> {
        return this.categorieService.items;
    }
    set categories(value: Array<CategorieDto>) {
        this.categorieService.items = value;
    }
    get createCategorieDialog(): boolean {
       return this.categorieService.createDialog;
    }
    set createCategorieDialog(value: boolean) {
        this.categorieService.createDialog= value;
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

    get validEntrepriseSocieteNom(): boolean {
        return this._validEntrepriseSocieteNom;
    }
    set validEntrepriseSocieteNom(value: boolean) {
        this._validEntrepriseSocieteNom = value;
    }
    get validCategorieLibelle(): boolean {
        return this._validCategorieLibelle;
    }
    set validCategorieLibelle(value: boolean) {
        this._validCategorieLibelle = value;
    }
    get validCategorieCode(): boolean {
        return this._validCategorieCode;
    }
    set validCategorieCode(value: boolean) {
        this._validCategorieCode = value;
    }
    get validMarqueLibelle(): boolean {
        return this._validMarqueLibelle;
    }
    set validMarqueLibelle(value: boolean) {
        this._validMarqueLibelle = value;
    }
    get validMarqueCode(): boolean {
        return this._validMarqueCode;
    }
    set validMarqueCode(value: boolean) {
        this._validMarqueCode = value;
    }
    get validUniteMesureLibelle(): boolean {
        return this._validUniteMesureLibelle;
    }
    set validUniteMesureLibelle(value: boolean) {
        this._validUniteMesureLibelle = value;
    }
    get validUniteMesureCode(): boolean {
        return this._validUniteMesureCode;
    }
    set validUniteMesureCode(value: boolean) {
        this._validUniteMesureCode = value;
    }
    get validStocksQuantite(): boolean {
        return this._validStocksQuantite;
    }
    set validStocksQuantite(value: boolean) {
        this._validStocksQuantite = value;
    }

    get stocksElement(): StockDto {
        if( this._stocksElement == null )
            this._stocksElement = new StockDto();
        return this._stocksElement;
    }

    set stocksElement(value: StockDto) {
        this._stocksElement = value;
    }

}
