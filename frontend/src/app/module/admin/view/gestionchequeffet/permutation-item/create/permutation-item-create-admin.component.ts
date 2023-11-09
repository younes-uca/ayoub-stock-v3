import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PermutationItemAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationItemAdmin.service';
import {PermutationItemDto} from 'src/app/controller/model/gestionchequeffet/PermutationItem.model';
import {PermutationItemCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationItemCriteria.model';
import {DepotDto} from 'src/app/controller/model/commun/Depot.model';
import {DepotAdminService} from 'src/app/controller/service/admin/commun/DepotAdmin.service';
import {PermutationDto} from 'src/app/controller/model/gestionchequeffet/Permutation.model';
import {PermutationAdminService} from 'src/app/controller/service/admin/gestionchequeffet/PermutationAdmin.service';
import {ProduitDto} from 'src/app/controller/model/stock/Produit.model';
import {ProduitAdminService} from 'src/app/controller/service/admin/stock/ProduitAdmin.service';
@Component({
  selector: 'app-permutation-item-create-admin',
  templateUrl: './permutation-item-create-admin.component.html'
})
export class PermutationItemCreateAdminComponent extends AbstractCreateController<PermutationItemDto, PermutationItemCriteria, PermutationItemAdminService>  implements OnInit {



   private _validPermutationItemProduit = true;
   private _validPermutationItemQuantite = true;
    private _validProduitReference = true;
    private _validProduitBarCode = true;
    private _validProduitCategorie = true;
    private _validProduitDesignation = true;
    private _validProduitQuantite = true;
    private _validDepotLibelle = true;
    private _validDepotCode = true;
    private _validPermutationDatePermutation = true;

    constructor( private permutationItemService: PermutationItemAdminService , private depotService: DepotAdminService, private permutationService: PermutationAdminService, private produitService: ProduitAdminService) {
        super(permutationItemService);
    }

    ngOnInit(): void {
        this.produit = new ProduitDto();
        this.produitService.findAll().subscribe((data) => this.produits = data);
        this.depot = new DepotDto();
        this.depotService.findAll().subscribe((data) => this.depots = data);
        this.permutation = new PermutationDto();
        this.permutationService.findAll().subscribe((data) => this.permutations = data);
    }





    public setValidation(value: boolean){
        this.validPermutationItemProduit = value;
        this.validPermutationItemQuantite = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validatePermutationItemProduit();
        this.validatePermutationItemQuantite();
    }

    public validatePermutationItemProduit(){
        if (this.stringUtilService.isEmpty(this.item.produit)) {
        this.errorMessages.push('Produit non valide');
        this.validPermutationItemProduit = false;
        } else {
            this.validPermutationItemProduit = true;
        }
    }
    public validatePermutationItemQuantite(){
        if (this.stringUtilService.isEmpty(this.item.quantite)) {
        this.errorMessages.push('Quantite non valide');
        this.validPermutationItemQuantite = false;
        } else {
            this.validPermutationItemQuantite = true;
        }
    }


    public async openCreatePermutation(permutation: string) {
    const isPermistted = await this.roleService.isPermitted('Permutation', 'add');
    if(isPermistted) {
         this.permutation = new PermutationDto();
         this.createPermutationDialog = true;
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
    get permutation(): PermutationDto {
        return this.permutationService.item;
    }
    set permutation(value: PermutationDto) {
        this.permutationService.item = value;
    }
    get permutations(): Array<PermutationDto> {
        return this.permutationService.items;
    }
    set permutations(value: Array<PermutationDto>) {
        this.permutationService.items = value;
    }
    get createPermutationDialog(): boolean {
       return this.permutationService.createDialog;
    }
    set createPermutationDialog(value: boolean) {
        this.permutationService.createDialog= value;
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



    get validPermutationItemProduit(): boolean {
        return this._validPermutationItemProduit;
    }

    set validPermutationItemProduit(value: boolean) {
         this._validPermutationItemProduit = value;
    }
    get validPermutationItemQuantite(): boolean {
        return this._validPermutationItemQuantite;
    }

    set validPermutationItemQuantite(value: boolean) {
         this._validPermutationItemQuantite = value;
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
    get validPermutationDatePermutation(): boolean {
        return this._validPermutationDatePermutation;
    }
    set validPermutationDatePermutation(value: boolean) {
        this._validPermutationDatePermutation = value;
    }


}
