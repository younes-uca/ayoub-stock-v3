import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-vente-view-admin',
  templateUrl: './vente-view-admin.component.html'
})
export class VenteViewAdminComponent extends AbstractViewController<VenteDto, VenteCriteria, VenteAdminService> implements OnInit {

    venteItems = new VenteItemDto();
    venteItemss: Array<VenteItemDto> = [];
    avoirs = new AvoirVenteDto();
    avoirss: Array<AvoirVenteDto> = [];

    constructor(private venteService: VenteAdminService, private depotService: DepotAdminService, private tauxTvaService: TauxTvaAdminService, private venteItemService: VenteItemAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private etatVenteService: EtatVenteAdminService, private produitService: ProduitAdminService, private clientService: ClientAdminService, private avoirVenteService: AvoirVenteAdminService){
        super(venteService);
    }

    ngOnInit(): void {
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


}
