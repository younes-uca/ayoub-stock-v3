import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PermutationAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationAdmin.service';
import {PermutationDto} from 'src/app/controller/model/gestionchequeffet/Permutation.model';
import {PermutationCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationCriteria.model';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
import {PermutationItemDto} from 'src/app/controller/model/gestionchequeffet/PermutationItem.model';
import {PermutationItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationItemAdmin.service';
@Component({
  selector: 'app-permutation-create-admin',
  templateUrl: './permutation-create-admin.component.html'
})
export class PermutationCreateAdminComponent extends AbstractCreateController<PermutationDto, PermutationCriteria, PermutationAdminService>  implements OnInit {

    private _permutationItemsElement = new PermutationItemDto();


   private _validPermutationDatePermutation = true;
    private _validPermutationItemsProduit = true;
    private _validPermutationItemsQuantite = true;

    constructor( private permutationService: PermutationAdminService , private depotService: DepotAdminService, private produitService: ProduitAdminService, private permutationItemService: PermutationItemAdminService) {
        super(permutationService);
    }

    ngOnInit(): void {
        this.permutationItemsElement.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.permutationItemsElement.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
    }



    validatePermutationItems(){
        this.errorMessages = new Array();
        this.validatePermutationItemsProduit();
        this.validatePermutationItemsQuantite();
    }


    public setValidation(value: boolean){
        this.validPermutationDatePermutation = value;
        this.validPermutationItemsProduit = value;
        this.validPermutationItemsQuantite = value;
    }

    public addPermutationItems() {
        if( this.item.permutationItems == null )
            this.item.permutationItems = new Array<PermutationItemDto>();
       this.validatePermutationItems();
       if (this.errorMessages.length === 0) {
              this.item.permutationItems.push({... this.permutationItemsElement});
              this.permutationItemsElement = new PermutationItemDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs',detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
       }
    }


    public deletepermutationItems(p: PermutationItemDto) {
        this.item.permutationItems.forEach((element, index) => {
            if (element === p) { this.item.permutationItems.splice(index, 1); }
        });
    }

    public editpermutationItems(p: PermutationItemDto) {
        this.permutationItemsElement = {... p};
        this.activeTab = 0;
    }


    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePermutationDatePermutation();
    }

    public validatePermutationDatePermutation(){
        if (this.stringUtilService.isEmpty(this.item.datePermutation)) {
        this.errorMessages.push('Date permutation non valide');
        this.validPermutationDatePermutation = false;
        } else {
            this.validPermutationDatePermutation = true;
        }
    }

    public validatePermutationItemsProduit(){
        if (this.permutationItemsElement.produit == null) {
            this.errorMessages.push('Produit de la permutationItem est  invalide');
            this.validPermutationItemsProduit = false;
        } else {
            this.validPermutationItemsProduit = true;
        }
    }
    public validatePermutationItemsQuantite(){
        if (this.permutationItemsElement.quantite == null) {
            this.errorMessages.push('Quantite de la permutationItem est  invalide');
            this.validPermutationItemsQuantite = false;
        } else {
            this.validPermutationItemsQuantite = true;
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



    get validPermutationDatePermutation(): boolean {
        return this._validPermutationDatePermutation;
    }

    set validPermutationDatePermutation(value: boolean) {
         this._validPermutationDatePermutation = value;
    }

    get validPermutationItemsProduit(): boolean {
        return this._validPermutationItemsProduit;
    }
    set validPermutationItemsProduit(value: boolean) {
        this._validPermutationItemsProduit = value;
    }
    get validPermutationItemsQuantite(): boolean {
        return this._validPermutationItemsQuantite;
    }
    set validPermutationItemsQuantite(value: boolean) {
        this._validPermutationItemsQuantite = value;
    }

    get permutationItemsElement(): PermutationItemDto {
        if( this._permutationItemsElement == null )
            this._permutationItemsElement = new PermutationItemDto();
        return this._permutationItemsElement;
    }

    set permutationItemsElement(value: PermutationItemDto) {
        this._permutationItemsElement = value;
    }

}
