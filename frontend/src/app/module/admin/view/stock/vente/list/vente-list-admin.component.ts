import {Component, OnInit} from '@angular/core';
import {VenteAdminService} from 'src/app/controller/service/admin/stock/VenteAdmin.service';
import {VenteDto} from 'src/app/controller/model/stock/Vente.model';
import {VenteCriteria} from 'src/app/controller/criteria/stock/VenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-vente-list-admin',
  templateUrl: './vente-list-admin.component.html'
})
export class VenteListAdminComponent extends AbstractListController<VenteDto, VenteCriteria, VenteAdminService>  implements OnInit {

    fileName = 'Vente';

    entrepriseSocietes: Array<EntrepriseSocieteDto>;
    clients: Array<ClientDto>;
    etatVentes: Array<EtatVenteDto>;


    constructor( private venteService: VenteAdminService  , private depotService: DepotAdminService, private tauxTvaService: TauxTvaAdminService, private venteItemService: VenteItemAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private etatVenteService: EtatVenteAdminService, private produitService: ProduitAdminService, private clientService: ClientAdminService, private avoirVenteService: AvoirVenteAdminService) {
        super(venteService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadEntrepriseSociete();
        this.loadClient();
        this.loadEtatVente();
    }


    public initCol() {
        this.cols = [
            {field: 'entrepriseSociete?.nom', header: 'Entreprise societe'},
            {field: 'codeVente', header: 'Code vente'},
            {field: 'client?.cin', header: 'Client'},
            {field: 'etatVente?.libelle', header: 'Etat vente'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTva', header: 'Montant tva'},
            {field: 'montantTtc', header: 'Montant ttc'},
        ];
    }


    public async loadEntrepriseSociete(){
       this.entrepriseSocieteService.findAllOptimized().subscribe(entrepriseSocietes => this.entrepriseSocietes = entrepriseSocietes, error => console.log(error))
    }
    public async loadClient(){
       this.clientService.findAllOptimized().subscribe(clients => this.clients = clients, error => console.log(error))
    }
    public async loadEtatVente(){
       this.etatVenteService.findAllOptimized().subscribe(etatVentes => this.etatVentes = etatVentes, error => console.log(error))
    }

	public initDuplicate(res: VenteDto) {
        if (res.venteItems != null) {
             res.venteItems.forEach(d => { d.vente = null; d.id = null; });
        }
        if (res.avoirs != null) {
             res.avoirs.forEach(d => { d.vente = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Entreprise societe': e.entrepriseSociete?.nom ,
                 'Code vente': e.codeVente ,
                'Client': e.client?.cin ,
                'Etat vente': e.etatVente?.libelle ,
                 'Montant ht': e.montantHt ,
                 'Montant tva': e.montantTva ,
                 'Montant ttc': e.montantTtc ,
                 'Description': e.description ,
            }
        });

        this.criteriaData = [{
        //'Entreprise societe': this.criteria.entrepriseSociete?.nom ? this.criteria.entrepriseSociete?.nom : environment.emptyForExport ,
            'Code vente': this.criteria.codeVente ? this.criteria.codeVente : environment.emptyForExport ,
        //'Client': this.criteria.client?.cin ? this.criteria.client?.cin : environment.emptyForExport ,
        //'Etat vente': this.criteria.etatVente?.libelle ? this.criteria.etatVente?.libelle : environment.emptyForExport ,
            'Montant ht Min': this.criteria.montantHtMin ? this.criteria.montantHtMin : environment.emptyForExport ,
            'Montant ht Max': this.criteria.montantHtMax ? this.criteria.montantHtMax : environment.emptyForExport ,
            'Montant tva Min': this.criteria.montantTvaMin ? this.criteria.montantTvaMin : environment.emptyForExport ,
            'Montant tva Max': this.criteria.montantTvaMax ? this.criteria.montantTvaMax : environment.emptyForExport ,
            'Montant ttc Min': this.criteria.montantTtcMin ? this.criteria.montantTtcMin : environment.emptyForExport ,
            'Montant ttc Max': this.criteria.montantTtcMax ? this.criteria.montantTtcMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        }];
      }
}
