import {Component, OnInit} from '@angular/core';
import {AvoirVenteAdminService} from 'src/app/controller/service/admin/stock/AvoirVenteAdmin.service';
import {AvoirVenteDto} from 'src/app/controller/model/stock/AvoirVente.model';
import {AvoirVenteCriteria} from 'src/app/controller/criteria/stock/AvoirVenteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-avoir-vente-list-admin',
  templateUrl: './avoir-vente-list-admin.component.html'
})
export class AvoirVenteListAdminComponent extends AbstractListController<AvoirVenteDto, AvoirVenteCriteria, AvoirVenteAdminService>  implements OnInit {

    fileName = 'AvoirVente';

    entrepriseSocietes: Array<EntrepriseSocieteDto>;
    ventes: Array<VenteDto>;


    constructor( private avoirVenteService: AvoirVenteAdminService  , private depotService: DepotAdminService, private entrepriseSocieteService: EntrepriseSocieteAdminService, private produitService: ProduitAdminService, private avoirVenteItemService: AvoirVenteItemAdminService, private venteService: VenteAdminService) {
        super(avoirVenteService);
    }

    ngOnInit(): void {
        this.findPaginatedByCriteria();
        this.initExport();
        this.initCol();
        this.loadEntrepriseSociete();
        this.loadVente();
    }


    public initCol() {
        this.cols = [
            {field: 'entrepriseSociete?.nom', header: 'Entreprise societe'},
            {field: 'dateAvoir', header: 'Date avoir'},
            {field: 'montant', header: 'Montant'},
            {field: 'vente?.id', header: 'Vente'},
        ];
    }


    public async loadEntrepriseSociete(){
       this.entrepriseSocieteService.findAllOptimized().subscribe(entrepriseSocietes => this.entrepriseSocietes = entrepriseSocietes, error => console.log(error))
    }
    public async loadVente(){
       this.venteService.findAll().subscribe(ventes => this.ventes = ventes, error => console.log(error))
    }

	public initDuplicate(res: AvoirVenteDto) {
        if (res.avoirVenteItems != null) {
             res.avoirVenteItems.forEach(d => { d.avoirVente = null; d.id = null; });
        }
	}


   public prepareColumnExport(): void {
        this.exportData = this.items.map(e => {
            return {
                'Entreprise societe': e.entrepriseSociete?.nom ,
                'Date avoir': this.datePipe.transform(e.dateAvoir , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Vente': e.vente?.id ,
            }
        });

        this.criteriaData = [{
        //'Entreprise societe': this.criteria.entrepriseSociete?.nom ? this.criteria.entrepriseSociete?.nom : environment.emptyForExport ,
            'Date avoir Min': this.criteria.dateAvoirFrom ? this.datePipe.transform(this.criteria.dateAvoirFrom , this.dateFormat) : environment.emptyForExport ,
            'Date avoir Max': this.criteria.dateAvoirTo ? this.datePipe.transform(this.criteria.dateAvoirTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Vente': this.criteria.vente?.id ? this.criteria.vente?.id : environment.emptyForExport ,
        }];
      }
}
